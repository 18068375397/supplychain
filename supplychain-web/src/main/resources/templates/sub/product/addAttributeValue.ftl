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

    <form class="form-horizontal" id="valueForm" name="valueForm">
        <input id="attrId" name="attrId" v-bind:value="attrId" type="hidden"/>

        <div class="form-group">
            <label class="col-sm-all col-sm-3 control-label">
                <span style="color: red">*</span>
                属性值ID：
            </label>
            <div class="col-sm-all col-sm-4">
                <input class="form-control" id="valueId" name="valueId"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-all col-sm-3 control-label">
                <span style="color: red">*</span>
                属性值名称：
            </label>
            <div class="col-sm-all col-sm-4">
                <input class="form-control" id="valueName" name="valueName"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-all col-sm-3 control-label">
                <span style="color: red">*</span>
                状态：
            </label>
            <div class="col-sm-all col-sm-4">
                <select class="form-control" name="status" id="status">
                    <option value="">请选择</option>
                    <option value="01.enable">启用</option>
                    <option value="02.disable">禁用</option>
                </select>
            </div>
        </div>

        <div style="padding-left: 200px;">
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

<script type="text/javascript" src="${request.contextPath}/static/js/sub/product/addAttributeValue.js"></script>
</body>
</html>