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
<title>Ajka | dodawanie palety</title>
</head>
<body>
 <h1>Dodawanie palety</h1>
 
 ${axis}
 <ul>
 <c:forEach items="${axis}" var = "onekind">
		<li>${onekind}</li>
</c:forEach>
</ul>
<ul>

 
 </ul>
</body>
</html>