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
                品牌名称：
            </label>
            <div class="col-sm-all col-sm-3">
                <input class="form-control" id="brandName" name="brandName" v-bind:value="brand.brandName"/>
            </div>
        </div>

        <input type="hidden" id="id" name="id" value="">

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

<script type="text/javascript" src="${request.contextPath}/static/js/sub/brand/editBrand.js"></script>
</body>
</html>