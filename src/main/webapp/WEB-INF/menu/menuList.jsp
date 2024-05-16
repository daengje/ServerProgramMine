<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 2024-05-16
  Time: 오후 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>안녕하세요</title>
</head>
<body>
<h1>으에에에에에에</h1>

${list}

<h2>
    ${list[0].menuNo}
    ${list[0].menuTitle}
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
