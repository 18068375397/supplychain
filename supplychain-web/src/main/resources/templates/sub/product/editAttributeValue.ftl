<!DOCTYPE html>
<html>
<head>
    <#include "../../common/common-css.ftl">
    <style type="text/css">
        .col-sm-all {
            /*float: left;*/
        }
    </style>
</head>
<body style="padding-top: 20px !important;">
<div class="ilvdo-container" id="attribute-main">

    <form class="form-horizontal" id="validForm" name="validForm" v-cloak>
        <div class="form-group">
            <label class="col-sm-all col-sm-2 control-label">
                <span style="color: red">*</span>
                属性值ID：
            </label>
            <div class="col-sm-all col-sm-3">
                <input class="form-control" id="valueId" name="valueId" v-bind:value="attributeValue.valueId"></input>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-all col-sm-2 control-label">
                <span style="color: red">*</span>
                属性值名称：
            </label>
            <div class="col-sm-all col-sm-3">
                <input class="form-control" id="valueName" name="valueName"
                       v-bind:value="attributeValue.valueName"></input>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-all col-sm-2 control-label">
                <span style="color: red">*</span>
                状态：
            </label>
            <div class="col-sm-all col-sm-3">
                <select class="form-control" name="status" id="status" v-bind:value="attributeValue.status">
                    <option value="">请选择</option>
                    <option value="01.enable">启用</option>
                    <option value="02.disable">禁用</option>
                </select>
            </div>
        </div>

        <input id="id" name="id" value="" type="hidden">

        <div style="padding-left: 80px;">
            <label>
                <button type="button" class="btn btn-success btn-sm" id="search_btn" v-on:click="save()"
                        style="float: left;">提交
                </button>

                <button type="button" class="btn btn-default btn-sm" id="search_btn" v-on:click="cancel()"
                        style="float: left;margin-left: 30px">取消
                </button>
            </label>

        </div>

    </form>
</div>
<input type="hidden" id="base_url" value="${request.contextPath}">
<#include "../../common/common-js.ftl">

<script type="text/javascript" src="${request.contextPath}/static/js/sub/product/editAttributeValue.js"></script>
</body>
</html>