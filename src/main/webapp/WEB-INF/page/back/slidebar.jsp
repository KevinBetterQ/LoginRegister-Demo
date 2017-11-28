<%@ page import="com.matrix.entity.User" %>
<%--
  Created by eclipse.
  User: qwk
  Date: 2017/11/27
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <div class="navbar-brand"> Matrix</div>
            <div class="navbar-brand" style="float:right"><span class="glyphicon glyphicon-user"></span> ${uname} </div>
        </div>
    </div>
</nav>

<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
    <ul class="nav menu">
        <li class="parent" class="active">
            <a href="#sub-item-1">
                <span class="glyphicon glyphicon-list"></span> 用户 <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span>
            </a>
            <ul class="children collapse" id="sub-item-1">
               <li>
                    <a class="" href="#">
                        <span class="glyphicon glyphicon-th-large"></span> 添加用户
                    </a>
                </li>
                <li>
                    <a class="" href="back/manageuser">
                        <span class="glyphicon glyphicon-th-large"></span> 用户管理
                    </a>
                </li>
              
            </ul>
        </li>
        <li class="parent" class="active">
            <a href="#sub-item-2">
                <span class="glyphicon glyphicon-list"></span> 展开 <span data-toggle="collapse" href="#sub-item-2" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span>
            </a>
            <ul class="children collapse" id="sub-item-2">
                <li>
                    <a class="" href="#">
                        <span class="glyphicon glyphicon-th-large"></span> item1
                    </a>
                </li>
                <li>
                    <a class="" href="#">
                        <span class="glyphicon glyphicon-th-large"></span> item2
                    </a>
                </li>
            </ul>
        </li>
        
        <li role="presentation" class="divider"></li>
        <li><a href="#"><span class="glyphicon glyphicon-remove-sign"></span> 退出登录</a></li>
    </ul>
</div>