<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
		<thead>
		<tr>
			<th>Numer palety</th>
			<th>nazwa towaru</th>
		</tr>
		</thead>
		<tbody>
	<c:forEach items="${item2}" var="idpaleta">
		<tr>
			<td>${idpaleta.key}</td>
			<td>
			<c:forEach items="${idpaleta.value}"  var = "name" >
				<p>${name}</p>
			</c:forEach>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<c:forEach items="${placelist}" var="list">
	<p>${list}</p>
</c:forEach>
</body>
</html>