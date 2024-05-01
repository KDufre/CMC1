<%@ page import="cmc.backend.entities.*" import="cmc.backend.*" import="java.util.*"%>
<%@include file="VerifyLoginAdmin.jsp" %>
<html>
<head>
<title></title>
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

.delete-button:hover {
    background-color: #FF6666; /* Light red color */
    color: white; /* Text color */
}

input[type="submit"]:hover, input[type="reset"]:hover {
    background-color: #45a049; /* Darker green on hover */
    text-align: right;
    border: 2px solid black;
}

td {
border: 1px solid #dddddd;
    padding: 8px; /* Add padding to cells */
    text-align: center;
    font-weight: bold;
    font-size: 18px;
    
}

/


</style>
<body>
</form>
	<form method="post" action="AdminMenu.jsp" name="Back">
    <input name="Back" value="Back To Main Menu" type="submit">
    <input name="Back" type="hidden">
	</form>
<table style="text-align: left; width: 100%;" border="1" cellpadding="5"
cellspacing="6">
<tbody>
<tr align="center">

<td style="padding: 15px; " colspan="8" rowspan="1" style="vertical-align: top;"><a
href="AdminAddUser.jsp">ADD A USER</a>

</td>

</tr>
<tr>
<td style="vertical-align: top; text-align: center;">Edit
</td>
<td style="vertical-align: top; text-align: center;">Full name
</td>
<td style="vertical-align: top; text-align: center;">Username
</td>
<td style="vertical-align: top; text-align: center;">Password
</td>
<td style="vertical-align: top; text-align: center;">Type
</td>
<td style="vertical-align: top; text-align: center;">Status
</td>
<td style="vertical-align: top;">Delete
</td>
</tr>

<% 
List<User> allUsers = controller.getAllUsers();


for(User u : allUsers){
	
	
	%>

<tr>
<td style="vertical-align: top;">
<form method="post" action="AdminEditUser.jsp" name="Edit">
    <input name="Edit" value="Edit" type="submit">
    <input name="Username" value="<%= u.getUsername() %>" type="hidden">
</form>
</td>
<td style="vertical-align: center;"><%= u.getFirstName() + " " + u.getLastName() %>
</td>
<td style="vertical-align: center;"><%= u.getUsername() %>
</td>
<td style="vertical-align: center;"><%= u.getPassword() %>
</td>
<td style="vertical-align: center;"><%= u.getType() %>
</td>
<td style="vertical-align: center;"><%= u.getActivated() %>
</td>
<td style="vertical-align: top;">
<form method="post" action="AdminDeleteUser_action.jsp" name="Delete">
    <input name="Delete" value="Delete" type="submit">
    <input name="Username" value="<%= u.getUsername() %>" type="hidden">
</form>
</td>
</tr>
<%} %>
</tbody>
</table>
</body>
</html>

