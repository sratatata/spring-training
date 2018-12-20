<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Bank</title>
    <%@ include file="resources.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>
<div class="container">
    <c:if test="${pageViewModel.totalPages > 0}">
        <table class="table">
            <thead>
            <tr>
                <th><s:message code="accounts.accountNumber"/></th>
                <th><s:message code="accounts.balance"/></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="account" items="${pageViewModel.data}">
                <tr>
                    <td>${account.number}</td>
                    <td><f:formatNumber type="currency" value="${account.balance / 100}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <c:if test="${pageViewModel.pageNumber > 0}">
            <a href="show-accounts.html?pageNumber=${pageViewModel.pageNumber - 1}"><s:message code="accounts.previousPage"/></a>
        </c:if>
        <c:if test="${pageViewModel.pageNumber + 1 < pageViewModel.totalPages}">
            <a href="show-accounts.html?pageNumber=${pageViewModel.pageNumber + 1}" class="float-right"><s:message code="accounts.nextPage"/></a>
        </c:if>
        <div class="text-center">${pageViewModel.pageNumber + 1} / ${pageViewModel.totalPages}</div>
    </c:if>
</div>
</body>
</html>
