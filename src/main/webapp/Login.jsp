<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cmc.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log in</title>
</head>
<body>
<% 

String error = request.getParameter("error");
if(error==null){
	
}

else if (error.equals("1")){
	%>
	<p>Invalid Login</p>
	<% 
}
%>
<form method="post" action="Login_action.jsp" name="Login"><br>
<table style="text-align: left; width: 266px; height: 228px;"
border="1" cellpadding="2" cellspacing="2">
<tbody>
<tr>
<td style="vertical-align: top;">Username<br>
</td>
<td style="vertical-align: top;"><input name="Username"> </td>
</tr>
<tr>
<td style="vertical-align: top;">Password<br>
</td>
<td style="vertical-align: top;"><input name="Password"> </td>
</tr>

<td style="vertical-align: top;"><input value="Log in"
name="Log in" type="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td style="vertical-align: top;"><input value="Reset"
name="Reset" type="reset"></td>
</tr>
</tbody>
</table>
<br>
</form>
</body>
</html>