<!DOCTYPE html>
<html>
<head>
    <#include "../../common/common-css.ftl">
    <style type="text/css">
        .left {
            float: left;
        }

        .w-150 {
            width: 130px;
        }

        .w-90 {
            width: 70px;
        }

    </style>
</head>
<body style="padding-top: 20px !important;">
<div class="ilvdo-container ilvdo-container-color individual-customer"
     id="attribute-main" style="min-width:900px;">

<#--<!-- 操作按钮 &ndash;&gt;-->
<#--<div class="clearfix" style="margin-top: 10px">-->
<#--<div class="pull-left">-->
<#--<button type="button" class="btn btn-default btn-sm" id="export_btn" v-on:click="search()">-->
<#--<span class="glyphicon glyphicon-share-alt"></span>导出-->
<#--</button>-->
<#--</div>-->
<#--<div class="pull-right">-->
<#--</div>-->
<#--</div>-->

<#--<table id="demo" lay-filter="test"></table>-->

    <!-- 操作按钮 -->
    <div class="clearfix" style="margin-top: 10px">
        <div class="pull-left">
            <button type="button" class="btn btn-default btn-sm" id="export_btn" v-on:click="add()">
                <span class="glyphicon glyphicon-plus"></span>新增
            </button>
        </div>
        <div class="pull-right">
        </div>
    </div>

    <div class="panel panel-default" style="margin-top: 10px">
        <div class="panel-heading">
            <form class="form-horizontal" id="">
                <div class="row">


                    <div class="" style="width: 70px; float: right;; margin: 5px 8px">
                        <button type="button" class="btn btn-primary btn-sm"
                                id="search_btn" v-on:click="search()">
                            <span class="glyphicon glyphicon-zoom-in"></span>查找
                        </button>
                    </div>
                </div>
            </form>
        </div>

        <div class="panel-body">
            <el-table :data="list" style="width: 100%" stripe @sort-change="handleSortChange">
                <el-table-column
                        prop="BUY_CODE"
                        label="采购订单号"
                        width="100">
                </el-table-column>
                <el-table-column
                        prop="SUPPLIER_NAME"
                        label="供应商"
                        sortable
                        width="180">
                </el-table-column>
                <el-table-column
                        prop="TOTAL_MONEY"
                        label="金额"
                        width="100">
                </el-table-column>
                <el-table-column
                        prop="SAIL_NUM"
                        label="销售数量"
                        width="100">
                </el-table-column>
                <el-table-column
                        prop="PLAN_CHARGE"
                        label="预付款"
                        width="100">
                </el-table-column>

                <el-table-column
                        prop="BILL_STATUS"
                        label="单据状态"
                        width="100"
                        sortable>
                </el-table-column>

                <el-table-column
                        prop="WAREHOUSING_STATUS"
                        label="入库状态"
                        width="100"
                        sortable>
                </el-table-column>

                <el-table-column
                        prop="BILL_TIME"
                        label="采购时间"
                        width="180"
                        sortable>
                    <template slot-scope="item">
                        {{item.row.BILL_TIME | time}}
                    </template>
                </el-table-column>
                <el-table-column
                        prop=""
                        label="操作"
                        width="180" fixed="right">
                    <template slot-scope="item">
                        <a title="查看" href="javascript:void(0);" v-on:click="showDetail(item.row.ID)">
                            <span class="glyphicon glyphicon-folder-open"></span>
                        </a>&nbsp;&nbsp;
                        <a title="红冲" href="javascript:void(0);" v-on:click="showDetail(item.row.ID)">
                            <span class="glyphicon glyphicon-asterisk"></span>
                        </a>&nbsp;&nbsp;
                        <a title="删除" href="javascript:void(0);" v-on:click="showDetail(item.row.ID)">
                            <span class="glyphicon glyphicon-remove"></span>
                        </a>
                    </template>
                </el-table-column>
            <#--<el-table-column label="操作">-->
            <#--<template slot-scope="scope">-->
            <#--<el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>-->
            <#--<el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除-->
            <#--</el-button>-->
            <#--</template>-->
            <#--</el-table-column>-->
            </el-table>
        </div>

        <div class="block">
            <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :page-sizes="[5, 10, 20, 50]"
                    :page-size="5"
                    current-page="1"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="total">
            </el-pagination>
        </div>


    <#--<div class="panel-body">-->
    <#--<table class="table table-hover" id="table">-->
    <#--<thead>-->
    <#--<tr>-->
    <#--<th>序号</th>-->
    <#--<th>商品编码</th>-->
    <#--<th>商品名称</th>-->
    <#--<th>品牌</th>-->
    <#--<th>商品分类</th>-->
    <#--<th>更新时间</th>-->
    <#--<th>操作</th>-->
    <#--</tr>-->
    <#--</thead>-->
    <#--<tbody v-for="item in list">-->
    <#--<tr>-->
    <#--<td>{{item.ID}}</td>-->
    <#--<td>{{item.PRODUCT_CODE}}</td>-->
    <#--<td>{{item.PRODUCT_NAME}}</td>-->
    <#--<td>{{item.BRAND_NAME}}</td>-->
    <#--<td>{{item.CATEGORY_NAME}}</td>-->
    <#--<td>{{item.LAST_OPERATOR_TIME | time}}</td>-->
    <#--<td>-->
    <#--&lt;#&ndash;<a title="查看" href="javascript:void(0);" v-on:click="showDetail(item.attrId)">&ndash;&gt;-->
    <#--&lt;#&ndash;<span class="glyphicon glyphicon-folder-open"></span>&ndash;&gt;-->
    <#--&lt;#&ndash;</a>&ndash;&gt;-->
    <#--&lt;#&ndash;<a title="编辑" href="javascript:void(0);" v-on:click="edit(item.attrId)">&ndash;&gt;-->
    <#--&lt;#&ndash;<span class=" glyphicon glyphicon-edit"></span>&ndash;&gt;-->
    <#--&lt;#&ndash;</a>&ndash;&gt;-->
    <#--&lt;#&ndash;<a title="禁用" href="javascript:void(0);" v-on:click="editDisable(item.id)" v-if="item.status=='01.enable'">&ndash;&gt;-->
    <#--&lt;#&ndash;<span class="glyphicon glyphicon-ban-circle"></span>&ndash;&gt;-->
    <#--&lt;#&ndash;</a>&ndash;&gt;-->
    <#--&lt;#&ndash;<a title="启用" href="javascript:void(0);" v-on:click="editEnable(item.id)" v-else>&ndash;&gt;-->
    <#--&lt;#&ndash;<span class="glyphicon glyphicon-ok-circle"></span>&ndash;&gt;-->
    <#--&lt;#&ndash;</a>&ndash;&gt;-->
    <#--&lt;#&ndash;<a title="删除" href="javascript:void(0);" v-on:click="deleteOne(item.id)">&ndash;&gt;-->
    <#--&lt;#&ndash;<span class="glyphicon glyphicon-remove"></span>&ndash;&gt;-->
    <#--&lt;#&ndash;</a>&ndash;&gt;-->
    <#--</td>-->
    <#--</tr>-->
    <#--</tbody>-->
    <#--</table>-->
    <#--<!-- 分页 &ndash;&gt;-->
    <#--<div class="clearfix" style="padding: 0 10px">-->
    <#--<div class="pull-left">-->
    <#--<p style="text-align: center;">-->
    <#--共有数据：<span id="itemcounts"></span>条-->
    <#--</p>-->
    <#--</div>-->
    <#--<div class="pull-right">-->
    <#--<div id="demo1"></div>-->
    <#--</div>-->
    <#--</div>-->
    <#--</div>-->


    </div>
</div>
<input type="hidden" id="base_url" value="${request.contextPath}">
<#include "../../common/common-js.ftl">

<script type="text/javascript" src="${request.contextPath}/static/js/sub/buyOrder/buyOrderList.js"></script>
</body>
</html>