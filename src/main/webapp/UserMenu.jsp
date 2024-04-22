<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cmc.backend.entities.*" import="cmc.backend.*" 
    import="java.util.*"%>
    <%@include file="VerifyLoginUser.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Menu</title>
</head>
<body>
<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
<tr align="center">
	<td colspan="8" rowspan="1" style="vertical-align: top;"><a
	href="Search.jsp">Search</a>
	</td>
</tr>
<tr align="center">
	<td colspan="8" rowspan="1" style="vertical-align: top;"><a
	href="ViewSavedSchools.jsp">View Saved Schools</a>
	</td>
</tr>
<tr align="center">
	<td colspan="8" rowspan="1" style="vertical-align: top;"><a
	href="EditUser.jsp">Edit Profile</a>
	</td>
</tr>
<tr align="center">
	<td colspan="8" rowspan="1" style="vertical-align: top;"><a
	href="Logout_action.jsp">Logout</a>
	</td>
</tr>
</body>
</html>