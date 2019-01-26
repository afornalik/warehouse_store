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
		<c:forEach items="${paletteListOnTheShelf}" var="shel">
			${shel}
		</c:forEach>
	<p>
		<c:if  test="${not empty newSelectedShelve}">
			<table class="shelves" >
			<c:forEach var="stat" begin="1" end="${newSelectedShelve.getRows()}" >
				<tr class="shelves">
				<td class="verticalRule"></td>
					<c:forEach   var="stat2" begin="1" end="${newSelectedShelve.getColumns()}" >
						
						<td class="paletteHolder"> <%-- ${stat} - ${stat2} --%>
						<c:forEach items="${paletteListOnTheShelf}" var="pal">
							<c:if test="${pal.getLocX() == stat2 && pal.getLocY() == stat}">
							
								<c:forEach items="${pal.getItemsKind()}" var="items" varStatus="loop"    >
									<div class="thePalette">
								  ${items.getName()} 
								  	</div>
								  	
								 </c:forEach>
							
							</c:if>
						</c:forEach>
						<c:if test="${stat2 % 3 == 0}">
							<td class="verticalRule"></td>
						</c:if>
						</td>
					</c:forEach>
					
				</tr>
				
		</c:forEach>
	</table>
		</c:if>
	</p>
	
	
</body>
</html>