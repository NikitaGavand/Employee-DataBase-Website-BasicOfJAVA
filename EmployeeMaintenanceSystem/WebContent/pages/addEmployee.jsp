<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Add Employee</title>
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
						<li><a href = "AdminController?action=AdminBack">Back</a></li>
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

	<div>
	<h1>Welcome ${loginSession}</h1>
		<br> <br> <br>
		<form action="AdminController?action=insert" method="post">
			<table>

				<tr>
					<th><label>Name:</label></th>
					<td><input type="text" name="fName" id="name"
						placeholder="First Name" pattern="[a-zA-Z]{2,}"
						title="Enter only alphabets" autofocus required> <input
						type="text" name="lName" id="name" placeholder="Last Name"
						pattern="[a-zA-Z]{2,}" title="Enter only alphabets" autofocus
						required></td>
				</tr>
				<tr>
					<th><label>Date of Birth:</label></th>
					<td><input name="dob" type="date" required /></td>
				</tr>
				
				<tr>
					<th><label>Date of Joining</label></th>
					<td><input name="doj" type="date" required /></td>
				</tr>
				<c:if test="${msg ne null }">
				<tr><td></td>
				<td>
				${msg }</td>
				</tr>
				</c:if>
				<c:if test="${msg1 ne null }">
				<tr><td></td><td>
				${msg1 }</td></tr>
				</c:if>
				<tr>
					<th><label>Department</label></th>
					<td><select required name="DepartmentName">
							<option value="">Select Department</option>
							<c:forEach items="${departmentNames}" var="dName">
								<option value="${dName}">${dName}</option>
							</c:forEach>
					</select> <BR></td>
				</tr>
			
				<tr>
					<th><label>Grade</label></th>
					<td><select name="Grade" id="select" required>
							<option value="default">select grade</option>
							<option value="M1">M1</option>
							<option value="M2">M2</option>
							<option value="M3">M3</option>
							<option value="M4">M4</option>
							<option value="M5">M5</option>
							<option value="M6">M6</option>
							<option value="M7">M7</option>
					</select></td>
				</tr>
				<tr>
					<th><label>Designation:</label></th>
					<td><input type="text" name="designation" id="designation" required
						placeholder="Designation" title="Enter only alphabets" autofocus />
				</tr>

				<tr>
					<th><label>Gender:</label></th>
					<td><input type="radio" name="gender" value="M" id="radio" />Male
						<input type="radio" name="gender" value="F" id="radio" required />Female</td>
				</tr>
				<tr>
					<th><label>Basic:</label></th>
					<td><input type="text" name="basic" id="basic"
						placeholder="Basic" pattern="[0-9]{*}" title="Enter only numbers"
						autofocus required />
				</tr>
			<c:if test="${msg3 ne null }"><tr><td></td><td>
				${msg3 }</td></tr>
				</c:if>
				<tr>
					<th><label>Marital Status:</label></th>
					<td><select name="maritalstatus" id="select" required>
							<option value="default">select status</option>
							<option value="Single">Single</option>
							<option value="Married">Married</option>
							<option value="Divorced">Divorced</option>
							<option value="Separated">Separated</option>
							<option value="Widowed">Widowed</option>

					</select></td>
				</tr>


				<tr>
					<th><label>Home Address:</label></th>
					<td><input type="text" name="address" id="address"
						placeholder="Enter address" pattern="[a-zA-Z0-9]{*}"
						title="Enter only alphabets" required autofocus />
				</tr>

				<tr>
					<th><label>Contact:</label></th>
					<td><input type="text" name="number" placeholder="phone" required
						maxlength="10" pattern="[0-9]{10}" /></td>
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



	<div id="footer">
		<p>Disclaimer |Sitemap | Contact Us |© CAPGEMINI corporation. All
			rights reserved. Best viewed in 1366x768 resolution and IE 9 and
			above browserCopyright All rights reserved.</p>
	</div>
	<script src="js/script.js" type="text/javascript"></script>
</body>
</html>
