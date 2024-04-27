<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ page import="cmc.backend.entities.*" import="cmc.backend.*" import="java.util.*"%>
    <%@include file="VerifyLoginUser.jsp" %>
    
<!DOCTYPE html>
<html>
<%
SearchController searchC = new SearchController();
UniversityController uniC = new UniversityController();
University uniSelected = uniC.getSchool(request.getParameter("School"));
List<University> list = searchC.getFiveSimilarSchools(uniSelected);

%>
<head>
<meta charset="UTF-8">
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
form {
style="vertical-align: center;
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
<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
<tr>
<td style="vertical-align: top; text-align: center;">University
</td>
<td style="vertical-align: top; text-align: center;">State
</td>
<td style="vertical-align: top; text-align: center;">Students
</td>
<td style="vertical-align: top; text-align: center;">Expenses
</td>
<td style="vertical-align: top; text-align: center;">5 Similar
</td>
<td style="vertical-align: top;">Add
</td>
</tr>
	
	<%
	for(University uni : list){
		
	
	%>
	
<tr>
<td style="vertical-align: center;"><%= uni.getSchool()%>
</td>
<td style="vertical-align: center;"><%= uni.getState()%>
</td>
<td style="vertical-align: center;"><%= uni.getNumStudents()%>
</td>	
<td style="vertical-align: center;"><%= uni.getExpenses()%>
</td>

<td style="vertical-align: center;">
<form method="post" action="FiveSimilarSchool.jsp" name="Similar">
    <input name="Similar" value="Similar" type="submit">
    <input name="School" value="<%= uni.getSchool() %>" type="hidden">
</form>
</td>
<td style="vertical-align: center;">
<form method="post" action="SaveSchool_action.jsp" name="Add">
    <input name="Add" value="Add" type="submit">
    <input name="School" value="<%= uni.getSchool() %>" type="hidden">
</form>
</td>
	<%} %>
</body>
<form method="post" action="UserMenu.jsp" name="Back">
    <input name="Back" value="Back To Main Menu" type="submit">
    <input name="Back" type="hidden">
	</form>
</html>