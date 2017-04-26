<!--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
-->
<html>
<head>
    <title>List of books</title>
</head>
<body>

<div style="position: fixed; top: 0%; right: 0;">
    <form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" value="Logout" />
    </form>
</div>

<h1>
    Список произведений:
</h1>
<table>
    <c:forEach items="${requestScope.books}" var="book">
        <tr>
            <td><c:out value="${book.author}"></c:out></td>
            <td><c:out value="${book.title}"></c:out></td>
            <td><c:out value="${book.publishingHouse}"></c:out></td>
            <td><c:out value="${book.city}"></c:out></td>
            <td><c:out value="${book.year}"></c:out></td>
            <td><c:out value="${book.pagesCount}"></c:out></td>
        </tr>
    </c:forEach>
</table>
<p></p>
<h1>
    Список пользователей:
</h1>
<table>
    <c:forEach items="${requestScope.users}" var="user">
        <tr>
            <td><c:out value="${user.login}"></c:out></td>
            <td><c:out value="${user.accountType}"></c:out></td>
            <td><c:out value="${user.locked}"></c:out></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
