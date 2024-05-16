<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 2024-05-16
  Time: 오후 3:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Member List</title>
</head>
<body>

<h1>
    으에에에에에에에엘에에에엘에레에엥레에에에에
</h1>


${list}

<h2>
    ${list[0].memberNo}
    ${list[0].memberName}
    ${list[0].dueDate}
</h2>

<ul>
    <c:forEach var="dto" items="${list}">
        <li>
                ${dto}
        </li>
    </c:forEach>
</ul>

</body>
</html>
