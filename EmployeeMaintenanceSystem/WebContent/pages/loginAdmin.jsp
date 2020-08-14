<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>Login Admin</title>
<link rel="stylesheet" href="css/stylesheet.css">
</head>
<body>

<div id="MyModal" class="modal">
		<div class="modal-content">
			<div class="modal-header">
			 <span class="close">X</span>
				<h4 align="center">Login</h4> 
			</div>
		
				
			
		</div>
	</div>  
	<div id="wrapper">
		<div id="header-wrapper">
			<div id="header" class="container">

				<div id="logo">

					<h1>
						<a href="#">TECHNOSOFT</a>
					</h1>

				</div>
				<div id="menu">
					<ul>
						<li class="current_page_item"><a
							href="LoginController?action=logout">Logout</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<div id="content-holder">
		<marquee>
			<h4>Welcome to Technosoft</h4>
		</marquee>

	</div>
   <h1>Welcome ${loginSession}</h1>
	<br>
	<br>
	<br>
	<div>
		<h3>Choose Operation:</h3>
		<table cellpadding="50" align="center">
			<tr>
				<td><a href="AdminController?action=add">ADD EMPLOYEE</a></td>

				<td><a href="AdminController?action=modify">MODIFY EMPLOYEE</a></td>
				<td><a href="AdminController?action=view">VIEW EMPLOYEE</a></td>
			</tr>
		</table>



	</div>

<br>
<br>
<div align="center">
	
			<img src="images/image.jpg"
				style="width: 70%; height: 70%"> 
		
	</div>
	
	<br>
	<br>
	<div id="footer">
		<p>Disclaimer |Sitemap | Contact Us |© CAPGEMINI corporation. All
			rights reserved. Best viewed in 1366x768 resolution and IE 9 and
			above browserCopyright All rights reserved.</p>
	</div>
	<script src="js/script.js" type="text/javascript"></script>
</body>
</html>

