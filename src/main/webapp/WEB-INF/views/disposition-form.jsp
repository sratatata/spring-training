<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Bank</title>
    <%@ include file="resources.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>
<div class="container">
    <h1><s:message code="${param.operationName}"/></h1>
    <%--@elvariable id="dispositionViewModel" type="pl.training.bank.disposition.DispositionViewModel"--%>
    <sf:form modelAttribute="dispositionViewModel" method="post">
        <div class="form-group">
            <label for="accountNumber"><s:message code="disposition.accountNumber"/></label>
            <sf:input id="accountNumber" class="form-control" path="accountNumber"/>
            <sf:errors path="accountNumber"/>
        </div>
        <div class="form-group">
            <label for="funds"><s:message code="disposition.funds"/></label>
            <sf:input id="funds" class="form-control" path="funds"/>
            <sf:errors path="funds"/>
        </div>
        <button type="submit" class="btn btn-primary"><s:message code="disposition.submit"/></button>
    </sf:form>
</div>
</body>
</html>
