<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Employee</title>
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

	<div></div>
	
	<h1>Welcome ${loginSession}</h1>
	<br>
	<form action="EmployeeController?action=search" method="post">
<div style=" padding: 50px">
<h3> SEARCH</h3>


   
		        <select name="search" required>
	            <option value="default">Search by</option>										   
                <option value="id" name="id">Id</option>
				<option value="fname" name="fname">First Name</option>
				<option value="lname" name="lname">Last Name</option>
				<option value="department" name="department">Department</option>
				<option value="grade" name="grade">Grade</option>
				<option value="status" name="status">Marital Status</option>
				</select>
				<input type="text" name ="srch" required/>
<input type="submit" value ="SEARCH"/>
</div>
</form>

	<div id="content-holder1">
		<center>
			<img src="images\emp4.jpg" height="500" width="500">
		</center>

	</div>
	<div id="footer">
		<p>Disclaimer |Sitemap | Contact Us |© CAPGEMINI corporation. All
			rights reserved. Best viewed in 1366x768 resolution and IE 9 and
			above browserCopyright All rights reserved.</p>
	</div>
	<script src="js/script.js" type="text/javascript"></script>
</body>
</html>