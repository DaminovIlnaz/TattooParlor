<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
<t:header/>
    <h1><c:out value="${info}" default="NO DATA" escapeXml="true" /></h1>
    <a href="signUp" class="butt">Sign Up</a>
<t:footer/>
</body>
</html>
