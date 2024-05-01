<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="cmc.backend.entities.*" import="cmc.backend.*" import="java.util.*"%>
<%@include file="VerifyLoginAdmin.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Universities</title>
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
}
td {
border: 1px solid #cccccc;
    padding: 2px; /* Add padding to cells */
    text-align: center;
    font-weight: bold;
    
}

</style>

<body>
</form>
	<form method="post" action="AdminMenu.jsp" name="Back">
    <input name="Back" value="Back To Main Menu" type="submit">
    <input name="Back" type="hidden">
	</form>
	<% 
	String success = request.getParameter("success");
if(success==null){
	
}

else if (success.equals("true")){
	%>
	<p>Deleted Successfully</p>
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

<td style="padding: 15px; " colspan="8" rowspan="1" style="vertical-align: top;"><a
href="AddUniversity.jsp">ADD A UNIVERSITY</a>
</td>

</tr>
<tr>
<td style="vertical-align: top; text-align: center;">Edit
</td>
<td style="vertical-align: top; text-align: center;">School
</td>
<td style="vertical-align: top; text-align: center;">State
</td>
<td style="vertical-align: top; text-align: center;">Students
</td>
<td style="vertical-align: top; text-align: center;">Expenses
</td>
<td style="vertical-align: top; text-align: center;">Delete
</td>
</tr>
<%
UniversityController uController = new UniversityController();
List<University> list = uController.getAllSchools();

for(University uni : list){
	
%>
<tr>
<td style="vertical-align: top;">
<form method="post" action="EditUniversity.jsp" name="Edit">
    <input name="Edit" value="Edit" type="submit">
    <input name="University" value="<%= uni.getSchool() %>" type="hidden">
</form>
</td>
<td style="vertical-align: center;"><%= uni.getSchool() %>
</td>
<td style="vertical-align: center;"><%= uni.getState() %>
</td>
<td style="vertical-align: center;"><%= uni.getNumStudents() %>
</td>
<td style="vertical-align: center;"><%= uni.getExpenses() %>
</td>
<td style="vertical-align: top;">
<form method="post" action="deleteUniversity_action.jsp" name="Delete">
    <input name="Delete" value="Delete" type="submit">
    <input name="School" value="<%= uni.getSchool() %>" type="hidden">
</form>
</td>
</tr>

<%} %>
</tbody>
</table>
</body>
</html>