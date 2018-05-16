window.baseUrl = $("#base_url").val();
window.page = 1;
window.size = 5;

var brandMethodUrl = {
    // 查询品牌列表
    getBrandList: window.baseUrl + "/mk/brand/list",

    // 跳转新增品牌页面
    toAddBrand: window.baseUrl + "/mk/brand/toAddBrand",

    // 跳转修改品牌页面
    toEditBrand: window.baseUrl + "/mk/brand/toEditBrand",

    // 更新启用停用状态
    updateBrand: window.baseUrl + "/mk/brand/update",

    // 查询商品列表
    getProductList: window.baseUrl + "/mk/product/queryList"
};

$(function () {

    function getBrandList(sortColumn, sortOrder) {
        $.ajax({
            url: brandMethodUrl.getBrandList,
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
                    // laypage({
                    //     cont: 'demo1',
                    //     pages: res.data.pages, // 总页数,
                    //     curr: curr || 1, // 当前页
                    //     jump: function (obj, first) { // 触发分页后的回调
                    //         if (!first) { // 点击跳页触发函数自身，并传递当前页：obj.curr
                    //             getBrandList(obj.curr);
                    //         }
                    //     }
                    //     // 连续显示分页数
                    // });
                    //
                    // var table = $("table");
                    // var itemCounts = $("#itemcounts");
                    // table.next().find('>p').remove();
                    // if (res.data.total > 0) {
                    //     table.next().find('>p').remove();
                    //     itemCounts.parent().show();
                    //     itemCounts.html(res.data.total);
                    // } else if (res.data.total === 0) {
                    //     itemCounts.parent().hide();
                    //     table.next().append('<p style="text-align: center;">暂无记录 </p>')
                    //
                    // }
                    //
                    // if (res.data.pages < 2)
                    //     $('#demo1').hide();
                    // else
                    //     $('#demo1').show();
                } else {

                }
            }
        });
    }

    // 根据brandId查询商品数
    function getProductList(brandId) {
        $.ajax({
            url: brandMethodUrl.getProductList,
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
                        updateBrand(id, "03.delete");
                    }
                } else {

                }
            }
        });
    }

    function updateBrand(id, status) {
        $.ajax({
            url: brandMethodUrl.updateBrand,
            type: "post",
            data: {
                id: id,
                status: status
            },
            dataType: "json",
            success: function (res) {
                loaded();
                if (res.code === 200) {
                    getBrandList(0);
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
            getBrandList(0);

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
                    content: brandMethodUrl.toAddBrand, //iframe的url
                    success: function (obj) {
                        $(obj).find('#validForm').focus();
                    }
                });
            },
            search: function () {
                getBrandList(0);
            },
            // 关闭对话框
            closeDialog: function (view, obj) {
                layer.close(view);
                if (obj !== "") {
                    getBrandList(0);
                    top.layer.msg(obj, {icon: 1, shade: [0.1, '#fff']});
                }
            },
            editEnable: function (id) {
                loading();
                updateBrand(id, "01.enable");
            },
            editDisable: function (id) {
                loading();
                updateBrand(id, "02.disable");
            },
            deleteOne: function (id, brandId) {
                window.id = id;
                layer.confirm('你确定要删除选中的品牌吗？', {
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
                    title: '修改品牌',
                    skin: 'layui-layer-lan',
                    shadeClose: false,
                    shade: 0.5,
                    closeBtn: 1,
                    area: ['800px', '300px'],
                    offset: ['10px', '20px'],
                    content: brandMethodUrl.toEditBrand, //iframe的url
                    success: function (obj) {
                        $(obj).find('#validForm').focus();
                    }
                });
            },
            handleSizeChange: function (val) {
                window.size = val;
                getBrandList()
            },
            handleCurrentChange: function (val) {
                window.page = val;
                getBrandList()
            },
            handleSortChange: function (obj) {
                console.log("column:" + obj);
                console.log("prop:" + obj.prop);
                console.log("order:" + obj.order);  // descending  ascending
                getBrandList(obj.prop, obj.order);
            }
        }
    });

});

