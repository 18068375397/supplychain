<#macro layout>
<!DOCTYPE html>
<html>
<head>
    <title>ERP管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <#include "common-css.ftl">
</head>
<body class="bootstrap-admin-with-small-navbar">
<#-- 头信息 -->
    <#include "top.ftl">

<!-- left, vertical navbar & content -->
<div class="container">
    <!-- left, vertical navbar & content -->
    <div class="row">
    <#-- 目录 -->
    <#--  <#include "sidebar.ftl" >-->

    <#-- 在这里嵌入main content -->
            <#nested>
    </div>

    <div class="row">
    <#-- 脚信息 -->
            <#include "foot.ftl">
    </div>
</div>

</body>
</html>


</#macro>