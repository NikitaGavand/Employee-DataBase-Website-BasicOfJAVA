<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>About Technosoft</title>
</head>

<style>
.form-button
		{
				border:none;
				color:white;
				padding:10px 20px;
				text-align: center;
				text-decoration:none;
				display: inline-block;
				font-size: 16px;
				margin: 10px 10px;
				cursor: pointer;
				border-radius:8px;
				background-color:	#FF0000;
				
		}
		
			.form-button:hover
			{
				background-color:#3e8e41;
			}
			
			/* The Modal (background) */
			
		.modal {
			display:none;/* Hidden by default */
			position: fixed; /* Stay in place */
			z-index:1; /* Sit on top */
			padding-top: 200px; /* Location of the box*/
			left: 0;
			top: 0;
			width:100%; /* Full width*/
			height: 100%; /*Full height*/
			overflow:auto;/*Enable scroll if needed*/
			background-color:rgb(0,0,0);/*Fallback color*/
			background-color:rgba(0,0,0,0.5);/* Black w/opacity */
			}
			
			/*Modal Content*/
			.modal-content{
			position: relative;
			background-color:#FFF8DC;
			margin:auto;
			padding:0;
			border:1px solid #888;
			width:35%;
			height:50%;
			box-shadow:0 4px 8px 0 rgba(0,0,0,0.2),0 50px 50px 0 rgba (0,0,0,0.19);
			-webkit-animation-name:animatetop;
			-webkit-animation-duration:0.4s;
			animation-name:animateleft;
			animation-duration:20s;
			}
			
			/* Add Animation*/
			@-webkit-keyframes animatetop{
			from {top:-300px; opacity:0}
			to {top:0; opacity:1}
			}
			
			@keyframes animatetop{
			from{top:-300px;opacity:0}
			to {top:0; opacity:1}
			}
			/*The Close Button
			.close{
				color: white;
				float:right;
				font-size:28px;
				font-weight:bold;
				}
				.close:hover,
				.close:focus{
				color:#000;
				text-decoration:none;
				cursor:pointer;
				}*/
				
				
				.modal-header{
				padding:2px 16px;
				background-color:#FFA07A;
				color:black;
				}
				.modal-footer{
				padding:2px 16px;
				background-color:#FFA07A;
				color:black;
				}
				
				
				.close
				{
				background: #606061;
				color: #FFFFFF;
				line-height:25px;
				position:absolute;
				right: -12px;
				text-align:center;
				top: -10px;
				width:24px;
				text-decoration:none;
				
				font-weight:bold;
				-webkit-border-radius:12px;
				-moz-border-radius:12px;
				border-radius:12px;
				-moz-box-shadow:1px 1px 3px #000;
				-webkit-box-shadow:1px 1px 3px #000
				box-shadow:1px 1px 3px #000;
				}
				
				.close:hover{
				background:red;
				}
				
				.modal-body{padding: 10px 16px;}
				
				
				
				.form-control{
				width:200px;
				height:30px;
				padding-right:30px;
				padding-left:60px;
				margin-left:38px;
				}
				
				::-webkit-input-placeholder{
				
				text-transform:uppercase;
				letter-spacing:2px;
				
				}

/*
Design by TEMPLATED
http://templated.co
Released for free under the Creative Commons Attribution License
*/

body {
	margin: 0;
	padding: 0;
	background-color:	#FFF8DC	;
	font-family: 'Abel', sans-serif;
	font-size: 18px;
	color: #5B5B5B;
}

h1, h2, h3 {
	margin: 0;
	padding: 0;
	text-transform: uppercase;
	font-weight: normal;
	font-family: 'Oswald', sans-serif;
	font-weight: 200;
	color: #CFCFCF;
}

h1 {
	font-size: 2em;
}

h2 {
	font-size: 2.8em;
}

h3 {
	font-size: 1.6em;
}

p, ul, ol {
	margin-top: 0;
	line-height: 180%;
}

ul, ol {
}

a {
	color: #5E5E5E;
}

a:hover {
}

#wrapper {
	overflow: hidden;
	padding: 0px 0px 30px 0px;
	background-color:	#FFF8DC	;
	height:100px;
}

.container {
	width: 1000px;
	margin: 0px auto;
}

/* Header */

#header-wrapper {
	overflow: hidden;
	height: 600px;
}

#header {
	overflow: hidden;
	width: 1000px;
	height: 150px;
	margin: 0 auto;
	padding: 0px 0px;
}

/* Logo */

#logo {
	float: left;
	width: 300px;
	margin: 0 px;
	padding: 0;
	color: #FFFFFF;
}

#logo h1, #logo p {
}

#logo h1 {
    text-align:center;
	line-height: 120px;
	letter-spacing: -1px;
	font-size: 2em;
}

#logo h1 a {
	color: #908F8F;
	text-transform: uppercase;
}

#logo p {
	margin: 0;
	padding: 0px 0 0 0px;
	letter-spacing: -1px;
	font: normal 18px Georgia, "Times New Roman", Times, serif;
	font-style: italic;
	color: #8E8E8E;
}

/* Splash */

#splash {
	width: 960px;
	height: 300px;
	margin: 0px auto;
}

/* Search */

#search {
	float: right;
	width: 280px;
	height: 60px;
	padding: 20px 0px 0px 0px;
}

#search form {
	height: 41px;
	margin: 0;
	padding: 10px 0 0 20px;
}

#search fieldset {
	margin: 0;
	padding: 0;
	border: none;
}

#search-text {
	width: 170px;
	padding: 6px 5px 2px 5px;
	border: 1px solid #E7EBED;
	background: #FFFFFF;
	text-transform: lowercase;
	font: normal 11px Arial, Helvetica, sans-serif;
	color: #5D781D;
}

#search-submit {
	width: 50px;
	height: 22px;
	border: none;
	background: #B9B9B9;
	color: #000000;
}

/* Menu */

/* Menu */

#menu {
	float: right;
	width: 550px;
	height: 90px;
	margin: 0 auto;
	padding: 0;
}

#menu ul {
	float: right;
	margin: 0;
	padding: 50px 0px 0px 0px;
	list-style: none;
	line-height: normal;
}

#menu li {
	float: left;
	padding: 0px 0px 0px 0px;
}

#menu a {
	display: block;
	margin-right: 0px;
	padding: 10px 20px 10px 20px;
	text-decoration: none;
	text-align: center;
	text-transform: uppercase;
	font-family: 'Oswald', sans-serif;
	font-size: 14px;
	font-weight: 300;
	color: #585858;
	border: none;
}

#menu a:hover, #menu .current_page_item a {
	text-decoration: none;
	color:	#FFA07A	;
}

#menu .current_page_item a {
	background:#FFA07A;
	border-radius: 5px;
}

<!--#menu {
	float: right;
	width: 500px;
	height: 90px;
	margin: 0 auto;
	padding: 0;
}

#menu ul {
	float: right;
	margin: 0;
	padding: 50px 0px 0px 0px;
	list-style: none;
	line-height: normal;
}

#menu li {
	float: left;
	padding: 0px 0px 0px 0px;
}

#menu a {
	display: block;
	margin-right: 1px;
	padding: 10px 20px 10px 20px;
	text-decoration: none;
	text-align: center;
	text-transform: uppercase;
	font-family: 'Oswald', sans-serif;
	font-size: 14px;
	font-weight: 300;
	color: #585858;
	border: none;
}

#menu a:hover, #menu .current_page_item a {
	text-decoration: none;
	color: #FFFFFF;
}

#menu .current_page_item a {
	background: #EE5058;
	border-radius: 5px;
}-->
/*marquee*/
#content-holder
{
hegiht:900px;
width:1007px;
background-color:	#FFA07A	;
}
/* Page */

#page {
	width: 1000px;
	margin: 0 auto;
	padding: 0px 0px 30px 0px;
}

/* Content */

#content {
	float: left;
	width: 660px;
	padding: 0px 0px 0px 0px;
}

.post {
	overflow: hidden;
	background: #000000;
	border-radius: 15px;
	padding: 30px;
}

.post .title {
	padding: 7px 0px 0px 0px;
	letter-spacing: -1px;
}

.post .title a {
	border: none;
	text-decoration: none;
	color: #CFCFCF;
}

.post .meta {
	margin-bottom: 30px;
	padding: 10px 0px 0px 0px;
	text-align: left;
	font-family: 'Abel', sans-serif;
	font-size: 16px;
	font-weight: 300;
}

.post .meta .date {
	float: left;
}

.post .meta .posted {
	float: right;
}

.post .meta a {
}

.post .entry {
	padding: 0px 0px 40px 0px;
	text-align: justify;
}

.links {
	padding-top: 20px;
	margin-bottom: 30px;
}

.more {
	display: block;
	float: left;
	width: 88px;
	padding: 5px 5px;
	margin-right: 10px;
	background: #132434;
	border-radius: 5px;
	color: #FFFFFF;
	text-align: center;
	text-decoration: none;
}

.comments {
	display: block;
	float: left;
	width: 88px;
	padding: 5px 5px;
	background: #132434;
	border-radius: 5px;
	color: #FFFFFF;
	text-align: center;
	text-decoration: none;
}

/* Sidebar */

#sidebar {
	float: right;
	width: 270px;
	margin: 0px;
	padding: 30px 0px 0px 0px;
}

#sidebar ul {
	margin: 0;
	padding: 0;
	list-style: none;
}

#sidebar li {
	margin: 0;
	padding: 0;
}

#sidebar li ul {
	margin: 0px 0px;
	padding-bottom: 30px;
}

#sidebar li li {
	line-height: 40px;
	border-bottom: 1px solid #E7EBED;
	margin: 0px 0px;
	border-left: none;
}

#sidebar li li span {
	display: block;
	margin-top: -20px;
	padding: 0;
	font-size: 11px;
	font-style: italic;
}

#sidebar li li a {
	padding: 0px 0px 0px 20px;
	background: url(images/img04.jpg) no-repeat left 50%;
}

#sidebar h2 {
	height: 38px;
	padding: 0px 0px 30px 0px;
	letter-spacing: -.5px;
	font-size: 1.8em;
	color: #222222;
}

#sidebar p {
	margin: 0 0px;
	padding: 0px 30px 20px 30px;
	text-align: justify;
}

#sidebar a {
	border: none;
}

#sidebar a:hover {
	text-decoration: underline;
}

<!--/* Calendar */

#calendar {
}

#calendar_wrap {
	padding: 20px;
}

#calendar table {
	width: 100%;
}

#calendar tbody td {
	text-align: center;
}

#calendar #next {
	text-align: right;
}

<!--/* Three Column Footer Content */

#footer-content-wrapper {
}

#footer-content {
	overflow: hidden;
	width: 1000px;
	margin: 0px auto;
	padding: 50px 0px;
	color: #FFFFFF;
}

#footer-content h2 {
	color: #FFFFFF;
}

#footer-content a {
}

#footer-bg {
	overflow: hidden;
	padding: 30px 0px;
	background: #E8E8E8;
}

#footer-content h2 {
	margin: 0px;
	padding: 0px 0px 20px 0px;
	font-size: 26px;
	color: #FFFFFF;
}

#footer-content #fbox1 {
	float: left;
	width: 300px;
	margin-right: 50px;
}

#footer-content #fbox2 {
	float: left;
	width: 300px;
}

#footer-content #fbox3 {
	float: right;
	width: 300px;
}

#footer-content a {
}
-->
#column1 {
	float: left;
	width: 290px;
	margin-right: 30px;
}

#column2 {
	float: left;
	width: 280px;
}

#column3 {
	float: right;
	width: 260px;
}

/* Footer */

#footer {
	height: 140px;
	margin: 0 auto;
	padding: 50px 0 15px 0;
	font-family: 'Abel', sans-serif;
	border: 1px solid #171717;
}

#footer p {
	margin: 0;
	padding-top: 10px;
	letter-spacing: 1px;
	line-height: normal;
	font-size: 14px;
	text-transform: uppercase;
	text-align: center;
	color:red;
}

<!--#footer a {
	color: #2A2A2A;
}-->

<!--#banner {
	margin: 0px auto;
	width: 1000px;
	height: 440px;
	background: url(images/img03.png) no-repeat left bottom;
}

#banner .content img {
	background: #000000;
	border-radius: 15px;
}-->

.list-style1 {
	margin: 0px;
	padding: 0px;
	list-style: none;
}

.list-style1 a {
	color: #7F7F7F;
}

/** LIST STYLE 1 */

ul.style1 {
	margin: 0px;
	padding: 0px 0px 0px 0px;
	list-style: none;
}

ul.style1 li {
	padding: 10px 0px 10px 0px;
	border-top: 1px solid #171717;
	line-height: 160%;
}

ul.style1 a {
	display: block;
	padding: 0px 0px 0px 0px;
	text-decoration: none;
	color: #585858;
}

ul.style1 a:hover {
	text-decoration: underline;
}

ul.style1 .first {
	border-top: none;
	padding-top: 0px;
}

#featured-content {
	overflow: hidden;
	width: 1000px;
	margin: 0px auto;
	padding: 30px 0px;
}

#featured-content h2 {
	padding: 0px 0px 20px 0px;
	font-size: 30px;
}

#featured-content #column1 {
	float: left;
	width: 300px;
	margin-right: 50px;
}

#featured-content #column2 {
	float: left;
	width: 300px;
}

#featured-content #column3 {
	float: right;
	width: 300px;
}

#featured-content img {
	background: #000000;
	border-radius: 15px;
}


.button a {
	display: block;
	float: left;
	width: 88px;
	padding: 5px 5px;
	margin-right: 10px;
	
	border-radius: 5px;
	color: 	#FF0000;
	text-align: center;
	text-decoration: none;
}
#content-holder1
{
background-color:white;
height:500;
}
</style>
<body>

<div id="wrapper">
	<div id="header-wrapper">
		<div id="header" class="container">
	        
			<div id="logo">
			    
				<h1><a href="#">TECHNOSOFT</a></h1>
				
			</div>
			<div id="menu">
				<ul>
					<li class="current_page_item"><a href="index.jsp">Homepage</a></li>
					<li><a href="LoginController?action=loginuser" id="myBtn">Login</a></li>
					<li><a href="AdminController?action=about">About Us</a></li>
				</ul>
			</div>
			
		</div>
		<!--<div id="banner">
			<div class="content">

			</div>
		</div>-->
	</div>
</div>
<!--<div class="loginbutton">
						<tr>
							<th></th>
							<td style="padding-left:15px;padding-right:25px;"> <input type = "submit" class="form-button" id="login" value="Login"/><a href = "AdminController?action=">Forgot Password? </a>
							</td>
						</tr>
					</div>-->
<div id="content-holder">
		<center><h1><label style="color: lavenderblush"></label>Contact Us</h1></center>	
</div>

<br><br>
<h3 style="margin-left:40px;margin-right:40px;color: lightsalmon;">Got a Question.We are here to help you.</h3>
<br>
<p style="font-size:10;float:left;margin-left:40px;margin-right:20px;">
Contact information for Technosoft companies in India and worldwide
<br><br>

<b>Representative offices worldwide</b>
<br>
<br>

<b>Technosoft Sons, USA</b><br>
28411 Northwestern Hwy
Suite 640<br>
Southfield, MI 48034<br>
<b>Tel:</b> (248) 603-2600<br>
<b>Fax:</b> (248) 603-2599<br>
<b>Email:</b> USA@technosoft.com <br>
<b>Website:</b> www.usa.technosoft.com<br>

Directions:<a href="https://www.google.co.in/maps/place/28411+Northwestern+Hwy+%23640,+Southfield,+MI+48034,+USA/@42.4956974,-83.3006846,17z/data=!3m1!4b1!4m5!3m4!1s0x8824b7747404b80f:0x59976b63e1373f2a!8m2!3d42.4956974!4d-83.2984959">View Map</a>
<br><br>
<b>Technosoft Sons,Minneapolis </b><br>
901 Marquette Avenue
Suite 1500<br>
Minneapolis, MN 55402<br>
<b>Tel:</b> (703) 243 9787<br>
<b>Fax:</b> (703) 243 9791<br>
<b>Email:</b> USA@technosoft.com <br>
<b>Website:</b> www.usa.technosoft.com<br>
Directions:<a href="https://www.google.co.in/maps/place/901+S+Marquette+Ave+%231500,+Minneapolis,+MN+55402,+USA/@44.9739627,-93.2745807,17z/data=!3m1!4b1!4m5!3m4!1s0x52b33297a418266b:0x57b69581e9294d79!8m2!3d44.9739627!4d-93.272392">View Map</a>
</p>
</body>
</html>