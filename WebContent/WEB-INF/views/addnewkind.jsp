<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dodawanie rodzaju | Ajka</title>
</head>
<body>
 <h1> Dodawanie rodzaju</h1>
 
 <p>	Dodasz tutaj nowy rodzaj towaru, króry następnie będzie dostępny w oknie pokazującym schemat magazyny</p>
 
 <form:form modelAttribute="addNewKind" method="POST">
 	<div>
 		<form:label path="indexCode" >nr katalogowy :</form:label>
 		<form:input path="indexCode" ></form:input>
 	</div>
 	<div>
 		<form:label path="name" >nazwa :</form:label>
 		<form:input path="name"/>
 	</div>
 	<div>
 		<form:label path="family"  >rodzina przedmiotów (opcjonalnie) :</form:label>
 		<form:input path="family" />
 	</div>
 
 	
 	<input type="submit" value="dodaj rodzaj">
 </form:form>
 
${addNewKind}
<br>
<br>
<c:if test="${not empty itemsKindFullList}">
	<c:forEach items="${itemsKindFullList}" var="fullList">
			<p>${fullList.getName()}</p>
	</c:forEach>
</c:if>
</body>
</html>