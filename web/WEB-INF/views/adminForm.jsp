<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 02.12.2018
  Time: 5:40
  To change this template use File | Settings | File Templates.
--%>
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
    <%--<link href="../../css/myTagStyles.css" rel="stylesheet">
    <link href="../../css/adminStyle.css" rel="stylesheet">--%>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/myTagStyles.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/adminStyle.css"/>"/>

</head>
<body>
    <t:header/>
    <div>
        <h1>Admin Page!</h1>

        <form action="<%=request.getContextPath()%>/signOut">
            <button class="signOut" type="submit">Sign Out</button>
        </form>
        <div class="crudContainer">
            <form action="<%=request.getContextPath()%>/adminka">
                <div class="tatto">
                    <p class="input">Tattoo Name: <input name="tattooName" size="10"></p>
                    <p class="input">Link: <input name="tattooLink" size="10"></p><br>
                </div>
                <div class="newTat">
                    <p class="input">New Tattoo Name: <input name="newTattooName" size="10"></p>
                    <p class="input">New Link: <input name="newTattooLink" size="10"></p>
                    <p class="input">Id: <input name="tattooId" size="10"></p><br>
                </div>
                <button class="signOut" name="submit" value="create" type="submit">CREATE</button>
                <button class="signOut" name="submit" value="read" type="submit">READ</button>
                <button class="signOut" name="submit" value="update" type="submit">UPDATE</button>
                <button class="signOut" name="submit" value="delete" type="submit">DELETE</button>

            </form>
        </div>
    </div>
    <t:footer/>
</body>
</html>
