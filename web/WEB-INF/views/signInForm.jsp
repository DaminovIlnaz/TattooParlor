<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 28.11.2018
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
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
<t:header />
    <div class="content">
        <h1>Sign In</h1>
        <div id="wrapper">
            <form action="<%=request.getContextPath()%>/signInWorker" id="signin" method="" action="" autocomplete="off">
                <input type="text" id="login" name="login" placeholder="login" />
                <input type="password" id="password" name="password" placeholder="password" />
                <button type="submit">&#xf0da;</button>
                Remember me: <input name ="remember" type='checkbox'/>
            </form>
        </div>

    </div>
<t:footer/>
</body>
</html>
