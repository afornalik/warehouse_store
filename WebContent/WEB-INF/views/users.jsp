<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
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

	<h1>	Add User </h1>
	
	<c:url var="addAction" value="/users/add" ></c:url>
	
	<form:form action="${addAction}" commandName="user">
	<table>
		<c:if test="${!empty user.firstName}">
			<tr>
				<td>
					<form:label path="id">
						<spring:message text="id" />
					</form:label>
				</td>
				<td>
					<form:input path="id" readonly="true" size="8" disabled="true" />
					<form:hidden path="id" />
				</td>
			</tr>
		</c:if>
		<tr>
			<td>
				<form:label path="firstName" >
					<spring:message text="Name" />
				</form:label>
			</td>
			<td>
				<form:input path="firstName" />
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="lastName" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<c:if test="${!empty user.firstName}">
					<input type="submit" value="<spring:message text="Edit Person"/>" />
				</c:if>
				<c:if test="${empty user.lastName}" >
					<input type="submit" value="<spring:message text="Add Person"/>" /> 
				</c:if>
			</td>
		</tr>
	</table>
	</form:form>
	<h3>Users List</h3>
	<c:if test="${!empty listUser}">
		<table>
		<tr>
			<th> id </th>
			<th>first name </th>
			<th> last name </th>
			<th> date </th>
		</tr>
		<c:forEach items="${listUser}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.dateOfRegistration}</td>
				<td><a href="<c:url value='/edit/${user.id}' />" >Edit</a></td>
				<td><a href="<c:url value='/remove/${user.id}' />" >Remove</a></td>  
			</tr>
		</c:forEach>
		</table>
	</c:if>
				
</body>
</html>