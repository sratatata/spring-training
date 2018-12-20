<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Bank</title>
    <%@ include file="resources.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>
<div class="container">
    <s:message code="account-created.successMessage" arguments="${accountViewModel.number}"/>
</div>
</body>
</html>
