window.baseUrl = $("#base_url").val();

var editAttributeMethodUrl = {
    // 新增属性保存
    editAttribute: window.baseUrl + "/mk/attribute/update",

    // 查询属性detail
    getAttributeDetail: window.baseUrl + "/mk/attribute/detail",

    // 按条件,查询类目树
    getCategoryList: window.baseUrl + "/mk/product/category/getCategoryList",
};

$(function () {


    function getAttributeDetail() {
        $.ajax({
            url: editAttributeMethodUrl.getAttributeDetail,
            type: "post",
            data: {id: window.parent.id},
            dataType: "json",
            success: function (res) {
                if (res.code === 200) {
                    getCategoryList(res.data.topId, 2);
                    getCategoryList(res.data.parentId, 3);
                    window.vm.attribute = res.data;
                    window.vm.attributeOne = res.data.topId;
                    window.vm.attributeTwo = res.data.parentId;
                    window.vm.attributeThree = res.data.categoryId;
                } else {

                }
            }
        });
    }


    function editAttribute() {
        $.ajax({
            url: editAttributeMethodUrl.editAttribute,
            type: "post",
            data: $("#validForm").serialize(),
            dataType: "json",
            success: function (res) {
                if (res.code === 200) {
                    window.parent.vm.closeDialog(window.parent.editAttributeView, "修改成功");
                } else {

                }
            }
        });
    }

    function getCategoryList(parentId, level) {
        $.ajax({
            url: editAttributeMethodUrl.getCategoryList,
            type: "post",
            data: {parentId: parentId},
            dataType: "json",
            success: function (res) {
                if (res.code === 200) {
                    if (level == 1) {
                        window.vm.attributeOneList = res.data
                    } else if (level == 2) {
                        window.vm.attributeTwoList = res.data
                    } else if (level == 3) {
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
            attribute: [],
            attributeOneList: [],
            attributeTwoList: [],
            attributeThreeList: [],
            attributeOne: "",
            attributeTwo: "",
            attributeThree: ""
        },
        mounted: function () {
            getCategoryList(1, 1);
            getAttributeDetail();
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


                if ($("#validForm").valid()) {

                    var parentId = $("#attributeThree option:selected").data("parentId");
                    var topId = $("#attributeThree option:selected").data("topId");
                    $("#parentId").val(parentId);
                    $("#topId").val(topId);
                    $("#categoryId").val($("#attributeThree").val());
                    $("#id").val(window.parent.id);


                    editAttribute();
                }
            },
            cancel: function () {
                window.parent.vm.closeDialog(window.parent.editAttributeView, "");
            }
        }
    });


    // 表单验证
    $("#validForm").validate({
        rules: {
            "attrId": {
                required: true,
                digits: true
            },
            "attrName": {
                required: true
            },
            "attrType": {
                required: true
            },
            "isRequired": {
                required: true
            },
            "isSearch": {
                required: true
            },
            "inputType": {
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
            "attrId": {
                required: '请输入属性ID',
                digits: '请输入整数'
            },
            "attrName": {
                required: '请输入属性名称'
            },
            "attrType": {
                required: '请选择属性类型'
            },
            "isRequired": {
                required: '请选择是否必填'
            },
            "inputType": {
                required: '请选择录入类型'
            },
            "isSearch": {
                required: '请选择是否筛选'
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

        $("#attributeTwo").empty();
        var option = $("<option>").val("").text("请选择");
        $("#attributeTwo").append(option);
        vm.attributeTwo = "";
        vm.attributeTwoList = [];

        $("#attributeThree").empty();
        var option = $("<option>").val("").text("请选择");
        $("#attributeThree").append(option);
        vm.attributeThree = "";
        vm.attributeThreeList = [];


        if ($(this).val() != '') {
            getCategoryList($(this).val(), 2)
        }
    });

    // 二级下拉框
    $("#attributeTwo").change(function () {
        $("#attributeThree").empty();
        var option = $("<option>").val("").text("请选择");
        $("#attributeThree").append(option);
        vm.attributeThree = "";
        vm.attributeThreeList = [];

        if ($(this).val() != '') {
            getCategoryList($(this).val(), 3)
        }
    });


});

