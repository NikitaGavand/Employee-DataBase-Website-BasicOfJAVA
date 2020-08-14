<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/stylesheet.css">
<title>User Generartion</title>


</head>
<body>
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
							href="UserController?action=logout">Logout</a></li>
						<li><a href="AdminController?action=AdminBack">Back</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<div id="content-holder">
		<marquee>
			<h4>Welcome to TECHNOSOFT</h4>
		</marquee>

	</div>
	<br>
	<br>
	<br>
	<center>
		<h1 style="color: red">You have successfully added Employee with
			empid:${empid}</h1>
		<br> <br>

		<div>
			<br>
			<form action="AdminController?action=insertlogin" method="post">
				Generate Username and Password:<br>
				<table>


					<tr>
						<th><label>User Name:</label></th>
						<td><input type="text" name="userName" id="name"
							value="${emp.getLastName()}${emp.getEmpId()}" autofocus required readonly>
					</tr>
					<tr>
						<th><label>Password:</label></th>
						<td><input name="password" type="password"
							placeholder="Password" required /></td>
					</tr>
					<tr>
						<th><label>User Type:</label></th>
						<td><input name="userType" value="Admin" type="radio" />Admin
							<input name="userType" value="Employee" type="radio" required />Employee</td>
					</tr>

				</table>
				<br> <br>
				<center>
					<input
						style="text-decoration: none; background: #FFA07A; border-radius: 5px;"
						type="submit" name="submit" value="SUBMIT" />&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<input
						style="text-decoration: none; background: #FFA07A; border-radius: 5px;"
						type="reset" name="reset" value="RESET" />
				</center>
			</form>

		</div>
	</center>
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
