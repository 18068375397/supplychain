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

    <#--form表单-->
        <div>
            <button type="button" class="btn btn-default" id="search_btn" v-on:click="returnMainFrame()"
                    style="position: absolute;right:40px;top:12px">返 回
            </button>

            <div class="page-header"><h5 style="color: #428bca">采购订单</h5></div>

            <div class="form-group">
                <label class="col-sm-all col-sm-2 control-label">
                    <span style="color: red">*</span>
                    采购订单号：
                </label>
                <div class="col-sm-all col-sm-3">
                    <input class="form-control" id="attrId" name="attrId"></input>
                </div>

                <label class="col-sm-all col-sm-2 control-label">
                    <span style="color: red">*</span>
                    采购时间：
                </label>
                <div class="col-sm-all col-sm-3">
                    <div class="input-group date form_datetime" data-date="" data-date-format="yyyy-mm-dd"
                         data-link-field="dtp_input1" id="startTime" style="float: left">
                        <input type="text" class="form-control input-sm" id="startTime_v" name="startTime_v" size="16"
                               value="" readonly
                               style="background-color: #fff;">
                        <span class="input-group-addon" style="background-color: #fff">
									<span class="glyphicon glyphicon-remove"></span>
								</span>
                        <span class="input-group-addon" style="background-color: #fff">
									<span class="glyphicon glyphicon-calendar"></span>
								</span>
                    </div>
                </div>

            </div>


            <div class="form-group">
                <label class="col-sm-all col-sm-2 control-label">
                    <span style="color: red">*</span>
                    供货商：
                </label>
                <div class="col-sm-all col-sm-3">
                    <input class="form-control" id="attrId" name="attrId"></input>
                </div>

                <label class="col-sm-all col-sm-2 control-label">
                    <span style="color: red">*</span>
                    经办人：
                </label>
                <div class="col-sm-all col-sm-3">
                    <input class="form-control" id="attrId" name="attrId"></input>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-all col-sm-2 control-label">
                    <span style="color: red">*</span>
                    备注：
                </label>
                <div class="col-sm-all col-sm-8">
                    <input class="form-control" id="attrId" name="attrId"></input>
                </div>
            </div>


            <div class="panel-body">
                <el-table :data="list" style="width: 100%" stripe>
                    <el-table-column
                            type="index"
                            label="序号"
                            width="50">
                    </el-table-column>
                    <el-table-column
                            prop="BUY_CODE"
                            label="商品编码"
                            width="80">
                    </el-table-column>
                    <el-table-column
                            prop="SUPPLIER_NAME"
                            label="产品名称"
                            width="80">
                    </el-table-column>
                    <el-table-column
                            prop="TOTAL_MONEY"
                            label="型号规格"
                            width="80">
                    </el-table-column>
                    <el-table-column
                            prop="SAIL_NUM"
                            label="销售属性"
                            width="80">
                    </el-table-column>
                    <el-table-column
                            prop="PLAN_CHARGE"
                            label="件重"
                            width="80">
                    </el-table-column>
                    <el-table-column
                            prop="BILL_STATUS"
                            label="数量"
                            width="80"
                    </el-table-column>
                    <el-table-column
                            prop="WAREHOUSING_STATUS"
                            label="单价"
                            width="80">
                    </el-table-column>
                    <el-table-column
                            prop="BILL_TIME"
                            label="金额"
                            width="80">
                    </el-table-column>
                    <el-table-column
                            prop="BILL_TIME"
                            label="税率"
                            width="80">
                    </el-table-column>
                    <el-table-column
                            prop="BILL_TIME"
                            label="税额"
                            width="80">
                    </el-table-column>
                    <el-table-column
                            prop="BILL_TIME"
                            label="含税金额"
                            width="80">
                    </el-table-column>
                    <el-table-column
                            prop="BILL_TIME"
                            label="已完成"
                            width="80">
                    </el-table-column>
                    <el-table-column
                            prop="BILL_TIME"
                            label="未完成"
                            width="80">
                    </el-table-column>

                </el-table>
            </div>


            <div class="form-group" style="padding-top: 10px">
                <label class="col-sm-all col-sm-2 control-label">
                    <span style="color: red">*</span>
                    合计金额：
                </label>
                <div class="col-sm-all col-sm-3">
                    <input class="form-control" id="attrId" name="attrId" readonly="readonly"></input>
                </div>

                <label class="col-sm-all col-sm-2 control-label">
                    <span style="color: red">*</span>
                    预付款：
                </label>
                <div class="col-sm-all col-sm-3">
                    <input class="form-control" id="attrId" name="attrId"></input>
                </div>
            </div>


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
        </div>


    <#--挑选商品列表-->
        <div>

            <div class="form-group">
                <label class="col-sm-all col-sm-2 control-label">
                    <span style="color: red">*</span>
                    品牌：
                </label>
                <div class="col-sm-all col-sm-3">
                    <select id="selectPicker" class="selectPicker" data-live-search="true" title="请选择">
                        <option v-for="item in brandList" v-bind:value="item.brandId">{{item.brandName}}</option>
                    </select>
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

            <div class="panel-body">
                <el-table :data="productSkuList" style="width: 100%" stripe :span-method="objectSpanMethod">
                    <el-table-column
                            prop="PRODUCT_ID"
                            label="商品编码"
                            width="80">
                    </el-table-column>
                    <el-table-column
                            prop="PRODUCT_NAME"
                            label="商品名称"
                            width="80">
                    </el-table-column>
                    <el-table-column
                            prop="BRAND_NAME"
                            label="品牌"
                            width="80">
                    </el-table-column>
                    <el-table-column
                            prop="CATEGORY_NAME"
                            label="销售属性"
                            width="80">
                    </el-table-column>
                    <el-table-column
                            prop="SKU_VALUE"
                            label="商品分类"
                            width="80">
                    </el-table-column>
                    <el-table-column
                            prop="NUMBER"
                            label="数量"
                            width="80">
                    </el-table-column>
                    <el-table-column
                            prop="IS_WEIGHT"
                            label="重量采销"
                            width="80">
                    </el-table-column>

                </el-table>
            </div>


        </div>


    </form>
</div>
<input type="hidden" id="base_url" value="${request.contextPath}">
<#include "../../common/common-js.ftl">

<script type="text/javascript" src="${request.contextPath}/static/js/sub/buyOrder/addBuyOrder.js"></script>
</body>
</html>