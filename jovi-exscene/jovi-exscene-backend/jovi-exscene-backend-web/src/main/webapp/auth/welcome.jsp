<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<html>
<head>
    <link rel="stylesheet" href="${contextPath}/static/assets/css/bootstrap.css"/>
    <link rel="stylesheet" href="${contextPath}/static/assets/css/font-awesome.css"/>
    <link rel="stylesheet" href="${contextPath}/static/assets/css/ace-fonts.css"/>
    <!-- ace styles -->
    <link rel="stylesheet" href="${contextPath}/static/assets/css/ace.css" class="ace-main-stylesheet"
          id="main-ace-style"/>
</head>
<body>

<div class="main-container" >
    <div class="main-content">
        <div class="main-content-inner">
            <div class="page-content">

                <div class="row">
                    <div class="col-xs-12">
                        <div class="alert alert-block alert-success">
                            <h2 style="margin-bottom: 20px">
                                <i class="ace-icon fa fa-cogs blue"></i>
                                现在进入的是
                                <strong class="blue">
                                    智慧场景运营后台
                                </strong>
                            </h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>



