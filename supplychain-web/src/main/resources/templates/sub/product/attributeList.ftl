﻿<!DOCTYPE html>
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
                    <!-- 按钮操作 -->
                    <div style="float: left; margin: 5px 8px">
                        <label for="" class="control-label left w-90" style="line-height: 14px;">类目：</label>
                        <select class="form-control input-sm left w-150" name="attributeOne" id="attributeOne">
                            <option value="">请选择</option>
                            <option v-for="item in attributeOneList" v-bind:value="item.categoryId">
                                {{item.categoryName}}
                            </option>
                        </select>
                        <select class="form-control input-sm left w-150" name="attributeTwo" id="attributeTwo">
                            <option value="">请选择</option>
                            <option v-for="item in attributeTwoList" v-bind:value="item.categoryId">
                                {{item.categoryName}}
                            </option>
                        </select>
                        <select class="form-control input-sm left w-150" name="attributeThree" id="attributeThree">
                            <option value="">请选择</option>
                            <option v-for="item in attributeThreeList" v-bind:value="item.categoryId"
                                    v-bind:data-parent-id="[item.parentId]" v-bind:data-top-id="[item.topId]">
                                {{item.categoryName}}
                            </option>
                        </select>
                    </div>

                    <div style="float: left; margin: 5px 8px">
                        <label for="" class="control-label" style="float: left;line-height: 14px;">状态：</label>
                        <div class="radio left">
                            <span style="float: left;padding-left: 20px;">
                                <input type="radio" name="status" value="01.enable" checked> 启用

                            </span>
                            <span style="float: left;padding-left: 20px;">
                                <input type="radio" name="status" value="02.disable"> 停用
                            </span>
                        </div>
                    </div>

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
                        prop="CATEGORY_ID"
                        label="归属分类"
                        sortable
                        width="150">
                </el-table-column>
                <el-table-column
                        prop="ATTR_NAME"
                        label="属性名称"
                        width="150">
                </el-table-column>
                <el-table-column
                        prop="IS_REQUIRED"
                        label="是否必填"
                        width="120">
                </el-table-column>
                <el-table-column
                        prop="INPUT_TYPE"
                        label="录入类型"
                        width="150">
                </el-table-column>
                <el-table-column
                        prop="SORT"
                        label="排序值"
                        width="120">
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
                        width="150"
                        fixed="right">
                    <template slot-scope="item">
                        <a title="编辑" href="javascript:void(0);" v-on:click="edit(item.row.ATTR_ID)">
                            <span class=" glyphicon glyphicon-edit"></span>
                        </a>
                        <a title="禁用" href="javascript:void(0);" v-on:click="editDisable(item.row.ID)"
                           v-if="item.row.STATUS=='01.enable'">
                            <span class="glyphicon glyphicon-ban-circle"></span>
                        </a>
                        <a title="启用" href="javascript:void(0);" v-on:click="editEnable(item.row.ID)" v-else>
                            <span class="glyphicon glyphicon-ok-circle"></span>
                        </a>
                        <a title="删除" href="javascript:void(0);" v-on:click="deleteOne(item.row.ID)">
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
        <#--<th>序号</th>-->
        <#--<th>归属类目</th>-->
        <#--<th>属性名称</th>-->
        <#--<th>属性类型</th>-->
        <#--<th>是否必填</th>-->
        <#--<th>是否筛选</th>-->
        <#--<th>录入类型</th>-->
        <#--<th>字段类型</th>-->
        <#--<th>状态</th>-->
        <#--<th>创建人</th>-->
        <#--<th>创建时间</th>-->
        <#--<th>最后编辑人</th>-->
        <#--<th>最后编辑时间</th>-->
        <#--<th>操作</th>-->
        <#--</tr>-->
        <#--</thead>-->
        <#--<tbody v-for="item in list">-->
        <#--<tr>-->
        <#--<td>{{item.id}}</td>-->
        <#--<td>{{item.categoryId}}</td>-->
        <#--<td>{{item.attrName}}</td>-->
        <#--<td>{{item.attrType}}</td>-->
        <#--<td>{{item.isRequired}}</td>-->
        <#--<td>{{item.isSearch}}</td>-->
        <#--<td>{{item.inputType}}</td>-->
        <#--<td>{{item.columnType}}</td>-->
        <#--<td>{{item.status}}</td>-->
        <#--<td>{{item.operator}}</td>-->
        <#--<td>{{item.createTime | time}}</td>-->
        <#--<td>{{item.lastOperator}}</td>-->
        <#--<td>{{item.lastOperatorTime | time}}</td>-->
        <#--<td>-->
        <#--<a title="查看" href="javascript:void(0);" v-on:click="showDetail(item.attrId)">-->
        <#--<span class="glyphicon glyphicon-folder-open"></span>-->
        <#--</a>-->
        <#--<a title="编辑" href="javascript:void(0);" v-on:click="edit(item.attrId)">-->
        <#--<span class=" glyphicon glyphicon-edit"></span>-->
        <#--</a>-->
        <#--<a title="禁用" href="javascript:void(0);" v-on:click="editDisable(item.id)" v-if="item.status=='01.enable'">-->
        <#--<span class="glyphicon glyphicon-ban-circle"></span>-->
        <#--</a>-->
        <#--<a title="启用" href="javascript:void(0);" v-on:click="editEnable(item.id)" v-else>-->
        <#--<span class="glyphicon glyphicon-ok-circle"></span>-->
        <#--</a>-->
        <#--<a title="删除" href="javascript:void(0);" v-on:click="deleteOne(item.id)">-->
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

<script type="text/javascript" src="${request.contextPath}/static/js/sub/product/attributeList.js"></script>
</body>
</html>