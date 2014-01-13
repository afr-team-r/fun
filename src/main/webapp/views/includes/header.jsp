<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<script src="http://cdn.alloyui.com/2.0.0/aui/aui-min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/page.js"></script>
		<link href="http://cdn.alloyui.com/2.0.0/aui-css/css/bootstrap.min.css" rel="stylesheet"></link>
		<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet"></link>
	</head>

	<body background="${pageContext.request.contextPath}/resources/images/background.jpg">
	
	<div class="title centerText">
		Fun!
	</div>
	
	<div class="separator center"></div>
	
	<div class="menu">
		<table width="50%" border=0 align=center>
		
			<tr align=center>
				<td class="menuItem"><a href="${pageContext.request.contextPath}">Home</a></td>
				<td class="menuItem"><a href="${pageContext.request.contextPath}/upload">Upload</a></td>
				<td class="menuItem"><a href="${pageContext.request.contextPath}/login">Login</a></td>
				<td class="menuItem">Sobre</td>
			</tr>
		
		</table>
	</div>
	
	<div class="separator center" style="top: 12%;"></div>