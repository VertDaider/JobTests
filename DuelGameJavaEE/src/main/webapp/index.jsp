<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users</title>
</head>
<body>
<h2>Users List</h2>
<p><a href='<c:url value="/login" />'>Login</a></p>
<p><a href='<c:url value="/create" />'>Create new</a></p>
<table>
<tr><th>Name</th><th>HP</th><th>Attack</th><th>Rating</th><th></th></tr>
<c:forEach var="user" items="${users}">
 <tr><td>${user.name}</td>
    <td>${user.hp}</td>
    <td>${user.attack}</td>
    <td>${user.rating}</td>
    <td>
    <a href='<c:url value="/edit?id=${user.id}" />'>Edit</a> |
    <form method="post" action='<c:url value="/delete?id=${user.id}" />' style="display:inline;" accept-charset="UTF-8">
        <input type="hidden" name="id" value="${user.id}">
        <input type="submit" value="Delete">
    </form>
 </td></tr>
</c:forEach>
</table>
</body>
</html>