<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 05.12.2018
  Time: 2:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/myTagStyles.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/adminStyle.css"/>"/>
</head>
<body>
<t:header/>
<h1>Order made successfully!</h1>
<a href="fill" class="butt">Make another order</a>
<t:footer/>
</body>
</html>
