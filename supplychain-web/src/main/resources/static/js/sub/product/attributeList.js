window.baseUrl = $("#base_url").val();
window.page = 1;
window.size = 5;

var attributeMethodUrl = {
    // 查询属性列表
    getAttributeList: window.baseUrl + "/mk/attribute/list",

    // 跳转新增属性页面
    toAddAttribute: window.baseUrl + "/mk/attribute/toAddAttribute",

    // 跳转修改属性页面
    toEditAttribute: window.baseUrl + "/mk/attribute/toEditAttribute",

    // 跳转到属性值页面
    toAttributeValueList: window.baseUrl + "/mk/attribute/value/toAttributeValueList",

    // 按条件,查询类目树
    getCategoryList: window.baseUrl + "/mk/product/category/getCategoryList",

    // 更新启用停用状态
    updateAttribute: window.baseUrl + "/mk/attribute/update"
};

$(function () {

    function getAttributeList(sortColumn, sortOrder) {
        $.ajax({
            url: attributeMethodUrl.getAttributeList,
            type: "post",
            data: {
                page: window.page,
                size: window.size,
                sortColumn: sortColumn || "default",
                sortOrder: sortOrder || "",
                status: $('input[name="status"]:checked ').val(),
                categoryId: $("#attributeThree").val(),
                parentId: $("#attributeTwo").val(),
                topId: $("#attributeOne").val()
            },
            dataType: "json",
            success: function (res) {
                if (res.code === 200) {
                    vm.list = res.data.list;
                    vm.total = res.data.total;
                    // laypage({
                    //     cont: 'demo1',
                    //     pages: res.data.pages, // 总页数,
                    //     curr: curr || 1, // 当前页
                    //     jump: function (obj, first) { // 触发分页后的回调
                    //         if (!first) { // 点击跳页触发函数自身，并传递当前页：obj.curr
                    //             getAttributeList(obj.curr);
                    //         }
                    //     }
                    //     // 连续显示分页数
                    // });
                    // $("table").next().find('>p').remove();
                    // if (res.data.total > 0) {
                    //     $("table").next().find('>p').remove();
                    //     $("#itemcounts").parent().show();
                    //     $("#itemcounts").html(res.data.total);
                    // } else if (res.data.total == 0) {
                    //     $("#itemcounts").parent().hide();
                    //     $("table").next().append('<p style="text-align: center;">暂无记录 </p>')
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

    function getCategoryList(parentId, level) {
        $.ajax({
            url: attributeMethodUrl.getCategoryList,
            type: "post",
            data: {parentId: parentId},
            dataType: "json",
            success: function (res) {
                if (res.code === 200) {
                    if (level === 1) {
                        window.vm.attributeOneList = res.data
                    } else if (level === 2) {
                        window.vm.attributeTwoList = res.data
                    } else if (level === 3) {
                        window.vm.attributeThreeList = res.data
                    }
                } else {

                }
            }
        });
    }

    function updateAttribute(id, status) {
        $.ajax({
            url: attributeMethodUrl.updateAttribute,
            type: "post",
            data: {
                id: id,
                status: status
            },
            dataType: "json",
            success: function (res) {
                loaded();
                if (res.code === 200) {
                    getAttributeList(0);
                    if (status === "01.enable") {
                        top.layer.msg("启用成功", {icon: 1, shade: [0.1, '#fff']});
                    } else if (status === "02.disable") {
                        top.layer.msg("禁用成功", {icon: 1, shade: [0.1, '#fff']});
                    } else {
                        top.layer.msg("删除成功", {icon: 1, shade: [0.1, '#fff']});
                    }
                } else {
                    if (status === "01.enable") {
                        top.layer.msg("启用失败", {icon: 2, shade: [0.1, '#fff']});
                    } else if (status === "02.disable") {
                        top.layer.msg("禁用失败", {icon: 2, shade: [0.1, '#fff']});
                    } else {
                        top.layer.msg("删除失败", {icon: 2, shade: [0.1, '#fff']});
                    }
                }
            }
        });
    }


    window.vm = new Vue({
        el: '#attribute-main',
        data: {
            list: [],
            attributeOneList: [],
            attributeTwoList: [],
            attributeThreeList: [],
            total: ""
        },
        mounted: function () {
            $(window.parent).scrollTop(0);
            // DatePicker("#startTime", "#endTime");
            getAttributeList(0);
            getCategoryList(1, 1);

        },
        updated: function () {
            /*由于数据更改导致的虚拟 DOM 重新渲染和打补丁，在这之后会调用该钩子。
             当这个钩子被调用时，组件 DOM 已经更新，所以你现在可以执行依赖于 DOM 的操作。然而在大多数情况下，你应该避免在此期间更改状态，因为这可能会导致更新无限循环。
             该钩子在服务器端渲染期间不被调用*/
        },
        methods: {
            // 新增
            add: function () {
                window.addAttributeView = layer.open({
                    type: 2,
                    title: '新增属性',
                    skin: 'layui-layer-lan',
                    shadeClose: false,
                    shade: 0.5,
                    closeBtn: 1,
                    area: ['800px', '550px'],
                    offset: ['10px', '20px'],
                    content: attributeMethodUrl.toAddAttribute, //iframe的url
                    success: function (obj, index) {
                        $(obj).find('#validForm').focus();
                    }
                });
            },
            search: function () {
                // var status = $('input[name="status"]:checked ').val();
                // var topId=$("#attributeOne").val();
                // var parentId=$("#attributeTwo").val();
                // var categoryId=$("#attributeThree").val();
                getAttributeList(0);
            },
            // 关闭对话框
            closeDialog: function (view, obj) {
                layer.close(view);
                if (obj !== "") {
                    getAttributeList(0);
                    top.layer.msg(obj, {icon: 1, shade: [0.1, '#fff']});
                }
            },
            // 查看 属性值
            showDetail: function (attrId) {
                window.location.href = attributeMethodUrl.toAttributeValueList + "?attrId=" + attrId;
                $(window.parent.document).find('.tab-content .active iframe').attr('src', attributeMethodUrl.toAttributeValueList + "?attrId=" + attrId);
            },
            editEnable: function (id) {
                loading();
                updateAttribute(id, "01.enable");
            },
            editDisable: function (id) {
                loading();
                updateAttribute(id, "02.disable");
            },
            deleteOne: function (id) {
                layer.confirm('你确定要删除选中的属性吗？', {
                    // 标题
                    title: "确认删除",
                    // 按钮
                    btn: ['确定', '取消'],
                    shade: [0.1, '#fff']
                }, function (index) {
                    layer.close(index);
                    loading();
                    updateAttribute(id, "03.delete");
                }, function (index) {
                    layer.close(index);
                });
            },
            edit: function (id) {
                window.id = id;
                window.editAttributeView = layer.open({
                    type: 2,
                    title: '修改属性',
                    skin: 'layui-layer-lan',
                    shadeClose: false,
                    shade: 0.5,
                    closeBtn: 1,
                    area: ['800px', '550px'],
                    offset: ['10px', '20px'],
                    content: attributeMethodUrl.toEditAttribute, //iframe的url
                    success: function (obj, index) {
                        $(obj).find('#validForm').focus();
                    }
                });
            },
            handleSizeChange: function (val) {
                window.size = val;
                getAttributeList()
            },
            handleCurrentChange: function (val) {
                window.page = val;
                getAttributeList()
            },
            handleSortChange: function (obj) {
                console.log("column:" + obj);
                console.log("prop:" + obj.prop);
                console.log("order:" + obj.order);  // descending  ascending
                getAttributeList(obj.prop, obj.order);
            }
        }
    });
// 一级下拉框
    $("#attributeOne").change(function () {
        $("#attributeTwo").val("");
        vm.attributeTwo = [];
        $("#attributeThreeList").val("");
        vm.attributeThreeList = [];
        if ($(this).val() != '') {
            getCategoryList($(this).val(), 2)
        }
    });

    // 二级下拉框
    $("#attributeTwo").change(function () {
        $("#attributeThreeList").val("");
        vm.attributeThreeList = [];
        if ($(this).val() != '') {
            getCategoryList($(this).val(), 3)
        }
    });

});

