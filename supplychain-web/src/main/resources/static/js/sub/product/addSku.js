window.baseUrl = $("#base_url").val();

var addSkuMethodUrl = {
    // 新增属性保存
    addSku: window.baseUrl + "/mk/sku/attribute/add",

    // 按条件,查询类目树
    getCategoryList: window.baseUrl + "/mk/product/category/getCategoryList"
};

$(function () {

    function addSku() {
        $.ajax({
            url: addSkuMethodUrl.addSku,
            type: "post",
            data: $("#validForm").serialize(),
            dataType: "json",
            success: function (res) {
                if (res.code === 200) {
                    window.parent.vm.closeDialog(window.parent.addAttributeView, "保存成功");
                } else {

                }
            }
        });
    }

    function getCategoryList(parentId, level) {
        $.ajax({
            url: addSkuMethodUrl.getCategoryList,
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

    window.vm = new Vue({
        el: '#attribute-main',
        data: {
            attributeOneList: [],
            attributeTwoList: [],
            attributeThreeList: []
        },
        mounted: function () {
            getCategoryList(1, 1);
        },
        methods: {
            save: function () {
                // // ajax请求前必须调用,打开loading效果
                // loading();
                // // ajax无论success/fail 都要关闭
                // loaded();
                // // 成功提示消息样式
                // layer.msg("正确消息", {icon: 1})
                // // 错误提示消息样式
                // layer.msg("错误消息", {icon: 2})

                // $("#form1").validate().element($("#salary"))
                if ($("#validForm").valid()) {

                    var parentId = $("#attributeThree option:selected").data("parentId");
                    var topId = $("#attributeThree option:selected").data("topId");
                    $("#parentId").val(parentId);
                    $("#topId").val(topId);
                    $("#categoryId").val($("#attributeThree").val());
                    addSku();
                }
            },
            cancel: function () {
                window.parent.vm.closeDialog(window.parent.addAttributeView, "");
            }
        }
    });

    // 表单验证
    $("#validForm").validate({
        rules: {
            "skuAttrId": {
                required: true,
                digits: true
            },
            "skuAttrName": {
                required: true
            },
            "sort": {
                required: true
            },
            "columnType": {
                required: true
            },
            "attributeThree": {
                required: true
            }
        },
        messages: {
            "skuAttrId": {
                required: '请输入属性ID',
                digits: '请输入整数'
            },
            "sort": {
                required: '请输入排序值',
                digits: '请输入整数'
            },
            "skuAttrName": {
                required: '请输入属性名称'
            },
            "columnType": {
                required: '请选择录入类型'
            },
            "attributeThree": {
                required: '请选择类目'
            }
        },
        errorClass: "help-inline",
        errorElement: "span",
        errorPlacement: function (error, element) {
            // 错误信息放置位置
            error.appendTo(element.parent().parent());
        }
    });

    // 一级下拉框
    $("#attributeOne").change(function () {
        $("#attributeTwo").val("");
        vm.attributeTwoList = [];
        $("#attributeThree").val("");
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

