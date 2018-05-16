window.baseUrl = $("#base_url").val();

var addOrderMethodUrl = {
    // 跳转(期货)采购列表
    toBuyOrderList: window.baseUrl + "/mk/buy/order/toBuyOrderList",

    // 按条件,查询类目树
    getCategoryList: window.baseUrl + "/mk/product/category/getCategoryList",

    // 按条件,查询类目树
    getBrandList: window.baseUrl + "/mk/brand/getBrandList",

    // 按品牌,类目 查询商品SKU列表(采购挑选)
    getProductSkuList: window.baseUrl + "/mk/product/sku/getProductSkuList",


    // 新增属性保存
    addAttribute: window.baseUrl + "/mk/attribute/add",

};

$(function () {

    function getCategoryList(parentId, level) {
        $.ajax({
            url: addOrderMethodUrl.getCategoryList,
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

    function getBrandList() {
        $.ajax({
            url: addOrderMethodUrl.getBrandList,
            type: "post",
            data: {},
            dataType: "json",
            success: function (res) {
                if (res.code === 200) {
                    window.vm.brandList = res.data
                } else {

                }
            }
        });
    }

    function getProductSkuList(brandId) {
        $.ajax({
            url: addOrderMethodUrl.getProductSkuList,
            type: "post",
            data: {
                brandId: brandId,
                categoryId: $("#attributeOne").val(),
                parentId: $("#attributeTwo").val(),
                topId: $("#attributeThree").val()
            },
            dataType: "json",
            success: function (res) {
                if (res.code === 200) {
                    window.vm.productSkuList = res.data
                } else {

                }
            }
        });
    }


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


    window.vm = new Vue({
        el: '#attribute-main',
        data: {
            brandList: [],
            list: [],
            attributeOneList: [],
            attributeTwoList: [],
            attributeThreeList: [],
            productSkuList: []
        },
        // watch: {
        //     brandList: function () {
        //         // $('.selectPicker').selectpicker("");
        //     }
        // },
        mounted: function () {
            DatePickerOne("#startTime");
            getCategoryList(1, 1);
            getBrandList();
        },
        updated: function () {
            if (window.vm.brandList.length > 0) {
                $('.selectPicker').selectpicker("");
            }
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
            // 返回
            returnMainFrame: function () {
                window.location.href = addOrderMethodUrl.toBuyOrderList;
                $(window.parent.document).find('.tab-content .active iframe').attr('src', addOrderMethodUrl.toBuyOrderList)
            },
            objectSpanMethod: function (obj) {


                // {row, column, rowIndex, columnIndex}
                if (obj.columnIndex === 0 || obj.columnIndex === 1 || obj.columnIndex === 2) {
                    if (window.vm.productSkuList.length > 1) {
                        return a(obj.rowIndex, 1);
                    }
                }
            }
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

    $('.selectPicker').on('changed.bs.select', function (e) {
        getProductSkuList($(this).val());
    });


    function a(index, rowspan) {
        if (index == 0) {
            return calculationMerge(index, rowspan)
        } else {
            var sku = window.vm.productSkuList[index];
            var skuPre = window.vm.productSkuList[index - 1];
            if (sku.PRODUCT_ID == skuPre.PRODUCT_ID) {
                return {rowspan: 0, colspan: 0};
            } else {
                return calculationMerge(index, rowspan);
            }
        }
    }


    function calculationMerge(index, rowspan) {
        // console.log(obj.rowIndex)
        if (index == window.vm.productSkuList.length - 1) {
            var sku = window.vm.productSkuList[index];
            var skuPre = window.vm.productSkuList[index - 1];
            if (sku.PRODUCT_ID == skuPre.PRODUCT_ID) {
                return {rowspan: 0, colspan: 0};
            } else {
                return {rowspan: 1, colspan: 1};
            }
        } else {
            var sku = window.vm.productSkuList[index];
            var skuNext = window.vm.productSkuList[index + 1];
            if (sku.PRODUCT_ID == skuNext.PRODUCT_ID) {
                return calculationMerge(index + 1, rowspan + 1);
            } else {
                return {rowspan: rowspan, colspan: 1};
            }
        }

    }


});

