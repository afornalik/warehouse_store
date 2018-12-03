<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>TEST</h1>


<c:url var="testadd" value="/test" />
<form:form action="<c:url  value="/test/${name.id}" />" modelAttribute="test3" method="post"> 
	<c:forEach items="${test}" var="name">
	<p>${name.name}   <form:button id="${name.id}" path="${name.id}">usun ${name.id}</form:button></p>
	</c:forEach>
</form:form>
<form:form action="${testadd}" modelAttribute="test2" method="post">
	
	<form:input path="name" />
	<form:button id="add-button">add test</form:button>
</form:form>
</body>
</html>