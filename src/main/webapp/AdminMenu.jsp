<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="VerifyLoginAdmin.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Menu</title>
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
<h1> Welcome back <%= user.getFirstName() %></h1>
<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
<tr align="center">
	<td colspan="8" rowspan="1" style="vertical-align: top;"><a
	href="ManageUsers.jsp">Manage Users</a>
	</td>
</tr>
<tr align="center">
	<td colspan="8" rowspan="1" style="vertical-align: top;"><a
	href="ManageUniversities.jsp">Manage Universities</a>
	</td>
</tr>
<tr align="center">
	<td colspan="8" rowspan="1" style="vertical-align: top;"><a
	href="Logout_action.jsp">Logout</a>
	</td>
</tr>
</body>
</html>