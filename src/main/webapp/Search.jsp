<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="cmc.backend.entities.*" import="cmc.backend.*" import="java.util.*"%>
    <%@include file="VerifyLoginUser.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search for Schools</title>
</head>
<body>
	<form method="post" action="Search_action.jsp" name="Search"><br>
	<table style="text-align: center; width: 1000px;"
	border="1" cellpadding="2" cellspacing="2">
	<tbody>
	<tr>
	<td style="vertical-align: top;">School<br>
	</td>
	<td style="vertical-align: top;"><input name="School"> 
	</td>
	</tr>
	<tr>
	<td style="vertical-align: top;">State<br>
	</td>
	<td style="vertical-align: top;"><input name="State"> 
	</td>
	</tr>
	<tr>
	<td style="vertical-align: top;">Location<br>
	</td>
	<td style="vertical-align: top;"><input name="Location"> </td>
	</tr>
	<tr>
	<td style="vertical-align: top;">Control<br>
	</td>
	<td style="vertical-align: top;"><input name="Control"> </td>
	</tr>
	<tr>
	<td style="vertical-align: top;">Number of Students<br>
	<td style="vertical-align: top;">between
	</td>
	</td>
	<td style="vertical-align: top;"><input name="MinNumStudents"> </td>
	<td style="vertical-align: top;">and
	</td>
	<td style="vertical-align: top;"><input name="MaxNumStudents"> </td>
	</tr>
	<tr>
	<td style="vertical-align: top;">Percent Female<br>
	</td>
	<td style="vertical-align: top;">between
	</td>
	<td style="vertical-align: top;"><input name="MinPercentFemale"> </td>
	<td style="vertical-align: top;">and
	</td>
	<td style="vertical-align: top;"><input name="MaxPercentFemale"> </td>
	</tr>
	<tr>
	<td style="vertical-align: top;">SAT Verbal<br>
	</td>
	<td style="vertical-align: top;">between
	</td>
	<td style="vertical-align: top;"><input name="MinSATVerbal"> </td>
	<td style="vertical-align: top;">and
	</td>
	<td style="vertical-align: top;"><input name="MaxSATVerbal"> </td>
	</tr>
	<tr>
	<td style="vertical-align: top;">SAT MATH<br>
	</td>
	<td style="vertical-align: top;">between
	</td>
	<td style="vertical-align: top;"><input name="MinSATMath"> </td>
	<td style="vertical-align: top;">and
	</td>
	<td style="vertical-align: top;"><input name="MaxSATMath"> </td>
	</tr>
	<tr>
	<td style="vertical-align: top;">Expenses<br>
	</td>
	<td style="vertical-align: top;">between
	</td>
	<td style="vertical-align: top;"><input name="MinExpenses"> </td>
	<td style="vertical-align: top;">and
	</td>
	<td style="vertical-align: top;"><input name="MaxExpenses"> </td>
	</tr>
	<tr>
	<td style="vertical-align: top;">Percent Financial Aid<br>
	</td>
	<td style="vertical-align: top;">between
	</td>
	<td style="vertical-align: top;"><input name="MinPercentFA"> </td>
	<td style="vertical-align: top;">and
	</td>
	<td style="vertical-align: top;"><input name="MaxPercentFA"> </td>
	</tr>
	<tr>
	<td style="vertical-align: top;">Number of Applicants<br>
	</td>
	<td style="vertical-align: top;">between
	</td>
	<td style="vertical-align: top;"><input name="MinNumApplicants"> </td>
	<td style="vertical-align: top;">and
	</td>
	<td style="vertical-align: top;"><input name="MaxNumApplicants"> </td>
	</tr>
	<tr>
	<td style="vertical-align: top;">Percent Admitted<br>
	</td>
	<td style="vertical-align: top;">between
	</td>
	<td style="vertical-align: top;"><input name="PercentAdmitted"> </td>
	<td style="vertical-align: top;">and
	</td>
	<td style="vertical-align: top;"><input name="MaxNumStudents"> </td>
	</tr>
	<tr>
	<td style="vertical-align: top;">Percent Enrolled<br>
	</td>
	<td style="vertical-align: top;">between
	</td>
	<td style="vertical-align: top;"><input name="MinPercentEnrolled"> </td>
	<td style="vertical-align: top;">and
	</td>
	<td style="vertical-align: top;"><input name="MaxPercentEnrolled"> </td>
	</tr>
	<td style="vertical-align: top;"><input value="Search"
	name="Search" type="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td style="vertical-align: top;"><input value="Reset"
	name="Reset" type="reset"></td>
	</tr>
	</tbody>
	</table>
	<br>
	</form>
</body>
</html>