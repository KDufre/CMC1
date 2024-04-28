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
			background-color: #555;
		}
		h1 {
			position: absolute;
  			top: 10%;
  			left: 50%;
  			transform: translate(-50%, -50%);
  			color: rgb(255, 51, 51);
  			font-weight: 800;
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
  			background-color: #cccccc;
  			text-align: center;
			}
		tr:nth-child(even) {
  			background-color: rgb(255, 51, 51)
;
  			text-align: center;
			}
</style>
</head>
<body>
<h1> Welcome back <%= user.getFirstName() %></h1>
<% 

String success = request.getParameter("success");
if(success==null){
	
}

else if (success.equals("true")){
	%>
	<p>Edit Successful</p>
	<% 
}
else if (success.equals("false")){
	%>
	<p>Edit Failed - Invalid Input</p>
	<% 
}
%>
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