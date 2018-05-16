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

    <!-- 操作按钮 -->
    <div class="clearfix" style="margin-top: 10px">
        <div class="pull-left">
            <button type="button" class="btn btn-default btn-sm" id="add_btn" v-on:click="add()">
                <span class="glyphicon glyphicon-plus"></span>新增
            </button>
            <button type="button" class="btn btn-default btn-sm" id="upload_btn" v-on:click="upload()">
                <span class="glyphicon glyphicon-cloud-upload"></span>导入
            </button>
        </div>
        <div class="pull-right">
        </div>
    </div>

    <div class="panel panel-default" style="margin-top: 10px">
        <div class="panel-heading">
            <form class="form-horizontal" id="">
                <div class="row">
                    <!-- 按钮操作 -->

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
            <el-table :data="list" style="width: 100%;" stripe @sort-change="handleSortChange">
                <el-table-column
                        prop="BRAND_ID"
                        label="品牌编码"
                        sortable
                        width="200">
                </el-table-column>
                <el-table-column
                        prop="BRAND_NAME"
                        label="品牌名称"
                        width="200">
                </el-table-column>
                <el-table-column
                        prop="LAST_OPERATOR_TIME"
                        label="更新时间"
                        width="200"
                        sortable>
                    <template slot-scope="item">
                        {{item.row.LAST_OPERATOR_TIME | time}}
                    </template>
                </el-table-column>
                <el-table-column
                        prop=""
                        label="操作"
                        width="200"
                        fixed="right">
                    <template slot-scope="item">
                        <a title="编辑" href="javascript:void(0);" v-on:click="edit(item.row.ID)">
                            <span class=" glyphicon glyphicon-edit"></span>
                        </a>
                        <a title="删除" href="javascript:void(0);" v-on:click="deleteOne(item.row.ID, item.row.BRAND_ID)">
                            <span class="glyphicon glyphicon-remove"></span>
                        </a>
                    </template>
                </el-table-column>
            </el-table>

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

        <#--<table class="table table-hover" id="table" v-cloak>-->
        <#--<thead>-->
        <#--<tr>-->
        <#--<th>品牌编码</th>-->
        <#--<th>品牌名称</th>-->
        <#--<th>更新人</th>-->
        <#--<th>更新时间</th>-->
        <#--<th>操作</th>-->
        <#--</tr>-->
        <#--</thead>-->
        <#--<tbody v-for="item in list">-->
        <#--<tr>-->
        <#--<td>{{item.brandId}}</td>-->
        <#--<td>{{item.brandName}}</td>-->
        <#--<td>{{item.lastOperator}}</td>-->
        <#--<td>{{item.lastOperatorTime | time}}</td>-->
        <#--<td>-->
        <#--<a title="编辑" href="javascript:void(0);" v-on:click="edit(item.id)">-->
        <#--<span class=" glyphicon glyphicon-edit"></span>-->
        <#--</a>-->
        <#--<a title="删除" href="javascript:void(0);" v-on:click="deleteOne(item.id, item.brandId)">-->
        <#--<span class="glyphicon glyphicon-remove"></span>-->
        <#--</a>-->
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
        </div>
    </div>
</div>
<input type="hidden" id="base_url" value="${request.contextPath}">
<#include "../../common/common-js.ftl">

<script type="text/javascript" src="${request.contextPath}/static/js/sub/brand/brandList.js"></script>
</body>
</html>