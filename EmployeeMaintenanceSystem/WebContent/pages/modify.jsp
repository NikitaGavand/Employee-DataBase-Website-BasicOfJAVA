<!--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">-->
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
					
						<li class="current_page_item"><a
							href="LoginController?action=logout">Logout</a></li>
						<li><a href="AdminController?action=AdminBack">Back</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<br>
	<div id="content-holder">
		<marquee>
			<h4>Welcome to Technosoft</h4>
		</marquee>


	</div>
	<br>
	<br>
	<br>
	<div></div>


    <h1>Welcome ${loginSession}</h1>
    <br>
    <br>
	<form method="post" action="AdminController?action=updateValues"
		name="modifyEmployee">
		<table>
			<tr>
				<th>Employee ID</th>
				<td><input type="text" name="userId" readonly="readonly"
					value=${requestScope.empId }></td>
			</tr>
			<tr>
				<th><label>Name:</label></th>
				<td><input type="text" name="fName" required
					value=${requestScope.CurrentUser.firstName } /> <input type="text"
					name="lName" value=${requestScope.CurrentUser.lastName } /></td>
			</tr>
			<tr>
				<th>Date of Birth:</th>
				<td><input type="date" name="eDob" required
					value=${requestScope.CurrentUser.empDob } /></td>
			</tr>
			<tr>
				<th><label>Date of Joining:</label></th>
				<td><input type="date" name="eDoj" required
					value=${requestScope.CurrentUser.empDoj } /></td>
			</tr>


			<tr>
				<th><label>Department</label></th>
				<td><select name="DepartmentName" required>
						<option value="${requestScope.currdept}">${requestScope.currdept}</option>
						<c:forEach items="${deptNames}" var="dName">
							<option value="${dName}">${dName}</option>
						</c:forEach>
				</select> <BR></td>
			</tr>
			<tr>
				<th>Grade</th>
				<td><select name="Grade" required>
				<option value="${requestScope.CurrentUser.grade }">${requestScope.CurrentUser.grade }</option>
						<c:forEach items="${grades}" var="gradename">
							<option value="${gradename}">${gradename}</option>
						</c:forEach></select>
					</td>
			</tr>
			<tr>
				<th>Designation</th>
				<td><input type="text" name="design" required
					value=${requestScope.CurrentUser.designation } /></td>
			</tr>
			<tr>
				<th>Gender</th>
				<td><input type="text" name="gender" required
					value=${requestScope.CurrentUser.gender } /></td>
			</tr>
			<tr>
				<th>Basic</th>
				<td><input type="text" name="sal" required
					value=${requestScope.CurrentUser.salary } /></td>
			</tr>
			<tr>
				<th>Marital Status</th>
				<td><input type="text" name="status" required
					value=${requestScope.CurrentUser.maritalStatus } /></td>
			</tr>
			<tr>
				<th>Home address</th>
				<td><input type="text" name="addr" required
					value=${requestScope.CurrentUser.address } /></td>
			</tr>
			<tr>
				<th>Contact</th>
				<td><input type="text" name="number" required maxlength="10"
					value=${requestScope.CurrentUser.contactNo } /></td>
			</tr>


		</table>
		<br> <br>
		<center>
			<input
				style="text-decoration: none; background: #FFA07A; border-radius: 5px;"
				type="submit" name="updateValues" value="Update" />
	</form>
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