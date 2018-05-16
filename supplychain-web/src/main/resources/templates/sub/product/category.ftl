<!DOCTYPE html>
<html>
<head>
    <#include "../../common/common-css.ftl">
    <link rel="stylesheet" href="${request.contextPath}/static/css/zTree/zTreeStyle/zTreeStyle.css" type="text/css">
    <style type="text/css">
        .ztree li span.button.add {
            margin-left: 2px;
            margin-right: -1px;
            background-position: -144px 0;
            vertical-align: top;
            *vertical-align: middle
        }

        .search-text {
            width: 130px;
            display: inline-block;
        }

    </style>
</head>
<body style="padding-top: 20px !important;">

<div class="clearfix" id="attribute-main" style="min-width:900px;">
    <div class="pull-left zTreeDemoBackground left" style="width: 220px">
        <ul id="treeDemo" class="ztree"></ul>

        <button type="button" class="btn btn-success btn-sm" id="search_btn" v-on:click="save()"
                style="float: left;">保存
        </button>
    </div>
<#--<div class="pull-left" style="width: 680px">-->
<#--<div class="page-header"><h4 style="color: #428bca">通用图片</h4></div>-->
<#--<div class="span12">-->
<#--&lt;#&ndash;图片1&ndash;&gt;-->
<#--<span class="search-text">-->
<#--<img id="fileupload1_img" alt="" class="upload-img fileupload_img"-->
<#--src="${request.contextPath}/static/images/pic_add_3.png"/>-->
<#--<span id="deleteFile" class="delete-icon deleteFile" style="display: none"></span>-->
<#--<input type="file" name="file" class="fileupload" id="fileupload1" accept="image/*" multiple>-->
<#--</span>-->
<#--&lt;#&ndash;图片2&ndash;&gt;-->
<#--<span class="search-text">-->
<#--<img id="fileupload2_img" alt="" class="upload-img fileupload_img"-->
<#--src="${request.contextPath}/static/images/pic_add_3.png"/>-->
<#--<span id="deleteFile" class="delete-icon deleteFile" style="display: none"></span>-->
<#--<input type="file" name="file" class="fileupload" id="fileupload2" accept="image/*" multiple>-->
<#--</span>-->
<#--&lt;#&ndash;图片3&ndash;&gt;-->
<#--<span class="search-text">-->
<#--<img id="fileupload3_img" alt="" class="upload-img fileupload_img"-->
<#--src="${request.contextPath}/static/images/pic_add_3.png"/>-->
<#--<span id="deleteFile" class="glyphicon  delete-icon deleteFile" style="display: none"></span>-->
<#--<input type="file" name="file" class="fileupload" id="fileupload3" accept="image/*" multiple>-->
<#--</span>-->
<#--&lt;#&ndash;图片4&ndash;&gt;-->
<#--<span class="search-text">-->
<#--<img id="fileupload4_img" alt="" class="upload-img fileupload_img"-->
<#--src="${request.contextPath}/static/images/pic_add_3.png"/>-->
<#--<span id="deleteFile" class="glyphicon  delete-icon deleteFile" style="display: none"></span>-->
<#--<input type="file" name="file" class="fileupload" id="fileupload4" accept="image/*" multiple>-->
<#--</span>-->
<#--&lt;#&ndash;图片5&ndash;&gt;-->
<#--<span class="search-text">-->
<#--<img id="fileupload5_img" alt="" class="upload-img fileupload_img"-->
<#--src="${request.contextPath}/static/images/pic_add_3.png"/>-->
<#--<span id="deleteFile" class="glyphicon delete-icon deleteFile" style="display: none"></span>-->
<#--<input type="file" name="file" class="fileupload" id="fileupload5" accept="image/*" multiple>-->
<#--</span>-->
<#--&lt;#&ndash;v-on:change="chooseImage($event)"&ndash;&gt;-->
<#--&lt;#&ndash;style="width: 0px;height: 0.5px"&ndash;&gt;-->


<#--</div>-->
<#--<div class="page-header"><h4 style="color: #428bca">通用介绍</h4></div>-->
<#--<div class="span12">-->
<#--<span class="search-text" style="width: 100%">-->
<#--<textarea class="form-control" rows="5" class="ckeditor" name="ckEditor"-->
<#--id="ckEditor"></textarea>-->
<#--</span>-->

<#--</div>-->

</div>
</div>


<input type="hidden" id="base_url" value="${request.contextPath}">
<#include "../../common/common-js.ftl">
<#--ztree-->
<script type="text/javascript" src="${request.contextPath}/static/js/common/jquery.ztree.all.min.js"></script>
<#--&lt;#&ndash;图片上传控件&ndash;&gt;-->
<#--<script type="text/javascript" src="${request.contextPath}/static/js/common/jquery.iframe-transport.js"></script>-->
<#--<script type="text/javascript" src="${request.contextPath}/static/js/common/jquery.ui.widget.js"></script>-->
<#--<script type="text/javascript" src="${request.contextPath}/static/js/common/jquery.fileupload.js"></script>-->
<#--&lt;#&ndash;ckeditor&ndash;&gt;-->
<#--<script type="text/javascript" src="${request.contextPath}/static/js/common/ckeditor/ckeditor.js"></script>-->

<script type="text/javascript" src="${request.contextPath}/static/js/sub/product/category.js"></script>
</body>
</html>