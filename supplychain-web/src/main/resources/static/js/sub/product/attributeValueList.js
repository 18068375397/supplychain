window.baseUrl = $("#base_url").val();

var attributeValueMethodUrl = {
    // 查询属性列表
    getAttributeValueList: window.baseUrl + "/mk/attribute/value/list",

    // 跳转属性列表页面
    toAttributeList: window.baseUrl + "/mk/attribute/toAttributeList",

    // 跳转新增属性页面
    toAddAttributeValue: window.baseUrl + "/mk/attribute/value/toAddAttributeValue",

    // 删除属性值
    deleteAttributeValue: window.baseUrl + "/mk/attribute/value/delete",

    // 编辑属性值界面
    toEditAttributeValue: window.baseUrl + "/mk/attribute/value/toEditAttributeValue"
};

$(function () {

    function getAttributeValueList(curr) {
        $.ajax({
            url: attributeValueMethodUrl.getAttributeValueList,
            type: "post",
            data: {
                page: curr || 1,
                size: 5,
                attrId: getQueryString("attrId")
            },
            dataType: "json",
            success: function (res) {
                if (res.code === 200) {
                    vm.list = res.data.list;
                    laypage({
                        cont: 'demo1',
                        pages: res.data.pages, // 总页数,
                        curr: curr || 1, // 当前页
                        jump: function (obj, first) { // 触发分页后的回调
                            if (!first) { // 点击跳页触发函数自身，并传递当前页：obj.curr
                                getAttributeValueList(obj.curr);
                            }
                        }
                        // 连续显示分页数
                    });
                    $("table").next().find('>p').remove();
                    if (res.data.total > 0) {
                        $("table").next().find('>p').remove();
                        $("#itemcounts").parent().show();
                        $("#itemcounts").html(res.data.total);
                    } else if (res.data.total == 0) {
                        $("#itemcounts").parent().hide();
                        $("table").next().append('<p style="text-align: center;">暂无记录 </p>')
                    }

                    if (res.data.pages < 2)
                        $('#demo1').hide();
                    else
                        $('#demo1').show();
                } else {

                }
            }
        });
    }

    function deleteAttributeValue(id) {
        $.ajax({
            url: attributeValueMethodUrl.deleteAttributeValue,
            type: "post",
            data: {
                id: id
            },
            dataType: "json",
            success: function (res) {
                loaded();
                if (res.code === 200) {
                    getAttributeValueList(0);
                    layer.msg("删除成功", {icon: 1, offset: '100px'});
                } else {
                    layer.msg("删除失败", {icon: 2, offset: '100px'});
                }
            }
        });
    }

    window.vm = new Vue({
        el: '#attribute-main',
        data: {
            list: []
        },
        mounted: function () {
            $(window.parent).scrollTop(0);
            getAttributeValueList(0);

        },
        updated: function () {
            /*由于数据更改导致的虚拟 DOM 重新渲染和打补丁，在这之后会调用该钩子。
             当这个钩子被调用时，组件 DOM 已经更新，所以你现在可以执行依赖于 DOM 的操作。然而在大多数情况下，你应该避免在此期间更改状态，因为这可能会导致更新无限循环。
             该钩子在服务器端渲染期间不被调用*/
        },
        methods: {
            // 新增
            add: function () {
                window.attrId = getQueryString("attrId");
                window.addAttributeValueView = layer.open({
                    type: 2,
                    title: '新增属性值',
                    skin: 'layui-layer-lan',
                    shadeClose: false,
                    shade: 0.5,
                    closeBtn: 1,
                    area: ['800px', '400px'],
                    offset: ['10px', '20px'],
                    content: attributeValueMethodUrl.toAddAttributeValue, //iframe的url
                    success: function (obj, index) {
                        $(obj).find('#valueForm').focus();
                    }
                });
            },
            search: function () {
                getAttributeValueList(0);
            },
            // 关闭对话框
            closeDialog: function (view, obj) {
                layer.close(view);
                if (obj !== "") {
                    getAttributeValueList(0);
                    layer.msg(obj, {icon: 1, offset: '100px'});
                }
            },
            // 删除属性值
            deleteOne: function (id) {
                layer.confirm('你确定要删除选中的属性值吗？', {
                    // 标题
                    title: "确认删除",
                    // 按钮
                    btn: ['确定', '取消'],
                    offset: '100px'
                }, function (index) {
                    layer.close(index);
                    loading();
                    deleteAttributeValue(id);
                }, function (index) {
                    layer.close(index);
                });
            },
            edit: function (id) {
                window.id = id;
                window.editAttributeValueView = layer.open({
                    type: 2,
                    title: '修改属性',
                    skin: 'layui-layer-lan',
                    shadeClose: false,
                    shade: 0.5,
                    closeBtn: 1,
                    area: ['800px', '400px'],
                    offset: ['10px', '20px'],
                    content: attributeValueMethodUrl.toEditAttributeValue, //iframe的url
                    success: function (obj, index) {
                        $(obj).find('#validForm').focus();
                    }
                });
            },
            // 返回
            returnMainFrame: function () {
                window.location.href = attributeValueMethodUrl.toAttributeList;
                $(window.parent.document).find('.tab-content .active iframe').attr('src', attributeValueMethodUrl.toAttributeList)
            }

        }
    })


});

