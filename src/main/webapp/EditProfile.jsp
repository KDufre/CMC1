<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="cmc.backend.entities.*" import="cmc.backend.*" import="java.util.*"%>
    <%@include file="VerifyLoginUser.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile</title>
<style>
body {
    background-color: #777;
    font-family: Arial, sans-serif; /* Added font-family for better readability */
}

.container {
    width: 200%; /* Adjust the width of the container */
    margin: 0 auto; /* Center the container horizontally */
    padding: 20px; /* Add some padding for spacing */
    overflow-y: auto; /* Enable vertical scrolling */
    max-height: 500px; /* Set a maximum height for the container */
}

table {
    width: 400%; /* Make the table width 100% of its container */
    border-collapse: collapse; /* Collapse table borders for a cleaner look */
    border: 6px solid #000; /* Add a black border */
position: absolute;
  			top: 50%;
  			left: 50%;
  			transform: translate(-50%, -50%);
  			border-style: solid;
}

th {
    border: 1px solid #dddddd;
    padding: 10px; /* Add padding to cells */
    text-align: left;
}

th {
    font-weight: bold;
}

tr:nth-child(odd) {
    background-color: #dddddd;
}

tr:nth-child(even) {
    background-color: rgb(211, 250, 211);
}

input[type="text"] {
    width: 100%; /* Make text input fields span the entire width */
    text-align: right;
}

input[type="submit"], input[type="reset"] {
    padding: 10px 20px; /* Add padding to buttons */
    background-color: #4CAF50; /* Green background color */
    color: white; /* White text color */
    border: none;
    border-radius: 4px;
    cursor: pointer;
    margin-top: 10px; /* Add some space between inputs */
    text-align: right;
    
}

input[type="submit"]:hover, input[type="reset"]:hover {
    background-color: #45a049; /* Darker green on hover */
    text-align: right;
}
td {
border: 1px solid #dddddd;
    padding: 2px; /* Add padding to cells */
    text-align: right;
}
</style>
</head>
<body>
<form method="post" action="Edit_Action.jsp" name="editUser"><br>
<table style="text-align: left; width: 266px; height: 228px;"
border="1" >
<tbody>
<tr>
<td style="vertical-align: center;">First Name<br>
</td>
<td style="vertical-align: center;"><input name="FirstName" value="<%=user.getFirstName()%>"><br>
</td>
</tr>
<tr>
<td style="vertical-align: center;">Last Name<br>
</td>
<td style="vertical-align: center;"><input name="LastName" value="<%=user.getLastName()%>"><br>
</td>
</tr>
<tr>
<td style="vertical-align: center;">Username<br>
</td>
<td style="vertical-align: center;"><input name="Username" value="<%=user.getUsername()%>" readonly> </td>
</tr>
<tr>
<td style="vertical-align: center;">Password<br>
</td>
<td style="vertical-align: center;"><input name="Password" value="<%=user.getPassword()%>"> </td>
</tr>
<tr>
<td style="vertical-align: center;">Type<br>
</td>
<td style="vertical-align: center;"><input name="Type" value="<%=user.getType()%>" readonly> </td>
</tr>
<tr>
<td style="vertical-align: center;">Status<br>
</td>
<td style="vertical-align: center;"><input name="Status" value="<%=user.getActivated()%>"> </td>
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
<form method="post" action="UserMenu.jsp" name="Back">
    <input name="Back" value="Back To Main Menu" type="submit">
    <input name="Back" type="hidden">
	</form>
</body>
</html>