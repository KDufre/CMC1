<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cmc.backend.entities.*" import="cmc.backend.*" 
    import="java.util.*"%>
    <%@include file="VerifyLoginUser.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Menu</title>
<style>
		body{
			background-color: #777;
		}
		h1 {
			position: absolute;
  			top: 10%;
  			left: 50%;
  			transform: translate(-50%, -50%);
  			color: lightgreen;
		}
		table {
  			position: absolute;
  			top: 50%;
  			left: 50%;
  			transform: translate(-50%, -50%);
  			border-style: solid;
  			border: 3px solid #000;
			}

		td	{
  			border: 1px solid #dddddd;
  			text-align: center;
  			padding: 16px;
			}
		th {
			border-width: 4px;
			font-weight: bold;
			
			}

		tr:nth-child(odd) {
  			background-color: #dddddd;
  			text-align: center;
			}
		tr:nth-child(even) {
  			background-color: rgb(211, 250, 211);
  			text-align: center;
			}
</style>
</head>
<body>
<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
<h1>Welcome back <%= "loggedInUser" %></h1>
<tr align="center">
	<td colspan="8" rowspan="1" style="vertical-align: top;"><a
	href="Search.jsp">Search</a>
	</td>
</tr>
<tr align="center">
	<td colspan="8" rowspan="1" style="vertical-align: top;"><a
	href="ViewSavedSchools.jsp">View Saved Schools</a>
	</td>
</tr>
<tr align="center">
	<td colspan="8" rowspan="1" style="vertical-align: top;"><a
	href="EditUser.jsp">Edit Profile</a>
	</td>
</tr>
<tr align="center">
	<td colspan="8" rowspan="1" style="vertical-align: top;"><a
	href="Logout_action.jsp">Logout</a>
	</td>
</tr>
</body>
</html>