<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Squadfree - Free bootstrap 3 one page template</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/myTagStyles.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/footerStyle.css"/>"/>
</head>
<body>
<div id="headerMain">
    <t:header/>
</div>
<div class="content">
    <h1>Sign Up</h1>
    <div id="wrapper">
        <form action="<%=request.getContextPath()%>/signUpWorker" id="signin">
            <input type="text" id="username" name="username" placeholder="username" />
            <input type="text" id="email" name="email" placeholder="email" />
            <input type="password" id="password" name="password" placeholder="password" />
            <button type="submit">&#xf0da;</button>
        </form>
    </div>
    <t:footer/>
</div>
</body>
</html>

