<!DOCTYPE html>
<html>
<head>
    <#include "../../common/common-css.ftl">
    <style type="text/css">
        .col-sm-all {
            /*float: left;*/
        }

        .weight-disabled {
            display: none;
        }

    </style>
</head>
<body style="padding-top: 20px !important;">
<div class="ilvdo-container" id="attribute-main">

    <button type="button" class="btn btn-default" id="search_btn" v-on:click="returnMainFrame()"
            style="position: absolute;right:40px;top:12px">返 回
    </button>

    <form class="form-horizontal" id="validForm" name="validForm">

    <#--选择拓展属性弹框-->
        <div id="valueDiv" style="display: none">
            <div style="margin-left:10px;margin-top: 10px;line-height: 36px;">
                <span v-for="item in attrValue" style="padding-left:10px">
                    <button type="button" class="btn btn-success btn-sm" v-on:click="saveValue(item)"
                            style="">{{item}}
                    </button>
                </span>
            </div>
        </div>

    <#--增加销售属性弹框-->
        <div id="skuDiv" style="display: none;width:300px;">

            <div style="margin-left:10px;margin-top: 10px;">
                <el-tag
                        :key="tag"
                        v-for="tag in skuValue"
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
                <el-button v-else class="button-new-tag" size="small" @click="showInput">+ New Tag</el-button>
            </div>
        <#--<div class="form-group" style="margin-left:10px;margin-top: 10px;">-->
        <#--<div class="col-sm-5">-->
        <#--<input type="text" class="form-control" id="addSkuValue" name="addSkuValue"/>-->
        <#--</div>-->
        <#--<div>-->
        <#--<span class="col-sm-1" style="padding-left: 0px;width:50px">-->
        <#--<button type="button" class="btn btn-default btn-sm" style="position: relative;top: 2px;"-->
        <#--v-on:click="addSku()">添加</button>-->
        <#--</span>-->
        <#--</div>-->
        <#--</div>-->
        <#--<div style="margin-left:10px;margin-top: 10px;">-->
        <#--<span v-for="item in skuValue">-->
        <#--<span class="btn btn-success btn-sm" v-on:click="saveValue(item)"-->
        <#--style="float: left;margin-left: 5px">{{item}}-->
        <#--</span>-->
        <#--</span>-->
        <#--</div>-->
        </div>

    <#--分类-->
        <div>
            <div class="page-header"><h5 style="color: #428bca">选择分类</h5></div>
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
        </div>
    <#--基本属性-->
        <div>
            <div class="page-header"><h5 style="color: #428bca">基本属性</h5></div>
            <div class="form-group">
                <label class="col-sm-all col-sm-2 control-label">
                    <span style="color: red">*</span>
                    商品名称：
                </label>
                <div class="col-sm-all col-sm-3">
                    <input class="form-control" id="productName" name="productName"></input>
                </div>
            </div>


            <div class="form-group" style="margin-bottom: 2px;">
                <label class="col-sm-all col-sm-3 control-label" style="width: 260px;">
                    <input type="radio" name="status" value="01.person" checked> 个人设置编码

                    <input type="radio" name="status" value="02.system"> 系统自动设置
                </label>
            </div>
            <div class="form-group">
                <label class="col-sm-all col-sm-2 control-label">
                    <span style="color: red">*</span>
                    商品编码：
                </label>
                <div class="col-sm-all col-sm-3">
                    <input class="form-control" id="productId" name="productId"></input>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-all col-sm-2 control-label">
                    <span style="color: red">*</span>
                    品牌：
                </label>
                <div class="col-sm-all">
                    <div class="col-sm-3">
                        <input class="form-control" id="brandId" name="brandId"></input>
                    </div>
                    <div>
                              <span class="col-sm-1" style="padding-left: 0px">
                                  <button type="button"
                                          class="btn btn-default btn-sm"
                                          v-on:click="addSkuValue($event)"
                                          style="position: relative;top: 2px;">选择
                                </button>
                              </span>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-all col-sm-2 control-label">
                    <span style="color: red">*</span>
                    型号规格：
                </label>
                <div class="col-sm-all col-sm-3">
                    <input class="form-control" id="specification" name="specification"></input>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-all col-sm-2 control-label">
                    <span style="color: red">*</span>
                    数量单位：
                </label>
                <div class="col-sm-all col-sm-3">
                    <input class="form-control" id="unit" name="unit"></input>
                </div>
            </div>

            <div class="form-group" style="margin-bottom: 2px;">
                <label class="col-sm-all col-sm-2 control-label" style="width: 142px;">
                    <input type="checkbox" class="check" id="isWeight">允许重量采销
                </label>
            </div>

            <div class="form-group weight-disabled">
                <label class="col-sm-all col-sm-2 control-label">
                    <span style="color: red">*</span>
                    件重：
                </label>
                <div class="col-sm-all col-sm-3">
                    <input class="form-control" id="weight" name="weight" disabled="disabled"></input>
                </div>
            </div>

            <div class="form-group weight-disabled">
                <label class="col-sm-all col-sm-2 control-label">
                    <span style="color: red">*</span>
                    件重单位：
                </label>
                <div class="col-sm-all col-sm-3">
                    <input class="form-control" id="weightUnit" name="weightUnit" disabled="disabled"></input>
                </div>
            </div>
        </div>
    <#--拓展属性-->
        <div id="tuozhan" style="display: none">
            <div class="page-header"><h5 style="color: #428bca">拓展属性</h5></div>
            <div class="form-group" v-for="item in attributeValueList">
                <label class="col-sm-all col-sm-2 control-label">
                    <span style="color: red" v-if="item.isRequired=='01.yes'">*</span>
                    <span style="color: red" v-else></span>
                    {{item.attrName}}：
                </label>
                <div>
                    <div v-if="item.inputType=='01.input'" class="col-sm-all col-sm-3">
                        <input type="text" class="form-control attr-type" v-bind:id="['validCol_'+item.attrId]"
                               v-bind:name="['validCol_'+item.attrId]"/>
                    </div>
                    <div v-else class="col-sm-all">
                        <div v-if="item.attrValues.split(',').length<5" class="col-sm-3">
                            <select class="form-control attr-type" v-bind:id="['validCol_'+item.attrId]"
                                    v-bind:name="['validCol_'+item.attrId]">
                                <option value="">请选择</option>
                                <option v-for="attr in item.attrValues.split(',')" v-bind:value="attr">
                                    {{attr}}
                                </option>
                            </select>
                        </div>
                        <div v-else class="col-sm-all">
                            <div class="col-sm-3">
                                <input type="text" class="form-control attr-type" readonly="readonly"
                                       v-bind:id="['validCol_'+item.attrId]" v-bind:name="['validCol_'+item.attrId]"/>
                            </div>
                            <div>
                              <span class="col-sm-1" style="padding-left: 0px"><button type="button"
                                                                                       class="btn btn-default btn-sm"
                                                                                       v-on:click="chooseAttrValue($event,item.attrValues)"
                                                                                       style="position: relative;top: 2px;">选择
                                </button></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    <#--销售属性-->
        <div id="xiaoshou" style="display: none">
            <div class="page-header"><h5 style="color: #428bca">销售属性</h5></div>
            <div class="form-group" v-for="item in skuAttrValueList">
                <label class="col-sm-all col-sm-2 control-label">
                    <span style="color: red">*</span>
                    {{item.skuAttrName}}：
                </label>

                <div class="col-sm-all">
                    <div class="col-sm-5">
                        <input type="text" class="form-control sku-type" v-bind:id="['validSkuCol_'+item.skuAttrId]"
                               v-bind:name="['validSkuCol_'+item.skuAttrId]" readonly/>
                    </div>
                    <div>
                              <span class="col-sm-1" style="padding-left: 0px">
                                  <button type="button"
                                          class="btn btn-default btn-sm"
                                          v-on:click="addSkuValue($event)"
                                          style="position: relative;top: 2px;">添加
                                </button>
                              </span>
                    </div>
                </div>
            </div>
        </div>

        <div id="jiage">
            <div class="form-group">
                <label class="col-sm-all col-sm-2 control-label">
                    <span style="color: red">*</span>
                    采购价：
                </label>
                <div class="col-sm-all col-sm-3">
                    <input class="form-control" id="buyPrice" name="buyPrice" @change="buyPrice()"></input>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-all col-sm-2 control-label">
                    <span style="color: red">*</span>
                    销售价：
                </label>
                <div class="col-sm-all col-sm-3">
                    <input class="form-control" id="sailPrice" name="sailPrice" @change="sailPrice()"></input>
                </div>
            </div>
        </div>


        <div class="panel-body" id="skuTable" style="display: none">
            <el-table :data="list" style="width: 100%">
                <el-table-column
                        v-for="(col,index) in cols"
                        :prop="col.prop" :label="col.label">
                    <template slot-scope="item">
                        <span v-if="index<skuAttrValueList.length"
                              v-bind:data-attr-id="skuAttrValueList[index].skuAttrId"
                              v-bind:data-attr-value="item.row[index]" v-bind:id="['skuAttrId_'+index+item.$index]"> {{item.row[index]}}</span>
                        <span v-else-if="index==skuAttrValueList.length">
                            <input class="form-control" v-bind:id="['skuIdList_'+index+item.$index]"
                                   v-bind:name="['skuIdList_'+index+item.$index]"
                                   placeholder="sku编号"/>
                        </span>
                        <span v-else-if="index==skuAttrValueList.length+1">
                            <input class="form-control buyPrice" v-bind:id="['buyPriceList_'+index+item.$index]"
                                   v-bind:name="['buyPriceList_'+index+item.$index]"
                                   placeholder="采购价"/>
                        </span>
                        <span v-else-if="index==skuAttrValueList.length+2">
                            <input class="form-control sailPrice" v-bind:id="['sailPriceList_'+index+item.$index]"
                                   v-bind:name="['sailPriceList_'+index+item.$index]"
                                   placeholder="销售价"/>
                        </span>
                    <#--<span v-else> <el-button-->
                    <#--@click.native.prevent="deleteRow(item.$index, list)"-->
                    <#--type="text"-->
                    <#--size="small">移除</el-button>-->
                    <#--</span>-->
                    </template>
                </el-table-column>
            </el-table>
        </div>

        <input type="hidden" id="categoryId" name="categoryId" value="">
        <input type="hidden" id="parentId" name="parentId" value="">
        <input type="hidden" id="topId" name="topId" value="">

        <div style="padding-left: 80px;">
            <label>
                <button type="button" class="btn btn-success btn-sm" v-on:click="save()"
                        style="float: left;">提交
                </button>

                <button type="button" class="btn btn-default btn-sm" v-on:click="cancel()"
                        style="float: left;margin-left: 30px">取消
                </button>
            </label>

        </div>

    </form>
</div>
<input type="hidden" id="base_url" value="${request.contextPath}">
<#include "../../common/common-js.ftl">

<script type="text/javascript" src="${request.contextPath}/static/js/sub/product/addProduct.js"></script>
</body>
</html>