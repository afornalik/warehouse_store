<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajka | Location selection</title>
</head>
<body>

	<c:if test="${not empty selected}">
		<h2>${selected}</h2>
	</c:if>
	<form method="post">
		
			<c:forEach items="${placeList}" var="listItem">

				<input type="submit" name="listItem.localizationName" value="${listItem.localizationName}">
			
			</c:forEach>
		 	<p>${maploc}</p>
	</form>

	 <table>
		<c:forEach items="${maploc}" var="palmapkey">
		<tr>
			<th>${palmapkey.key.getId()}</th>
			<c:forEach items="${palmapkey.value}" var="itname" >
				<tr>
					<td>${itname.getIdItemKind().getName()}</td>
				</tr>
			</c:forEach>
		
		</c:forEach>
	</table> 
</body>
</html>