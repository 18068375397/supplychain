window.baseUrl = $("#base_url").val();
window.page = 1;
window.size = 5;

var warehouseMethodUrl = {
    // 查询列表
    getWarehouseList: window.baseUrl + "/mk/warehouse/list",

    // 跳转新增页面
    toAddWarehouse: window.baseUrl + "/mk/warehouse/toAddWarehouse",

    // 跳转修改页面
    toEditWarehouse: window.baseUrl + "/mk/warehouse/toEditWarehouse",

    // 修改
    updateWarehouse: window.baseUrl + "/mk/warehouse/update",

    // 查询商品列表
    getProductList: window.baseUrl + "/mk/product/queryList"
};

$(function () {

    function getWarehouseList(sortColumn, sortOrder) {
        $.ajax({
            url: warehouseMethodUrl.getWarehouseList,
            type: "post",
            data: {
                page: window.page,
                size: window.size,
                sortColumn: sortColumn || "default",
                sortOrder: sortOrder || "",
                status: "01.enable"
            },
            dataType: "json",
            success: function (res) {
                if (res.code === 200) {
                    vm.list = res.data.list;
                    vm.total = res.data.total
                } else {

                }
            }
        });
    }

    // 根据brandId查询商品数
    function getProductList(brandId) {
        $.ajax({
            url: warehouseMethodUrl.getProductList,
            type: "post",
            data: {
                page: 1,
                size: 5,
                brandId: brandId
            },
            dataType: "json",
            success: function (res) {
                if (res.code === 200) {
                    vm.size = res.data.length;
                    if (vm.size > 0) {
                        top.layer.msg("品牌下存在商品，无法删除", {icon: 2, shade: [0.1, '#fff']});
                    }
                    else {
                        updateWarehouse(id, "03.delete");
                    }
                } else {

                }
            }
        });
    }

    function updateWarehouse(id, status) {
        $.ajax({
            url: warehouseMethodUrl.updateWarehouse,
            type: "post",
            data: {
                id: id,
                status: status
            },
            dataType: "json",
            success: function (res) {
                loaded();
                if (res.code === 200) {
                    getWarehouseList(0);
                    top.layer.msg("删除成功", {icon: 1, shade: [0.1, '#fff']});
                } else {
                    top.layer.msg("删除失败", {icon: 2, shade: [0.1, '#fff']});
                }
            }
        });
    }

    window.vm = new Vue({
        el: '#attribute-main',
        data: {
            list: [],
            size: [],
            total: ""
        },
        mounted: function () {
            $(window.parent).scroll(0);
            // DatePicker("#startTime", "#endTime");
            getWarehouseList(0);

        },
        updated: function () {
            /*由于数据更改导致的虚拟 DOM 重新渲染和打补丁，在这之后会调用该钩子。
             当这个钩子被调用时，组件 DOM 已经更新，所以你现在可以执行依赖于 DOM 的操作。然而在大多数情况下，你应该避免在此期间更改状态，因为这可能会导致更新无限循环。
             该钩子在服务器端渲染期间不被调用*/
        },
        methods: {
            // 新增
            add: function () {
                window.addBrandView = layer.open({
                    type: 2,
                    title: '新增品牌',
                    skin: 'layui-layer-lan',
                    shadeClose: false,
                    shade: 0.5,
                    closeBtn: 1,
                    area: ['800px', '300px'],
                    offset: ['10px', '20px'],
                    content: warehouseMethodUrl.toAddWarehouse, //iframe的url
                    success: function (obj) {
                        $(obj).find('#validForm').focus();
                    }
                });
            },
            search: function () {
                getWarehouseList(0);
            },
            // 关闭对话框
            closeDialog: function (view, obj) {
                layer.close(view);
                if (obj !== "") {
                    getWarehouseList(0);
                    top.layer.msg(obj, {icon: 1, shade: [0.1, '#fff']});
                }
            },
            editEnable: function (id) {
                loading();
                updateWarehouse(id, "01.enable");
            },
            editDisable: function (id) {
                loading();
                updateWarehouse(id, "02.disable");
            },
            deleteOne: function (id, brandId) {
                window.id = id;
                layer.confirm('你确定要删除选中的仓库吗？', {
                    // 标题
                    title: "确认删除",
                    // 按钮
                    btn: ['确定', '取消'],
                    offset: '100px'
                }, function (index) {
                    layer.close(index);
                    loading();
                    getProductList(brandId);
                    loaded();
                }, function (index) {
                    layer.close(index);
                });
            },
            edit: function (id) {
                window.id = id;
                window.editBrandView = layer.open({
                    type: 2,
                    title: '修改仓库',
                    skin: 'layui-layer-lan',
                    shadeClose: false,
                    shade: 0.5,
                    closeBtn: 1,
                    area: ['800px', '300px'],
                    offset: ['10px', '20px'],
                    content: warehouseMethodUrl.toEditWarehouse, //iframe的url
                    success: function (obj) {
                        $(obj).find('#validForm').focus();
                    }
                });
            },
            handleSizeChange: function (val) {
                window.size = val;
                getWarehouseList()
            },
            handleCurrentChange: function (val) {
                window.page = val;
                getWarehouseList()
            },
            handleSortChange: function (obj) {
                console.log("column:" + obj);
                console.log("prop:" + obj.prop);
                console.log("order:" + obj.order);  // descending  ascending
                getWarehouseList(obj.prop, obj.order);
            }
        }
    });

});

