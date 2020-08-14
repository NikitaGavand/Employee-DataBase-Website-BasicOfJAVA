<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee View</title>

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
						<li><a href="EmployeeController?action=Empback">Back</a></li>
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
    <h1>Welcome ${loginSession}</h1>
    <br><br>
	<center>
		<div>
		
			<table style="padding: 50px" border="1">
				<tr>
					<th colspan="6">Employee Details</th>
				</tr>


				<tr>
					<th>Employee Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Department</th>
					<th>Grade</th>
					<th>Designation</th>
				</tr>

				<c:forEach items="${empList}" var="list">
					<tr>
						<td>${list.empId}</td>
						<td>${list.firstName}</td>
						<td>${list.lastName}</td>
						<td>${list.deptId}</td>
						<td>${list.grade}</td>
						<td>${list.designation}</td>
					</tr>
				</c:forEach>
				</br>
			</table>


		</div>
	</center>





	<div id="footer">
		<p>Disclaimer |Sitemap | Contact Us |© TECHNOSOFT corporation.
			All rights reserved. Best viewed in 1366x768 resolution and IE 9 and
			above browserCopyright All rights reserved.</p>
	</div>
	<script src="js/script.js" type="text/javascript"></script>


</body>
</html>

