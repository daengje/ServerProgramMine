<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP-Model2(MVC)-todoList</title>
</head>
<body>
<ul>
  <button><a href="/todo/register">Todo작성</a></button>
  <%--  서버 컨트롤러에서 전달 받은 박스, 라벨 이름: list, --%>
  <%--  내용물: 디비에서 가져온 10개의 값--%>
  <c:forEach items="${list}" var="dto">
    <li>
      <span>
        <a href="/todo/read?tno=${dto.tno}">${dto.tno}</a>
      </span>
      <span>
          ${dto.title}
      </span>
      <span>
          ${dto.dueDate}
      </span>
      <span>
          ${dto.finished ? "완료" : "미완료"}
      </span>
    </li>
  </c:forEach>
</ul>
</body>
</html>
