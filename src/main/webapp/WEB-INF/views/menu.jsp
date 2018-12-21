<ul class="nav nav-pills">
    <li class="nav-item">
        <a class="nav-link" href="create-account.html"><s:message code="index.createAccountLink"/></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="show-accounts.html"><s:message code="index.showAccountsLink"/></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="disposition.html?operationName=deposit"><s:message code="index.depositLink"/></a>
    </li>
    <sec:authorize access="hasRole('Test')">
        <li class="nav-item">
            <a class="nav-link" href="disposition.html?operationName=withdraw"><s:message code="index.withdrawLink"/></a>
        </li>
    </sec:authorize>
    <li class="nav-item">
        <a class="nav-link" href="logout.html">
            <s:message code="index.logoutLink"/>
            <sec:authentication property="principal.username"/>
        </a>
    </li>
</ul>