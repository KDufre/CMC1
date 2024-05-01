<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="cmc.backend.entities.*" import="cmc.backend.*" import="java.util.*"%>
    <%@include file="VerifyLoginAdmin.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Add User</title>
</head>
<style>
body {
    background-color: #555;
    font-family: Arial, sans-serif; /* Added font-family for better readability */
}
table {
  			position: absolute;
  			top: 50%;
  			left: 50%;
  			transform: translate(-50%, -50%);
  			border-style: solid;
  			border: 3px solid #000;
			}
h1 {
			position: absolute;
  			top: 12%;
  			left: 50%;
  			transform: translate(-50%, -50%);
  			color: #87CEEB;
  			}

th {
    border: 1px solid #cccccc;
    padding: 10px; /* Add padding to cells */
    text-align: left;
}

tr:nth-child(odd) {
    background-color: #cccccc;
}

tr:nth-child(even) {
    background-color: #87CEEB;
}

input[type="text"] {
    width: 100%; /* Make text input fields span the entire width */
    text-align: right;
    border: 2px solid black;
}

input[type="submit"], input[type="reset"] {
    padding: 10px 20px; /* Add padding to buttons */
    background-color: #87CEEB; /* Green background color */
    color: white; /* White text color */
    border: none;
    border-radius: 4px;
    cursor: pointer;
    margin-top: 10px; /* Add some space between inputs */
    text-align: right;
    border: 2px solid black;
    
}

input[type="submit"]:hover, input[type="reset"]:hover {
    background-color: #45a049; /* Darker green on hover */
    text-align: right;
    border: 2px solid black;
}
td {
border: 1px solid #dddddd;
    padding: 2px; /* Add padding to cells */
    text-align: center;
    font-weight: bold;
    
}
.Add.jsp {
    color: #800080; /* Dark red-purple color */
}


</style>
<body>
<h1>Create New User! </h1>
<%
AccountController AC = new AccountController();
User u = AC.getUser(request.getParameter("Username"));

%>
<form method="post" action="AdminAddUser_action.jsp" name="AddUser"><br>
<table style="text-align: left; width: 500px; height: 400px;"
border="1" >
<tbody>
<tr>
<td style="vertical-align: center;">First Name<br>
</td>
<td style="vertical-align: center;"><input name="FirstName" ><br>
</td>
</tr>
<tr>
<td style="vertical-align: center;">Last Name<br>
</td>
<td style="vertical-align: center;"><input name="LastName" ><br>
</td>
</tr>
<tr>
<td style="vertical-align: center;">Username<br>
</td>
<td style="vertical-align: center;"><input name="Username" > </td>
</tr>
<tr>
<td style="vertical-align: center;">Password<br>
</td>
<td style="vertical-align: center;"><input name="Password" > </td>
</tr>
<tr>
<td style="vertical-align: center;">Type (U for User: A for Admin))<br>
</td>
<td style="vertical-align: center;"><input name="Type" > </td>
</tr>
<tr>
<td style="vertical-align: center;"><input value="Add"
method = "post" action= "AdminAddUser_action.jsp" name="Add" type="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td style="vertical-align: center;"><input value="Reset"
name="Reset" type="reset"></td>
</tr>
</tbody>
</table>
<br>
</form>
<form method="post" action="ManageUsers.jsp" name="Back">
    <input name="Back" value="Back" type="submit">
    <input name="Back" type="hidden">
	</form>
</body>
</html>