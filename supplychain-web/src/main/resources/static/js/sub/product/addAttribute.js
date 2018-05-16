window.baseUrl = $("#base_url").val();

var addAttributeMethodUrl = {
    // 新增属性保存
    addAttribute: window.baseUrl + "/mk/attribute/add",

    // 按条件,查询类目树
    getCategoryList: window.baseUrl + "/mk/product/category/getCategoryList"
};

$(function () {


    function addAttribute() {
        $.ajax({
            url: addAttributeMethodUrl.addAttribute,
            type: "post",
            data: $("#validForm").serialize(),
            dataType: "json",
            success: function (res) {
                loaded();
                if (res.code === 200) {
                    window.parent.vm.closeDialog(window.parent.addAttributeView, "保存成功");
                } else {

                }
            }
        });
    }

    function getCategoryList(parentId, level) {
        $.ajax({
            url: addAttributeMethodUrl.getCategoryList,
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
            attributeOneList: [],
            attributeTwoList: [],
            attributeThreeList: [],
            attrValue: [],
            inputVisible: false,
            inputValue: '',
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
                // layer.msg("正确消息", {icon: 1, shade: [0.1, '#fff']})
                // // 错误提示消息样式
                // layer.msg("错误消息", {icon: 2, shade: [0.1, '#fff']})
                if (window.vm.attrValue.length == 0) {
                    $("<span id='a_error' style='display: block;color: red;line-height: 29px;'>请添加属性值</span>").appendTo($("#a_btn").parent())
                } else {
                    $("#a_error").remove();
                }


                // $("#form1").validate().element($("#salary"))
                if ($("#validForm").valid()) {
                    loading();
                    var parentId = $("#attributeThree option:selected").data("parentId");
                    var topId = $("#attributeThree option:selected").data("topId");
                    $("#parentId").val(parentId);
                    $("#topId").val(topId);
                    $("#categoryId").val($("#attributeThree").val());
                    addAttribute();
                }
            },
            cancel: function () {
                window.parent.vm.closeDialog(window.parent.addAttributeView, "");
            },
            // 删除标签
            handleClose(tag) {
                this.attrValue.splice(this.attrValue.indexOf(tag), 1);
                $("#attrValues").val(this.skuValue.join(","));
            },
            // 获取焦点让用户输入
            showInput() {
                this.inputVisible = true;
                this.$nextTick(function () {
                    this.$refs.saveTagInput.$refs.input.focus();
                });
            },
            // 确认
            handleInputConfirm() {
                var inputValue = this.inputValue
                if (inputValue && inputValue.trim().length > 0) {
                    var val = inputValue.trim();
                    this.attrValue.push(val);
                    $("#a_error").remove();
                    $("#attrValues").val(this.attrValue.join(","));
                } else {
                    return false;
                }
                this.inputVisible = false;
                this.inputValue = '';
            },
        }
    })


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
            },
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

    $("#inputType").change(function () {
        if ($(this).val() == '01.input') {
            $("#input-type").show();
            $("#select-type").hide();
            window.vm.attrValue = []

        } else if ($(this).val() == '02.select') {
            $("#input-type").hide();
            $("#select-type").show();
        } else {
            window.vm.attrValue = []
            $("#input-type").hide();
            $("#select-type").hide();
        }
    });


});

