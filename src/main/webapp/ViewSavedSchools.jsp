<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="cmc.backend.entities.*" import="cmc.backend.*" import="java.util.*"%>
    <%@include file="VerifyLoginUser.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Saved Schools</title>
</head>
<style>
body {
    background-color: #777;
    font-family: Arial, sans-serif; /* Added font-family for better readability */
}

table {
    border-collapse: collapse; /* Collapse table borders for a cleaner look */
    border: 6px solid #000; /* Add a black border */
}

th {
    border: 1px solid #dddddd;
    padding: 10px; /* Add padding to cells */
    text-align: left;
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
    text-align: center;
    font-weight: bold;
    
}

</style>
<body>
</form>
	<form method="post" action="UserMenu.jsp" name="Back">
    <input name="Back" value="Back To Main Menu" type="submit">
    <input name="Back" type="hidden">
	</form>
<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
<tr>
<td style="vertical-align: top; text-align: center;">Select
</td>
<td style="vertical-align: top; text-align: center;">School
</td>
<td style="vertical-align: top; text-align: center;">Date Saved
</td>
<td style="vertical-align: top; text-align: center;">Remove
</td>
</tr>
<%
SearchController sController = new SearchController();
List<UserSchool> list = sController.getSavedSchools(user.getUsername());
for (UserSchool uni : list){
%>
<tr>
<td style="vertical-align: top;">
<form method="post" action="SelectUniversity.jsp" name="Select">
    <input name="Select" value="Select" type="submit">
    <input name="University" value="<%= uni.getUniversity() %>" type="hidden">
</form>
</td>
<td style="vertical-align: top;"><%= uni.getUniversity() %>
</td>
<td style="vertical-align: top;"><%= uni.getTimestamp() %>
</td>
<td style="vertical-align: top;">
<form method="post" action="RemoveSchool.jsp" name="Remove">
    <input name="Remove" value="Remove" type="submit">
    <input name="University" value="<%= uni.getUniversity() %>" type="hidden">
</form>
</td>
</tr>


<%} %>
</body>
</html>