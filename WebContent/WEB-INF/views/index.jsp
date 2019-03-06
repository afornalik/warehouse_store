
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">

<meta charset="UTF-8">
<title>Ajka Database</title>
</head>
	
<body>
	<div class="base1" >
		<div class="header" >
			<div class="div_logo">
			
			<img id="header_logo" alt="Ajka logo" src="<c:url value="/resources/graphics/ajka-logo.png" />" >
			</div>
		</div>
		<div class="navbar">
			<ul class="menubar">
				<li ><a class="menulink" href="/warehouse_store/shelves">przeglądaj towar</a></li>
				<li ><a class="menulink" href="/warehouse_store/addnewkind">dodaj produkt</a></li>
				<li ><a class="menulink" href="/warehouse_store/users" >użytkownicy</a></li>
				<li ><a class="menulink" href="">zmiany </a></li>
				<li ><a class="menulink" href="">schemat</a></li>
			</ul>
		</div>
		<div class="content">
			jakaś zawartość
		</div>
		<div class="footer">
			<p>Copyright by AF</p>
		</div>
		
	</div>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>

	<script type="text/javascript">

	    function OpenPage(url)

	    {

	        $.get(url, function(response)

	        {

	            $('/users').html(response);

	        });

	    }

	</script>
	
</body>
</html>