<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP-Model2(MVC)-todoUpd</title>
</head>
<body>
<h1><%= "임시 todoUpd 화면." %>
</h1>
<form method="post" action="/todo/update ">
  <div>
    <input type="text" name="title" placeholder="제목을 입력해주세요." value="${sample.title}" >
  </div>
  <div>
    <input type="date" name="dueDate" value="${sample.dueDate}" >
  </div>
  <div>
    <button type="submit">수정하기</button>
  </div>
</form>

<%--삭제--%>
<form method="post" action="/todo/delete">
  <%--  화면에는 안보임. --%>
  <input type="hidden" name="tno" value="${sample.tno}">
  <button type="submit">삭제하기.</button>
</form>

<form method="get" action="/todo/list">
  <button type="submit">전체메뉴</button>
</form>
</body>
</html>
