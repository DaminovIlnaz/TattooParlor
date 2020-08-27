<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Squadfree - Free bootstrap 3 one page template</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/myTagStyles.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/tattsCollectionStyles.css"/>"/>
</head>
<body>
<div id="headerMain">
    <t:header/>
</div>
<div class="content">
    <article class="models">

        <form action="<%=request.getContextPath()%>/order">
            <p id="inp" class="input">Enter tattoo name: <input name="name" size="10"></p>
            <button class="signOut" name="submit" value="create" type="submit">Make order</button>
        </form>

        <c:forEach items="${tatts}" var="product">
            <div class="prod">
                <p>${product.getValue().getName()}</p>
                <img src="${product.getValue().getLink()}" alt="Car" class="picModels">
            </div>
        </c:forEach>
    </article>
</div>
<t:footer/>
</body>
</html>
