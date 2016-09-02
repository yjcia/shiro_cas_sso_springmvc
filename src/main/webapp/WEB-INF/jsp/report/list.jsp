<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="zhangfn" uri="http://github.com/zhangkaitao/tags/zhang-functions" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/css.css">
</head>
<body>

<c:if test="${not empty msg}">
    <div class="message">${msg}</div>
</c:if>

<shiro:hasPermission name="report:export">
    <a href="${pageContext.request.contextPath}/report/export">报表导出</a><br/>
</shiro:hasPermission>
<shiro:hasPermission name="report:pdf_preview">
    <a href="${pageContext.request.contextPath}/report/pdf_preview">PDF报表预览</a><br/>
</shiro:hasPermission>
<shiro:hasPermission name="report:html_preview">
    <a href="${pageContext.request.contextPath}/report/html_preview">HTML报表预览</a><br/>
</shiro:hasPermission>
</body>
</html>