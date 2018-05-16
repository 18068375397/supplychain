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
                属性ID：
            </label>
            <div class="col-sm-all col-sm-3">
                <input class="form-control" id="skuAttrId" name="skuAttrId" v-bind:value="attribute.skuAttrId"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-all col-sm-2 control-label">
                <span style="color: red">*</span>
                属性名称：
            </label>
            <div class="col-sm-all col-sm-3">
                <input class="form-control" id="skuAttrName" name="skuAttrName" v-bind:value="attribute.skuAttrName"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-all col-sm-2 control-label">
                <span style="color: red">*</span>
                排序值：
            </label>
            <div class="col-sm-all col-sm-3">
                <input class="form-control" id="sort" name="sort" v-bind:value="attribute.sort"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-all col-sm-2 control-label">
                <span style="color: red">*</span>
                字段类型：
            </label>
            <div class="col-sm-all col-sm-3">
                <select class="form-control" name="columnType" id="columnType" v-bind:value="attribute.columnType">
                    <option value="">请选择</option>
                    <option value="01.text">文本</option>
                    <option value="02.number">数字</option>
                    <option value="03.time">时间</option>
                <#--<option v-for="item in problemTypeList" v-bind:value="item.c_key">{{item.c_value}}</option>-->
                </select>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-all col-sm-2 control-label">
                <span style="color: red">*</span>
                类目：
            </label>
            <div class="col-sm-all col-sm-3">
                <select class="form-control" name="attributeOne" id="attributeOne" v-model="attributeOne">
                    <option value="">请选择</option>
                    <option v-for="item in attributeOneList" v-bind:value="item.categoryId">{{item.categoryName}}
                    </option>
                </select>
            </div>
            <div class="col-sm-all col-sm-3" style="margin-left: -20px">
                <select class="form-control" name="attributeTwo" id="attributeTwo" v-model="attributeTwo">
                    <option value="">请选择</option>
                    <option v-for="item in attributeTwoList" v-bind:value="item.categoryId">{{item.categoryName}}
                    </option>
                </select>
            </div>
            <div class="col-sm-all col-sm-3" style="margin-left: -20px">
                <select class="form-control" name="attributeThree" id="attributeThree" v-model="attributeThree">
                    <option value="">请选择</option>
                    <option v-for="item in attributeThreeList" v-bind:value="item.categoryId"
                            v-bind:data-parent-id="[item.parentId]" v-bind:data-top-id="[item.topId]">
                        {{item.categoryName}}
                    </option>
                </select>
            </div>
        </div>

        <input type="hidden" id="categoryId" name="categoryId" value="">
        <input type="hidden" id="parentId" name="parentId" value="">
        <input type="hidden" id="topId" name="topId" value="">
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

<script type="text/javascript" src="${request.contextPath}/static/js/sub/product/editSku.js"></script>
</body>
</html>