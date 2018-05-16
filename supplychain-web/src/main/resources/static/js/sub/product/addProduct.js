window.baseUrl = $("#base_url").val();

var addProductMethodUrl = {

    // 按条件,查询类目树
    getCategoryList: window.baseUrl + "/mk/product/category/getCategoryList",

    // 按条件,查询拓展属性
    getAttributeListByCategoryId: window.baseUrl + "/mk/attribute/getAttributeList",

    // 按条件,查询销售属性
    getSkuAttrListByCategoryId: window.baseUrl + "/mk/sku/attribute/getSkuAttrList",

    // 添加商品
    addProduct: window.baseUrl + "/mk/product/add",

    // 跳转商品列表
    toProductList: window.baseUrl + "/mk/product/toProductList"

};

$(function () {


    function addProduct(params) {
        $.ajax({
            url: addProductMethodUrl.addProduct,
            type: "post",
            data: params,
            dataType: "json",
            success: function (res) {
                if (res.code === 200) {
                    loaded();
                    top.layer.msg("保存成功", {
                        icon: 1,
                        time: 2000,
                        shade: [0.1, '#fff']
                    }, function () {
                        window.vm.returnMainFrame();
                    });
                } else {
                    loaded();
                    top.layer.msg(res.message, {icon: 2, shade: [0.1, '#fff']});
                }
            }
        });
    }

    function getCategoryList(parentId, level) {
        $.ajax({
            url: addProductMethodUrl.getCategoryList,
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

    function getAttributeListByCategoryId(categoryId) {
        $.ajax({
            url: addProductMethodUrl.getAttributeListByCategoryId,
            type: "post",
            data: {categoryId: categoryId},
            dataType: "json",
            success: function (res) {
                if (res.code === 200) {
                    window.vm.attributeValueList = res.data
                    if (window.vm.attributeValueList.length > 0) {
                        $("#tuozhan").show();
                    }
                } else {
                }
            }
        });
    }


    function getSkuAttrListByCategoryId(categoryId) {
        $.ajax({
            url: addProductMethodUrl.getSkuAttrListByCategoryId,
            type: "post",
            data: {categoryId: categoryId},
            dataType: "json",
            success: function (res) {
                if (res.code === 200) {
                    window.vm.skuAttrValueList = res.data
                    if (window.vm.skuAttrValueList.length > 0) {
                        $("#xiaoshou").show();
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
            attributeValueList: [],
            attrValue: [],
            skuAttrValueList: [],
            skuValue: [],
            list: [],
            inputVisible: false,
            inputValue: '',
            cols: [],
            defaultCols: [{prop: "SKU_CODE", label: "SKU编码"}, {prop: "BUY", label: "采购价"}, {prop: "SAIL", label: "销售价"}]
            // [{prop:"SKU_CODE",label:"SKU编码"},{prop:"BUY",label:"采购价"},{prop:"SAIL",label:"销售价"},{prop:"BUTTON",label:"操作"}]
        },
        watch: {
            skuAttrValueList: function () {
                window.vm.cols = [];
                for (var i = 0; i < window.vm.skuAttrValueList.length; i++) {
                    var col = {};
                    col.prop = window.vm.skuAttrValueList[i].skuAttrId;
                    col.label = window.vm.skuAttrValueList[i].skuAttrName;
                    window.vm.cols.push(col);
                }
                if (window.vm.cols.length > 0) {
                    window.vm.cols = window.vm.cols.concat(window.vm.defaultCols)
                    $("#skuTable").show();
                }
            }
        },
        mounted: function () {
            getCategoryList(1, 1);
        },
        updated: function () {
            $("span.help-info").remove();
            // 拓展属性
            if (window.vm.attributeValueList.length > 0) {
                for (var i = 0; i < window.vm.attributeValueList.length; i++) {
                    var value = window.vm.attributeValueList[i];
                    if (value.isRequired == '01.yes') {
                        var message;
                        if (value.inputType == '01.input') {
                            message = '请输入' + value.attrName;
                        } else {
                            message = '请选择' + value.attrName;
                        }
                        $("#validCol_" + value.attrId).rules("add", {required: true, messages: {required: message}});
                    }
                }
            }
            // 销售属性
            if (window.vm.skuAttrValueList.length > 0) {
                for (var i = 0; i < window.vm.skuAttrValueList.length; i++) {
                    var value = window.vm.skuAttrValueList[i];
                    var message = '请输入' + value.skuAttrName;
                    $("#validSkuCol_" + value.skuAttrId).rules("add", {required: true, messages: {required: message}});
                }
            }

            $(".buyPrice").each(function () {
                $(this).rules("add", {required: true, money: true, messages: {required: "请输入采购价", money: "请输入正确的金额"}});
            });

            $(".sailPrice").each(function () {
                $(this).rules("add", {required: true, money: true, messages: {required: "请输入销售价", money: "请输入正确的金额"}});
            });

        },
        methods: {
            // 保存商品
            save: function () {
                loading();
                if ($("#validForm").valid()) {
                    var param = {};
                    param.attributeOne = $("#attributeOne").val().trim();
                    param.attributeTwo = $("#attributeTwo").val().trim();
                    param.attributeThree = $("#attributeThree").val().trim();
                    param.productName = $("#productName").val().trim();
                    var status = $('input[name="status"]:checked ').val();
                    if (status == '01.person') {
                        param.productId = $("#productId").val().trim();
                    } else {
                        param.productId = "";
                    }

                    param.brandId = $("#brandId").val().trim();
                    param.specification = $("#specification").val().trim();
                    param.unit = $("#unit").val().trim();
                    if ($("#isWeight").is(":checked")) {
                        param.isWeight = true;
                        param.weight = $("#weight").val().trim();
                        param.weightUnit = $("#weightUnit").val().trim();
                    } else {
                        param.isWeight = false;
                    }

                    if (window.vm.attributeValueList.length > 0) {
                        for (var i = 0; i < window.vm.attributeValueList.length; i++) {
                            var attrValue = $("#validCol_" + window.vm.attributeValueList[i].attrId).val().trim();
                            window.vm.attributeValueList[i].value = attrValue;
                        }
                        param.tuozhanArray = window.JSON.stringify(window.vm.attributeValueList);
                    }

                    if (window.vm.list.length > 0) {
                        var l = window.vm.skuAttrValueList.length
                        for (var i = 0; i < window.vm.list.length; i++) {
                            var array = window.vm.list[i];
                            for (var j = 0; j < l; j++) {
                                array[j] = {};
                                array[j].skuValue = $("#skuAttrId_" + j + i).data("attrValue");
                                array[j].skuAttrId = $("#skuAttrId_" + j + i).data("attrId");
                            }
                            array[l] = $("#skuIdList_" + (l) + i).val();
                            array[l + 1] = $("#buyPriceList_" + (l + 1) + i).val();
                            array[l + 2] = $("#sailPriceList_" + (l + 2) + i).val();
                        }
                        param.skuArray = window.JSON.stringify(window.vm.list);
                    }

                    // param.skuArray = window.JSON.stringify(window.vm.list);

                    addProduct(param)
                } else {
                    $(window.parent.parent).scrollTop(0);
                }
            },
            // 关闭窗口
            cancel: function () {
                window.parent.vm.closeDialog(window.parent.addProductView, "");
            },
            // 打开拓展属性选择框
            chooseAttrValue: function (e, attrValue) {
                window.vm.attrValue = attrValue.split(",");
                window.selectAttrValueTarget = $(e.target);
                window.chooseAttributeView = layer.open({
                    type: 1,
                    title: '选择属性值',
                    skin: 'layui-layer-lan',
                    shadeClose: false,
                    shade: 0.5,
                    closeBtn: 1,
                    btn: ['关闭'],
                    area: ['200px', '200px'],
                    offset: $(window).scrollTop() / 2 + $(window.parent).scrollTop() / 2,
                    content: $("#valueDiv"), //iframe的url
                    cancel: function (index, layero) {
                        window.selectAttrValueTarget = "";
                        window.vm.attrValue = [];
                        layer.close(index)
                    },
                    btn1: function (index) {
                        window.selectAttrValueTarget = "";
                        window.vm.attrValue = [];
                        layer.close(index)
                    },
                    success: function (obj, index) {
                        $(":focus").blur();
                    }
                });
            },
            // 选择拓展属性
            saveValue: function (value) {
                window.selectAttrValueTarget.parent().parent().parent().find("input").val(value);
                window.vm.attrValue = [];
                window.selectAttrValueTarget = "";
                layer.close(window.chooseAttributeView)
            },
            // 打开新增销售属性值弹框
            addSkuValue: function (e) {
                window.selectSkuTarget = $(e.target);
                var input = window.selectSkuTarget.parent().parent().parent().find("input")
                if (input.val().length > 0) {
                    var v = input.val()
                    window.vm.skuValue = v.split(",");
                }
                // alert(window.innerHeight)
                // alert($(window.parent).scrollTop())
                // alert($(window).scrollTop())
                window.addSkuView = layer.open({
                    type: 1,
                    title: '添加属性值',
                    skin: 'layui-layer-lan',
                    shadeClose: false,
                    shade: 0.5,
                    closeBtn: 1,
                    btn: ['关闭'],
                    area: ['400px', '200px'],
                    offset: $(window).scrollTop() / 2 + $(window.parent).scrollTop() / 2,
                    content: $("#skuDiv"), //iframe的url
                    cancel: function (index, layero) {
                        window.selectSkuTarget = "";
                        window.vm.skuValue = [];
                        layer.close(index)
                    },
                    btn1: function (index) {
                        window.selectSkuTarget = "";
                        window.vm.skuValue = [];
                        layer.close(index)
                    },
                    success: function (obj, index) {
                        $(":focus").blur();
                    }
                });
            },
            // addSku:function(){
            //   if($("#validForm").validate().element($("#addSkuValue"))){
            //       var val=$("#addSkuValue").val().trim();
            //       var input=window.selectSkuTarget.parent().parent().parent().find("input");
            //       input.val(input.val()+val+",");
            //       window.vm.skuValue.push(val)
            //       $("#addSkuValue").val("");
            //   }
            // },
            // 删除标签
            handleClose(tag) {
                this.skuValue.splice(this.skuValue.indexOf(tag), 1);
                var input = window.selectSkuTarget.parent().parent().parent().find("input");
                input.val(this.skuValue.join(","));
                calculationCol()
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
                    this.skuValue.push(val);
                    var input = window.selectSkuTarget.parent().parent().parent().find("input");
                    input.val(this.skuValue.join(","));
                } else {
                    return false;
                }
                this.inputVisible = false;
                this.inputValue = '';

                calculationCol();
            },
            // sku属性删除一行
            deleteRow(index, rows) {
                rows.splice(index, 1);
            },
            buyPrice() {
                if ($("#validForm").validate().element($("#buyPrice"))) {
                    $(".buyPrice").val($("#buyPrice").val())
                }
            },
            sailPrice() {
                if ($("#validForm").validate().element($("#sailPrice"))) {
                    $(".sailPrice").val($("#sailPrice").val())
                }
            },
            // 返回
            returnMainFrame: function () {
                window.location.href = addProductMethodUrl.toProductList;
                $(window.parent.document).find('.tab-content .active iframe').attr('src', addProductMethodUrl.toProductList)
            }
        }
    })


    // 表单验证
    $("#validForm").validate({
        rules: {
            "productName": {
                required: true,
            },
            "productId": {
                required: true
            },
            "brandId": {
                required: true
            },
            "specification": {
                required: true
            },
            "attributeThree": {
                required: true
            },
            "unit": {
                required: true
            },
            "weight": {
                required: true
            },
            "weightUnit": {
                required: true
            },
            "addSkuValue": {
                required: true
            },
            "buyPrice": {
                required: true,
                money: true
            },
            "sailPrice": {
                required: true,
                money: true
            },
        },
        messages: {
            "productName": {
                required: '请输入商品名称',
            },
            "productId": {
                required: '请输入商品编号'
            },
            "brandId": {
                required: '请选择品牌'
            },
            "specification": {
                required: '请输入型号规格'
            },
            "attributeThree": {
                required: '请选择类目'
            },
            "unit": {
                required: '请输入计量单位'
            },
            "weight": {
                required: '请输入件重'
            },
            "weightUnit": {
                required: '请输入件重单位'
            },
            "addSkuValue": {
                required: '请输入属性值'
            },
            "buyPrice": {
                required: '请输入采购价',
                money: '请输入正确的金额'
            },
            "sailPrice": {
                required: '请输入销售价',
                money: '请输入正确的金额'
            },
        },
        errorClass: "help-inline help-info",
        errorElement: "span",
        errorPlacement: function (error, element) {
            var el = element.parent().parent()
            var $result = el.find("button");
            // 错误信息放置位置
            if ($result.length > 0) {
                error.appendTo($result.parent().parent());
            } else {
                error.appendTo(el);
            }

        }
    });

    // 一级下拉框
    $("#attributeOne").change(function () {
        $("#attributeTwo").val("");
        vm.attributeTwoList = [];
        $("#attributeThree").val("");
        vm.attributeThreeList = [];
        if ($(this).val() != '') {
            reset()
            getCategoryList($(this).val(), 2)
        }
    });

    // 二级下拉框
    $("#attributeTwo").change(function () {
        $("#attributeThreeList").val("");
        vm.attributeThreeList = [];
        if ($(this).val() != '') {
            reset()
            getCategoryList($(this).val(), 3)
        }
    });


    // 三级下拉框
    $("#attributeThree").change(function () {
        if ($(this).val() != '') {
            reset()
            getAttributeListByCategoryId($(this).val());
            getSkuAttrListByCategoryId($(this).val());
        }
    });

    // 是否重量采销
    $("#isWeight").change(function () {
        if ($("#isWeight").is(":checked")) {
            $(".weight-disabled").show();
            $('#weight').attr("disabled", false);
            $('#weightUnit').attr("disabled", false);
        } else {
            $(".weight-disabled").hide();
            $('#weight').attr("disabled", true);
            $('#weightUnit').attr("disabled", true);
        }
    });

    // 重置参数
    function reset() {
        $(".attr-type").val("");
        $(".sku-type").val("");
        window.vm.list = [];
        window.vm.cols = [];
        $("#sailPrice").val("");
        $("#buyPrice").val("");
        $("#tuozhan").hide();
        $("#xiaoshou").hide();
        $("#skuTable").hide();
    }

    // 计算 排列组合SKU
    function calculationCol() {
        var list = []
        for (var i = 0; i < window.vm.cols.length; i++) {
            var value = window.vm.cols[i];
            var v = $("#validSkuCol_" + value.prop).val();
            // console.log(v)
            if (typeof(v) != "undefined" && v.length > 0) {
                var skuArray = v.split(",");
                list.push(skuArray);
            }
        }
        if (list.length > 0 && list.length == window.vm.skuAttrValueList.length) {
            window.vm.list = doExchange(list);
        } else {
            window.vm.list = []
        }

    }


    /*返回组合的数组*/
    function doExchange(arr) {
        var len = arr.length;
        // 当数组大于等于2个的时候
        if (len >= 2) {
            // 第一个数组的长度
            var len1 = arr[0].length;
            // 第二个数组的长度
            var len2 = arr[1].length;
            // 2个数组产生的组合数
            var lenBoth = len1 * len2;
            //  申明一个新数组
            var items = new Array(lenBoth);
            // 申明新数组的索引
            var index = 0;
            for (var i = 0; i < len1; i++) {
                for (var j = 0; j < len2; j++) {
                    if (arr[0][i] instanceof Array) {
                        items[index] = arr[0][i].concat(arr[1][j]);
                    } else {
                        items[index] = [arr[0][i]].concat(arr[1][j]);
                    }
                    index++;
                }
            }
            var newArr = new Array(len - 1);
            for (var i = 2; i < arr.length; i++) {
                newArr[i - 1] = arr[i];
            }
            newArr[0] = items;
            return doExchange(newArr);
        } else {
            return arr[0];
        }
    }

    $(":radio").click(function () {
        var status = $('input[name="status"]:checked ').val();
        if (status == '01.person') {
            $('#productId').attr("disabled", false);
        } else {
            $('#productId').attr("disabled", true);
        }
    });


});

