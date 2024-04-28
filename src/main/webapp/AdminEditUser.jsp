<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="cmc.backend.entities.*" import="cmc.backend.*" import="java.util.*"%>
    <%@include file="VerifyLoginAdmin.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Edit User</title>
</head>
<style>
body {
    background-color: #555;
    font-family: Arial, sans-serif; /* Added font-family for better readability */
}

table {
    border-collapse: collapse; /* Collapse table borders for a cleaner look */
    border: 6px solid #000; /* Add a black border */
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
<%
AccountController AC = new AccountController();
User u = AC.getUser(request.getParameter("Username"));

%>
<form method="post" action="AdminEditUser_action.jsp" name="editUser"><br>
<table style="text-align: left; width: 266px; height: 228px;"
border="1" >
<tbody>
<tr>
<td style="vertical-align: center;">First Name<br>
</td>
<td style="vertical-align: center;"><input name="FirstName" value="<%=u.getFirstName()%>"><br>
</td>
</tr>
<tr>
<td style="vertical-align: center;">Last Name<br>
</td>
<td style="vertical-align: center;"><input name="LastName" value="<%=u.getLastName()%>"><br>
</td>
</tr>
<tr>
<td style="vertical-align: center;">Username<br>
</td>
<td style="vertical-align: center;"><input name="Username" value="<%=u.getUsername()%>" readonly> </td>
</tr>
<tr>
<td style="vertical-align: center;">Password<br>
</td>
<td style="vertical-align: center;"><input name="Password" value="<%=u.getPassword()%>"> </td>
</tr>
<tr>
<td style="vertical-align: center;">Type<br>
</td>
<td style="vertical-align: center;"><input name="Type" value="<%=u.getType()%>"> </td>
</tr>
<tr>
<td style="vertical-align: center;">Status<br>(N to Deactivate)<br>
</td>
<td style="vertical-align: center;"><input name="Status" value="<%=u.getActivated()%>"> </td>
</tr>

<tr>
<td style="vertical-align: center;"><input value="Edit"
name="Edit" type="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
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