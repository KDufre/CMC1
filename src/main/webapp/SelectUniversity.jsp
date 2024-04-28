<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="cmc.backend.entities.*" import="cmc.backend.*" import="java.util.*"%>
    <%@include file="VerifyLoginUser.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select University</title>
</head>
<body>
<% 
UniversityController uniC = new UniversityController();
University uni = uniC.getSchool(request.getParameter("University"));

%>
<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
	
	
<tr>
<td style="vertical-align: center;">School
</td>
<td style="vertical-align: center;"><%= uni.getSchool()%>
</td>
</tr>
<tr>
<td style="vertical-align: center;">State
</td>
<td style="vertical-align: center;"><%= uni.getState()%>
</td>
</tr><tr>
<td style="vertical-align: center;">Location
</td>
<td style="vertical-align: center;"><%= uni.getLocation()%>
</td>
</tr><tr>
<td style="vertical-align: center;">Control
</td>
<td style="vertical-align: center;"><%= uni.getControl()%>
</td>
</tr><tr>
<td style="vertical-align: center;">Number of Students
</td>
<td style="vertical-align: center;"><%= uni.getNumStudents()%>
</td>
</tr><tr>
<td style="vertical-align: center;">Percent Female
</td>
<td style="vertical-align: center;"><%= uni.getPercentFemale()%>
</td>
</tr><tr>
<td style="vertical-align: center;">SAT Math
</td>
<td style="vertical-align: center;"><%= uni.getSATMath()%>
</td>
</tr><tr>
<td style="vertical-align: center;">SAT Verbal
</td>
<td style="vertical-align: center;"><%= uni.getSATVerbal()%>
</td>
</tr><tr>
<td style="vertical-align: center;">Expenses
</td>
<td style="vertical-align: center;"><%= uni.getExpenses()%>
</td>
</tr><tr>
<td style="vertical-align: center;">Percent Financial Aid
</td>
<td style="vertical-align: center;"><%= uni.getPercentFA()%>
</td>
</tr><tr>
<td style="vertical-align: center;">Number of Applicants
</td>
<td style="vertical-align: center;"><%= uni.getNumApplicants()%>
</td>
</tr><tr>
<td style="vertical-align: center;">Percent Admitted
</td>
<td style="vertical-align: center;"><%= uni.getPercentAdmitted()%>
</td>
</tr><tr>
<td style="vertical-align: center;">Percent Enrolled
</td>
<td style="vertical-align: center;"><%= uni.getPercentEnrolled()%>
</td>
</tr><tr>
<td style="vertical-align: center;">Social Scale (1-5)
</td>
<td style="vertical-align: center;"><%= uni.getSocialScale()%>
</td>
</tr><tr>
<td style="vertical-align: center;">Academic Scale (1-5)
</td>
<td style="vertical-align: center;"><%= uni.getAcademicScale()%>
</td>
</tr><tr>
<td style="vertical-align: center;">Quality Of Life (1-5)
</td>
<td style="vertical-align: center;"><%= uni.getQualLife()%>
</td>
</tr><tr>
<td style="vertical-align: center;">Graduation Rate
</td>
<td style="vertical-align: center;"><%= uni.getGradRate()%>
</td>
</tr>
<tr>
<td style="vertical-align: center;">Website
</td>
<td style="vertical-align: center;"><%= uni.getLink()%>
</td>
</tr>
</tbody>
</table>
<form method="post" action="ViewSavedSchools.jsp" name="Back">
    <input name="Back" value="Back" type="submit">
    <input name="Back" type="hidden">
	</form>
<form method="post" action="RemoveSchool.jsp" name="Remove School">
    <input name="Remove School" value="Remove School" type="submit">
    <input name="University" value="<%= uni.getSchool() %>" type="hidden">
</form>
</body>
</html>