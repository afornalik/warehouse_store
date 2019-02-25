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
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/shelves.css" />">
 <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<title>Ajka | Location selection</title>
</head>
<body>
<c:forEach items="${shelves}" var="shelve">
		
	<form action="" method="post">
	
	
		<input type="hidden" name="selectedShelve" value="${shelve.key}">
		
		<input type="submit"  value="${shelve.value}">
		
	
	
	

	</form>
		</c:forEach>
		
	<p>
<form action="/warehouse_store/addpalette" method="post" >
	
	
		<c:if  test="${not empty newSelectedShelve}">
		<fieldset  id="axis">
		
			<table class="shelves" >
				
			<c:forEach var="stat" begin="1" end="${newSelectedShelve.getRows()}" >
				<tr class="shelves">
				<td class="verticalRule"></td>
					<c:forEach   var="stat2" begin="1" end="${newSelectedShelve.getColumns()}" >
						
						<td class="paletteHolder"> <%-- ${stat} - ${stat2} --%>
						<c:set value="false" var="oneButton" />
						<c:forEach items="${paletteListOnTheShelf}" var="pal">
							
							<c:choose>
								<c:when test="${pal.getLocX() == stat2 && pal.getLocY() == stat}">
								<div class="thePalette">
								<ul>
								<c:forEach items="${pal.getItems()}" var="items" varStatus="loop"    >
									
								
								 
								 <li> ${items.getIdItemsKind().getName()} </li>
								  	 
								  	
								 </c:forEach>
								 </ul>
								 <input type="submit" value="zmień">
								 <c:set var="oneButton" value="true" />
							</div>
							</c:when>
							<c:otherwise>
								<c:if test="${oneButton == false}">
									<%-- <input type="radio"   ${stat2}"  name="axisX"> --%>
								
									<input type="submit" name="axis"   value="${stat}, ${stat2}, ${pal.getPlace().getId()}">
									<c:set var="oneButton" value="true"  />								
								</c:if>
							</c:otherwise>
							</c:choose>
							
						</c:forEach>
						
						<c:if test="${stat2 % 3 == 0}">
							<td class="verticalRule">
							
							</td>
						</c:if>
						
						</td>
					</c:forEach>
					
				</tr>
			
		</c:forEach>
				
	</table>
	</fieldset>
	
		</c:if>
		
	
	</form>

	
	
</body>
</html>