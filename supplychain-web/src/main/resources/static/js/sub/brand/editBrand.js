window.baseUrl = $("#base_url").val();

var editBrandMethodUrl = {
    // 新增属性保存
    editBrand: window.baseUrl + "/mk/brand/update",

    // 查询品牌
    getBrandDetail: window.baseUrl + "/mk/brand/detail"
};

$(function () {

    function getBrandDetail() {
        $.ajax({
            url: editBrandMethodUrl.getBrandDetail,
            type: "post",
            data: {id: window.parent.id},
            dataType: "json",
            success: function (res) {
                if (res.code === 200) {
                    window.vm.brand = res.data;
                } else {

                }
            }
        });
    }

    function editBrand() {
        $.ajax({
            url: editBrandMethodUrl.editBrand,
            type: "post",
            data: $("#validForm").serialize(),
            dataType: "json",
            success: function (res) {
                if (res.code === 200) {
                    window.parent.vm.closeDialog(window.parent.editBrandView, "修改成功");
                } else {

                }
            }
        });
    }

    window.vm = new Vue({
        el: '#attribute-main',
        data: {
            brand: []
        },
        mounted: function () {
            getBrandDetail();
        },
        methods: {
            save: function () {
                if ($("#validForm").valid()) {
                    $("#id").val(window.parent.id);
                    editBrand();
                }
            },
            cancel: function () {
                window.parent.vm.closeDialog(window.parent.editBrandView, "");
            }
        }
    });

    // 表单验证
    $("#validForm").validate({
        rules: {
            "brandName": {
                required: true
            }
        },
        messages: {
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

