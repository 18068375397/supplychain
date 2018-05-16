window.baseUrl = $("#base_url").val();
window.page = 1;
window.size = 5;

var orderMethodUrl = {
    // 查询(期货)采购订单列表
    getOrderList: window.baseUrl + "/mk/buy/order/list",

    // 跳转新增采购订单
    toAddBuyOrder: window.baseUrl + "/mk/buy/order/toAddBuyOrder",
};

$(function () {

    function getOrderList(sortColumn, sortOrder) {
        $.ajax({
            url: orderMethodUrl.getOrderList,
            type: "post",
            data: {
                page: window.page,
                size: window.size,
                sortColumn: sortColumn || "default",
                sortOrder: sortOrder || ""
            },
            dataType: "json",
            success: function (res) {
                if (res.code == "200") {
                    vm.list = res.data.list;
                    vm.total = res.data.total
                } else {

                }
            }
        });
    }


    window.vm = new Vue({
        el: '#attribute-main',
        data: {
            list: [],
            total: ""
        },
        mounted: function () {
            $(window.parent).scrollTop(0);
            // DatePicker("#startTime", "#endTime");
            getOrderList();
        },
        updated: function () {
            /*由于数据更改导致的虚拟 DOM 重新渲染和打补丁，在这之后会调用该钩子。
             当这个钩子被调用时，组件 DOM 已经更新，所以你现在可以执行依赖于 DOM 的操作。然而在大多数情况下，你应该避免在此期间更改状态，因为这可能会导致更新无限循环。
             该钩子在服务器端渲染期间不被调用*/
        },
        methods: {
            // 新增
            add: function () {
                window.location.href = orderMethodUrl.toAddBuyOrder + "?random=" + Math.random();
                $(window.parent.document).find('.tab-content .active iframe').attr('src', orderMethodUrl.toAddBuyOrder + "?random=" + Math.random());
            },
            search: function () {

            },
            // 查看 属性值
            showDetail: function (attrId) {
            },
            editEnable: function (id) {
            },
            editDisable: function (id) {
            },
            deleteOne: function (id) {
            },
            edit: function (id) {
            },
            handleSizeChange: function (val) {
                window.size = val
                getOrderList()
            },
            handleCurrentChange: function (val) {
                window.page = val
                getOrderList()
            },
            handleSortChange: function (obj) {
                // console.log("column:"+obj)
                // console.log("prop:"+obj.prop)
                // console.log("order:"+obj.order)  // descending  ascending
                getOrderList(obj.prop, obj.order);
            },

        }
    })

});

