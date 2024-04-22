<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="cmc.backend.entities.*" import="cmc.backend.*" import="java.util.*"%>
<html>
<head>
<title></title>
</head>
<body>
<% 
AccountController ui = new AccountController();
User user =ui.getUser((String)session.getAttribute("loggedInUser"));
%>

Hello <%= user.getFirstName() %>
<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
<tr align="center">

<td colspan="8" rowspan="1" style="vertical-align: top;"><a
href="Add.jsp">ADD A USER</a>
</td>

</tr>
<tr>
<td style="vertical-align: top;">
Edit</td>
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
List<User> allUsers = ui.getAllUsers();


for(User u : allUsers){
	
	
	%>

<tr>
<td style="vertical-align: top;">
<form method="post" action="Edit.jsp" name="Edit">
    <input name="Edit" value="Edit" type="submit">
    <input name="Username" value="<%= u.getUsername() %>" type="hidden">
    <input name="Password" value="<%= u.getPassword() %>" type="hidden">
    <input name="FirstName" value="<%= u.getFirstName() %>" type="hidden">
    <input name="LastName" value="<%= u.getLastName() %>" type="hidden">
    <input name="Type" value="<%= u.getType() %>" type="hidden">
    <input name="Status" value="<%= u.getActivated() %>" type="hidden">
</form>
</td>
<td style="vertical-align: top;"><%= u.getFirstName() + " " + u.getLastName() %>
</td>
<td style="vertical-align: top;"><%= u.getUsername() %>
</td>
<td style="vertical-align: top;"><%= u.getPassword() %>
</td>
<td style="vertical-align: top;"><%= u.getType() %>
</td>
<td style="vertical-align: top;"><%= u.getActivated() %>
</td>
<td style="vertical-align: top;">
<form method="post" action="Delete.jsp" name="Delete">
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

