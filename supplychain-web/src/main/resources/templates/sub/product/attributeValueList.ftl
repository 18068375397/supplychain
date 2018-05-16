<!DOCTYPE html>
<html>
<head>
   <#include "../../common/common-css.ftl">
</head>
<body style="padding-top: 20px !important;">
<div class="ilvdo-container ilvdo-container-color individual-customer"
     id="attribute-main" style="min-width:900px;">

    <button type="button" class="btn btn-default" id="search_btn" v-on:click="returnMainFrame()"
            style="position: absolute;right:40px;">返 回
    </button>
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

                </div>
            </form>
        </div>

        <div class="panel-body">
            <table class="table table-hover" id="table" v-cloak>
                <thead>
                <tr>
                    <th>属性值ID</th>
                    <th>属性值名称</th>
                    <th>状态</th>
                    <th>创建时间</th>
                    <th>创建时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody v-for="item in list">
                <tr>
                    <td>{{item.valueId}}</td>
                    <td>{{item.valueName}}</td>
                    <td>{{item.status}}</td>
                    <td>{{item.operator}}</td>
                    <td>{{item.createTime | time}}</td>
                    <td>
                        <a title="编辑" href="javascript:void(0);" v-on:click="edit(item.id)">
                            <span class=" glyphicon glyphicon-edit"></span>
                        </a>
                        <a title="删除" href="javascript:void(0);" v-on:click="deleteOne(item.id)">
                            <span class="glyphicon glyphicon-remove"></span>
                        </a>
                    </td>
                </tr>
                </tbody>
            </table>
            <!-- 分页 -->
            <div class="clearfix" style="padding: 0 10px">
                <div class="pull-left">
                    <p style="text-align: center;">
                        共有数据：<span id="itemcounts"></span>条
                    </p>
                </div>
                <div class="pull-right">
                    <div id="demo1"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<input type="hidden" id="base_url" value="${request.contextPath}">
<#include "../../common/common-js.ftl">

<script type="text/javascript" src="${request.contextPath}/static/js/sub/product/attributeValueList.js"></script>
</body>
</html>