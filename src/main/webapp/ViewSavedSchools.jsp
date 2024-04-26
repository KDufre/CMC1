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
<td style="vertical-align: top; text-align: center;">Data Saved
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