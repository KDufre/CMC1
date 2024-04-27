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
<td style="vertical-align: top;"><%= uni.getSchool()%>
</td>
<td style="vertical-align: top;"><%= uni.getState()%>
</td>
<td style="vertical-align: top;"><%= uni.getNumStudents()%>
</td>	
<td style="vertical-align: top;"><%= uni.getExpenses()%>
</td>

<td style="vertical-align: top;">
<form method="post" action="FiveSimilarSchool.jsp" name="Similar">
    <input name="Similar" value="Similar" type="submit">
    <input name="School" value="<%= uni.getSchool() %>" type="hidden">
</form>
</td>
<td style="vertical-align: top;">
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