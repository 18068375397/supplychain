window.baseUrl = $("#base_url").val();

var categoryMethodUrl = {
    // 查询树列表
    getCategoryList: window.baseUrl + "/mk/product/category/list",
    // 保存树列表
    saveCategoryList: window.baseUrl + "/mk/product/category/saveList",
};

$(function () {

    function getCategoryList() {
        $.ajax({
            url: categoryMethodUrl.getCategoryList,
            type: "post",
            data: {},
            dataType: "json",
            success: function (res) {
                if (res.code === 200) {
                    var zTree = $.fn.zTree.init($("#treeDemo"), setting, res.data);
                    var nodes = zTree.getNodes();
                    if (nodes.length > 0) {
                        zTree.expandNode(nodes[0], true, false, false);
                    }
                } else {

                }
            }
        });
    }

    function saveCategoryList(ztreeJsonString) {
        $.ajax({
            url: categoryMethodUrl.saveCategoryList,
            type: "post",
            data: {"ztreeJsonString": JSON.stringify(ztreeJsonString)},
            dataType: "json",
            success: function (res) {
                loaded();
                if (res.code === 200) {
                    top.layer.msg("保存成功", {icon: 1, shade: [0.1, '#fff']})
                } else {
                    top.layer.msg("保存失败", {icon: 2, shade: [0.1, '#fff']})
                }
            }
        });
    }


    // zTree 配置
    var setting = {
        view: {
            addHoverDom: addHoverDom,//增加节点
            removeHoverDom: removeHoverDom,//删除节点
            selectedMulti: false
            // fontCss : {"font-family": "微软雅黑", "font-size": "50px"}
        },
        edit: {
            enable: true,
            showRemoveBtn: true,
            showRenameBtn: true,
            drag: {
                prev: canPrev,//移动到目标节点前
                next: canNext,//移动到目标节点后
                inner: canInner//移动到目标节点内部
            }
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        check: {
            enable: false  // 是否显示 复选框按钮
        },
        callback: {
            beforeDrag: beforeDrag,// 拖拽开始前
            beforeDrop: beforeDrop,// 拖拽结束前
            beforeRemove: beforeRemove,// 删除前
            onClick: zTreeOnClick// 点击
        }
    };


    function zTreeOnClick(event, treeId, treeNode) {
        alert(treeNode.tId + ", " + treeNode.name);
    }

    function beforeDrag(treeId, treeNodes) {
        for (var i = 0, l = treeNodes.length; i < l; i++) {
            if (treeNodes[i].drag === false) {
                return false;
            }
        }
        return true;
    }

    function canPrev(treeId, nodes, targetNode) {
        if (targetNode == null || typeof(targetNode) == "undefined") {
            return false;
        }
        if (nodes[0].level < targetNode.level) {
            return false;
        }
        // console.log("nodes[0]:"+nodes[0].level)
        // console.log("targetNode:"+targetNode.level)
        if (nodes[0].level == 1 && targetNode.level == 1) {
            return true;
        }

        return !targetNode.isParent;
    }

    function canNext(treeId, nodes, targetNode) {
        if (targetNode == null || typeof(targetNode) == "undefined") {
            return false;
        }
        if (nodes[0].level < targetNode.level) {
            return false;
        }
        if (nodes[0].level == 1 && targetNode.level == 1) {
            return true;
        }
        return !targetNode.isParent;
    }

    function canInner(treeId, nodes, targetNode) {

        if (targetNode == null || typeof(targetNode) == "undefined") {
            return false;
        }
        if (targetNode.level >= 3) {
            return false;
        }
        console.log(targetNode.level + " " + nodes[0].level)

        if (targetNode.level == 2 && nodes[0].level <= 2) {
            return false;
        }


        if (nodes[0].level == 1 && targetNode.level == 1) {
            if (typeof(nodes[0].children) == "undefined") {
                return true;
            } else {
                return false;
            }
        }
        if (targetNode.level == 0) {
            return true;
        }


        return !(targetNode && targetNode.level === 0);
    }

    function beforeDrop(treeId, treeNodes, targetNode, moveType) {
        return targetNode ? targetNode.drop !== false : true;
    }

    var newCount = 1;


    function addHoverDom(treeId, treeNode) {
        var sObj = $("#" + treeNode.tId + "_span");


        if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0 || treeNode.level >= 3) {
            return;
        }
        var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
            + "' title='add node' onfocus='this.blur();'></span>";
        sObj.after(addStr);
        var btn = $("#addBtn_" + treeNode.tId);
        if (btn) btn.bind("click", function () {
            var zTree = $.fn.zTree.getZTreeObj("treeDemo");
            var nodes = zTree.transformToArray(zTree.getNodes());
            zTree.addNodes(treeNode, {id: nodes.length + 1, pId: treeNode.id, name: "new node" + (nodes.length + 1)});
            return false;
        });
    }

    function removeHoverDom(treeId, treeNode) {
        $("#addBtn_" + treeNode.tId).unbind().remove();
    }

    function beforeRemove(treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
        zTree.selectNode(treeNode);
        return confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
    }


    window.vm = new Vue({
        el: '#attribute-main',
        data: {},

        mounted: function () {
            // 让页面置顶
            $(window.parent).scrollTop(0);
            getCategoryList(0);

        },
        methods: {
            save: function () {

                // 获取ckeditor中的html文本
                // window.editor.getData()

                var zTree = $.fn.zTree.getZTreeObj("treeDemo");
                var nodes = zTree.transformToArray(zTree.getNodes());

                var treeJson = [];
                for (var i = 0; i < nodes.length; i++) {
                    var tree = {};
                    // console.log(nodes[i].name + "的父类ID是" + getParentId(nodes[i]));
                    tree.topId = getParentId(nodes[i]);
                    tree.categoryId = nodes[i].id;
                    tree.parentId = nodes[i].pId == null ? 0 : nodes[i].pId;
                    tree.categoryName = nodes[i].name;
                    // 不需要启用/禁用功能  status默认01.enable
                    // tree.status = (typeof(nodes[i].checked) == "undefined" || nodes[i].checked == false) ? "02.disable" : "01.enable";
                    tree.status = "01.enable";
                    tree.isParent = (typeof(nodes[i].isParent) == "undefined" || nodes[i].isParent == false) ? 0 : 1;
                    treeJson.push(tree);
                }
                loading();
                saveCategoryList(treeJson);
            }
        }
    })


    // // 初始化ckEditor
    // window.editor = CKEDITOR.replace('ckEditor', {
    //     filebrowserImageUploadUrl: window.baseUrl + "/uploadCkeditor",
    //     on: {
    //         instanceReady: function (ev) {
    //             this.dataProcessor.writer.setRules('p', {
    //                 indent: false,
    //                 breakBeforeOpen: false,   //<p>之前不加换行
    //                 breakAfterOpen: false,    //<p>之后不加换行
    //                 breakBeforeClose: false,  //</p>之前不加换行
    //                 breakAfterClose: false    //</p>之后不加换行7
    //             });
    //         }
    //     }
    // });
    //
    //
    // $(".fileupload_img").on("click", function () {
    //     var file = $(this).parent().find("input");
    //     file.click();
    //     uploadPic(file.attr("id"))
    // });
    //
    //
    // $(".deleteFile").on("click", function () {
    //     var file = $(this).parent().find("input");
    //     file.after(file.clone().val(""));
    //     file.remove();
    //     var id = file.attr("id")
    //     var img = $("#" + id + "_img");
    //     img.attr("src", window.baseUrl + '/static/images/pic_add_3.png');
    //     $(this).hide();
    // });

});

function getParentId(node) {
    if (node.level == 0) {
        return 0
    } else if (node.level == 1) {
        return node.id
    } else {
        return getParentId(node.getParentNode());
    }
}