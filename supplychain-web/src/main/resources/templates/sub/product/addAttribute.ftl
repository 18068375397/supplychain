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

    <form class="form-horizontal" id="validForm" name="validForm">
        <div class="form-group">
            <label class="col-sm-all col-sm-2 control-label">
                <span style="color: red">*</span>
                属性ID：
            </label>
            <div class="col-sm-all col-sm-3">
                <input class="form-control" id="attrId" name="attrId"></input>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-all col-sm-2 control-label">
                <span style="color: red">*</span>
                属性名称：
            </label>
            <div class="col-sm-all col-sm-3">
                <input class="form-control" id="attrName" name="attrName"></input>
            </div>
        </div>

    <#--<div class="form-group">-->
    <#--<label class="col-sm-all col-sm-2 control-label">-->
    <#--<span style="color: red">*</span>-->
    <#--属性类型：-->
    <#--</label>-->
    <#--<div class="col-sm-all col-sm-3">-->
    <#--<select class="form-control" name="attrType" id="attrType">-->
    <#--<option value="">请选择</option>-->
    <#--<option value="01.base">基础属性</option>-->
    <#--<option value="02.sale">销售属性</option>-->
    <#--</select>-->
    <#--</div>-->
    <#--</div>-->
        <div class="form-group">
            <label class="col-sm-all col-sm-2 control-label">
                <span style="color: red">*</span>
                是否必填：
            </label>
            <div class="col-sm-all col-sm-3">
                <select class="form-control" name="isRequired" id="isRequired">
                    <option value="">请选择</option>
                    <option value="01.yes">是</option>
                    <option value="02.no">否</option>
                <#--<option v-for="item in payTypeList" v-bind:value="item.c_key">{{item.c_value}}</option>-->
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-all col-sm-2 control-label">
                <span style="color: red">*</span>
                是否筛选：
            </label>
            <div class="col-sm-all col-sm-3">
                <select class="form-control" name="isSearch" id="isSearch">
                    <option value="">请选择</option>
                    <option value="01.yes">是</option>
                    <option value="02.no">否</option>
                <#--<option v-for="item in problemTypeList" v-bind:value="item.c_key">{{item.c_value}}</option>-->
                </select>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-all col-sm-2 control-label">
                <span style="color: red">*</span>
                录入类型：
            </label>
            <div class="col-sm-all col-sm-3">
                <select class="form-control" name="inputType" id="inputType">
                    <option value="">请选择</option>
                    <option value="01.input">输入型</option>
                    <option value="02.select">选择型</option>
                <#--<option v-for="item in problemTypeList" v-bind:value="item.c_key">{{item.c_value}}</option>-->
                </select>
            </div>
        </div>

        <div class="form-group" id="input-type" style="display: none">
            <label class="col-sm-all col-sm-2 control-label">
                <span style="color: red">*</span>
                字段类型：
            </label>
            <div class="col-sm-all col-sm-3">
                <select class="form-control" name="columnType" id="columnType">
                    <option value="">请选择</option>
                    <option value="01.text">文本</option>
                    <option value="02.number">数字</option>
                    <option value="03.time">时间</option>
                </select>
            </div>
        </div>


        <div class="form-group" id="select-type" style="display: none">
            <label class="col-sm-all col-sm-2 control-label">
                <span style="color: red">*</span>
                属性值：
            </label>
            <div class="col-sm-all col-sm-9">
                <input type="hidden" id="attrValues" name="attrValues">
                <el-tag
                        :key="tag"
                        v-for="tag in attrValue"
                        closable
                        :disable-transitions="false"
                        @close="handleClose(tag)">
                    {{tag}}
                </el-tag>
                <el-input
                        class="input-new-tag"
                        v-if="inputVisible"
                        v-model="inputValue"
                        ref="saveTagInput"
                        size="small"
                        @keyup.enter.native="handleInputConfirm"
                        @blur="handleInputConfirm"
                >
                </el-input>
                <el-button v-else class="button-new-tag" id="a_btn" size="small" @click="showInput">+ 属性值</el-button>
            </div>
        </div>


        <div class="form-group">
            <label class="col-sm-all col-sm-2 control-label">
                <span style="color: red">*</span>
                类目：
            </label>
            <div class="col-sm-all col-sm-3">
                <select class="form-control" name="attributeOne" id="attributeOne">
                    <option value="">请选择</option>
                    <option v-for="item in attributeOneList" v-bind:value="item.categoryId">{{item.categoryName}}
                    </option>
                </select>
            </div>
            <div class="col-sm-all col-sm-3" style="margin-left: -20px">
                <select class="form-control" name="attributeTwo" id="attributeTwo">
                    <option value="">请选择</option>
                    <option v-for="item in attributeTwoList" v-bind:value="item.categoryId">{{item.categoryName}}
                    </option>
                </select>
            </div>
            <div class="col-sm-all col-sm-3" style="margin-left: -20px">
                <select class="form-control" name="attributeThree" id="attributeThree">
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

<script type="text/javascript" src="${request.contextPath}/static/js/sub/product/addAttribute.js"></script>
</body>
</html>