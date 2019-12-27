<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../../common/common.jsp"></jsp:include>
</head>
<body class="main-container">
<img style="height:200px;width:200px" src="${contextPath}/scene/getQrCode?url=http://www.baidu.com"/>
<script src="${contextPath}/static/assets/js/jquery-ui.js"></script>
<script src="${contextPath}/static/assets/js/jquery.ui.touch-punch.js"></script>
<script src="${contextPath}/static/assets/js/jqGrid/jquery.jqGrid.src.js"></script>
<script src="${contextPath}/static/assets/js/bootbox.js"></script>
<script src="${contextPath}/static/assets/js/jquery.form.js"></script>
<script src="${contextPath}/static/assets/js/jquery.validate.js"></script>

<script type="text/javascript">

</script>
</body>
</html>
