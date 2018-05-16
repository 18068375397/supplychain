window.baseUrl = $("#base_url").val();

var addAttributeValueMethodUrl = {
    // 新增属性值保存
    addAttributeValue: window.baseUrl + "/mk/attribute/value/add"
};

$(function () {

    function addAttributeValue() {
        $.ajax({
            url: addAttributeValueMethodUrl.addAttributeValue,
            type: "post",
            data: $("#valueForm").serialize(),
            dataType: "json",
            success: function (res) {
                if (res.code === 200) {
                    window.parent.vm.closeDialog(window.parent.addAttributeValueView, "保存成功");
                } else {

                }
            }
        });
    }

    window.vm = new Vue({
        el: '#attribute-main',
        data: {
            list: [],
            attrId: window.parent.attrId
        },
        mounted: function () {

        },
        methods: {
            save: function () {
                if ($("#valueForm").valid()) {
                    addAttributeValue();
                }
            },
            cancel: function () {
                window.parent.vm.closeDialog(window.parent.addAttributeValueView, "");
            }
        }
    });


    // 表单验证
    $("#valueForm").validate({
        rules: {
            "valueId": {
                required: true,
                digits: true
            },
            "valueName": {
                required: true
            },
            "status": {
                required: true
            }
        },
        messages: {
            "valueId": {
                required: '请输入属性值ID',
                digits: '请输入整数'
            },
            "valueName": {
                required: '请输入属性值名称'
            },
            "status": {
                required: '请选择状态'
            }
        },
        errorClass: "help-inline",
        errorElement: "span",
        errorPlacement: function (error, element) {
            // 错误信息放置位置
            error.appendTo(element.parent().parent());
        }
    });
});

