<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CMC Login Page</title>
<h1> Welcome to Choose My College!</h1>
<style>
		body{
			background-color: #777;
		}
		h1 {
			position: absolute;
  			top: 10%;
  			left: 50%;
  			transform: translate(-50%, -50%);
  			color: lightgreen;
		}
		table {
  			position: absolute;
  			top: 50%;
  			left: 50%;
  			transform: translate(-50%, -50%);
  			border-style: solid;
  			border: 3px solid #000;
			}

		td	{
  			border: 1px solid #dddddd;
  			text-align: left;
  			padding: 16px;
			}
		th {
			border-width: 4px;
			font-weight: bold;
			}

		tr:nth-child(odd) {
  			background-color: #dddddd;
			}
		tr:nth-child(even) {
  			background-color: rgb(211, 250, 211);;
			}
</style>
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