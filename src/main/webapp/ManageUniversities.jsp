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
<body>

<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
<tr align="center">

<td colspan="8" rowspan="1" style="vertical-align: top;"><a
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
<td style="vertical-align: top;"><%= uni.getSchool() %>
</td>
<td style="vertical-align: top;"><%= uni.getState() %>
</td>
<td style="vertical-align: top;"><%= uni.getNumStudents() %>
</td>
<td style="vertical-align: top;"><%= uni.getExpenses() %>
</td>
<td style="vertical-align: top;">
<form method="post" action="Delete.jsp" name="Delete">
    <input name="Delete" value="Delete" type="submit">
    <input name="Username" value="<%= uni.getSchool() %>" type="hidden">
</form>
</td>
</tr>

<%} %>
</tbody>
</table>
</body>
</html>