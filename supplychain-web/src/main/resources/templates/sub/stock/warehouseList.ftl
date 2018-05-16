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
                        prop="WAREHOUSE_ID"
                        label="仓库编号"
                        sortable
                        width="200">
                </el-table-column>
                <el-table-column
                        prop="WAREHOUSE_NAME"
                        label="仓库名称"
                        width="200">
                </el-table-column>
                <el-table-column
                        prop="WAREHOUSE_ADDRESS"
                        label="仓库地址"
                        width="360">
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
                        width="80"
                        fixed="right">
                    <template slot-scope="item">
                        <a title="编辑" href="javascript:void(0);" v-on:click="edit(item.row.ID)">
                            <span class=" glyphicon glyphicon-edit"></span>
                        </a>
                        <a title="删除" href="javascript:void(0);"
                           v-on:click="deleteOne(item.row.ID, item.row.WAREHOUSE_ID)">
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
        </div>
    </div>
</div>
<input type="hidden" id="base_url" value="${request.contextPath}">
<#include "../../common/common-js.ftl">

<script type="text/javascript" src="${request.contextPath}/static/js/sub/stock/warehouseList.js"></script>
</body>
</html>