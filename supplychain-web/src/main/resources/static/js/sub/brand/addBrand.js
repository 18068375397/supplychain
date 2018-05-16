window.baseUrl = $("#base_url").val();

var addBrandMethodUrl = {
    // 新增属性保存
    addBrand: window.baseUrl + "/mk/brand/add"
};

$(function () {

    function addBrand() {
        $.ajax({
            url: addBrandMethodUrl.addBrand,
            type: "post",
            data: $("#validForm").serialize(),
            dataType: "json",
            success: function (res) {
                if (res.code === 200) {
                    window.parent.vm.closeDialog(window.parent.addBrandView, "保存成功");
                } else {

                }
            }
        });
    }

    window.vm = new Vue({
        el: '#attribute-main',
        data: {},
        mounted: function () {

        },
        methods: {
            save: function () {
                if ($("#validForm").valid()) {
                    addBrand();
                }
            },
            cancel: function () {
                window.parent.vm.closeDialog(window.parent.addBrandView, "");
            }
        }
    });


    // 表单验证
    $("#validForm").validate({
        rules: {
            "brandId": {
                required: true,
                digits: true
            },
            "brandName": {
                required: true
            }
        },
        messages: {
            "brandId": {
                required: '请输入品牌编码',
                digits: '请输入整数'
            },
            "brandName": {
                required: '请输入品牌名称'
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

