window.baseUrl = $("#base_url").val();

var editAttributeValueMethodUrl = {
    // 新增属性保存
    editAttributeValue: window.baseUrl + "/mk/attribute/value/update",

    // 查询属性detail
    getAttributeValueDetail: window.baseUrl + "/mk/attribute/value/detail"
};

$(function () {

    function getAttributeValueDetail() {
        $.ajax({
            url: editAttributeValueMethodUrl.getAttributeValueDetail,
            type: "post",
            data: {id: window.parent.id},
            dataType: "json",
            success: function (res) {
                if (res.code === 200) {
                    $("#id").val(window.parent.id);
                    window.vm.attributeValue = res.data;
                } else {

                }
            }
        });
    }

    function editAttributeValue() {
        $.ajax({
            url: editAttributeValueMethodUrl.editAttributeValue,
            type: "post",
            data: $("#validForm").serialize(),
            dataType: "json",
            success: function (res) {
                if (res.code === 200) {
                    window.parent.vm.closeDialog(window.parent.editAttributeValueView, "修改成功");
                } else {

                }
            }
        });
    }

    window.vm = new Vue({
        el: '#attribute-main',
        data: {
            attributeValue: []
        },
        mounted: function () {
            getAttributeValueDetail();
        },
        methods: {
            save: function () {
                if ($("#validForm").valid()) {
                    editAttributeValue();
                }
            },
            cancel: function () {
                window.parent.vm.closeDialog(window.parent.editAttributeValueView, "");
            }
        }
    });


    // 表单验证
    $("#validForm").validate({
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

