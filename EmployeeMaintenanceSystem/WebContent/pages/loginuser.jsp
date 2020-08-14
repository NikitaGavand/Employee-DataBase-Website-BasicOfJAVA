<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="css/stylesheet.css">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<meta name="viewport" content="width=device-width, initial-scale=1">

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
						<li class="current_page_item">
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
	<center>
		<c:if test="${msg ne null }">
						${msg}
						</c:if>
	</center>
	<br>
	<br>
	<div style="width: 35%; height: 47.7%;" class="modal-content">
		<div class="modal-header">
			<h4 align="center">Login</h4>
		</div>
		<div>
			<div class="modal-body">

				<div class="form-group">
					<form action="LoginController?action=login" method="post">
						<table align="center">
							<div>
								<tr>
									<th></th>
									<td><input type="text" class="form-control"
										placeholder="Username" name="username" id="username" /></td>
								</tr>
							</div>
							<div>
								<tr>
									<th></th>
									<td><input type="password" class="form-control"
										placeholder="Password" name="pwd" id="password" /></td>
								</tr>
							</div>



							<div class="loginbutton">
								<tr>
									<th></th>
									<td align="center"><input type="submit"
										class="form-button" id="login" value="Login" /></td>
								</tr>

							</div>
						</table>
						<center>
							<c:if test="${loginMsg ne null }">
						${loginMsg}
						</c:if>
						</center>
					</form>
				</div>
			</div>
			<div class="modal-footer">
				<center>
					<h4>Technosoft</h4>
				</center>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<div id="footer">
		<p>Disclaimer |Sitemap | Contact Us |© TECHNOSOFT corporation.
			All rights reserved. Best viewed in 1366x768 resolution and IE 9 and
			above browserCopyright All rights reserved.</p>
	</div>
	<script src="js/script.js" type="text/javascript"></script>


</body>
</html>
