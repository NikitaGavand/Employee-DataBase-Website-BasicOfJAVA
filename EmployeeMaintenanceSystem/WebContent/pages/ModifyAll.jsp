<html>
<head>
<meta charset="ISO-8859-1">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>Modify All</title>

<style>
table, th, td {
	margin-left: auto;
	margin-right: auto;
	border: 1px solid #FFA07A;
}

th, td {
	text-align: left;
	height: 30px;
	padding: 15px;
}
</style>
<link rel="stylesheet" href="css/stylesheet.css">
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
							href="LoginController?action=logout">Logout</a></li>
						<li><a href="AdminController?action=AdminBack">Back</a></li>
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
	<br>
	<br>
	<div></div>
	
	<h1>Welcome ${loginSession}</h1>
<body>

	<table>
		<tr>
			<th>Employee Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Department</th>
			<th>Grade</th>
			<th>Designation</th>
			<center>
				<th colspan="2">Modify</th>
			</center>
		</tr>

		<c:forEach items="${listEmp}" var="list">
			<tr>
				<td>${list.empId}</td>
				<td>${list.firstName}</td>
				<td>${list.lastName}</td>
				<td>${list.deptId}</td>
				<td>${list.grade}</td>
				<td>${list.designation}</td>
				<td><a
					href="AdminController?action=update&userId=${list.empId }">Update</a></td>
				<td><a
					href="AdminController?action=delete&userId=${list.empId }">Delete</a></td>

			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
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

