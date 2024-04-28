<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="cmc.backend.entities.*" import="cmc.backend.*" import="java.util.*"%>
    <%@include file="VerifyLoginAdmin.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit University</title>
</head>
<style>
body {
    background-color: #555;
    font-family: Arial, sans-serif; /* Added font-family for better readability */
}

table {
    border-collapse: collapse; /* Collapse table borders for a cleaner look */
    border: 6px solid #000; /* Add a black border */
}

th {
    border: 1px solid #cccccc;
    padding: 10px; /* Add padding to cells */
    text-align: left;
}

tr:nth-child(odd) {
    background-color: #cccccc;
}

tr:nth-child(even) {
    background-color: rgb(255, 51, 51);
}

input[type="text"] {
    width: 100%; /* Make text input fields span the entire width */
    text-align: right;
}

input[type="submit"], input[type="reset"] {
    padding: 10px 20px; /* Add padding to buttons */
    background-color: rgb(255, 51, 51); /* Green background color */
    color: white; /* White text color */
    border: none;
    border-radius: 4px;
    cursor: pointer;
    margin-top: 10px; /* Add some space between inputs */
    text-align: right;
    
}

input[type="submit"]:hover, input[type="reset"]:hover {
    background-color: #45a049; /* Darker green on hover */
    text-align: right;
}
td {
border: 1px solid #cccccc;
    padding: 2px; /* Add padding to cells */
    text-align: center;
    font-weight: bold;
    
}

</style>
<body>
<% String schl = request.getParameter("University"); 
UniversityController uController = new UniversityController();
University uni = uController.getSchool(schl);
%>
<form method="post" action="Edit_UniversityAction.jsp" name="editUniveristy"><br>
<table style="text-align: left; width: 266px; height: 228px;"
border="1" >
<tbody>
<tr>
<td style="vertical-align: center;">School<br>
</td>
<td style="vertical-align: center;"><input name="School" value="<%=uni.getSchool()%>" readonly><br>
</td>
</tr>
<tr>
<td style="vertical-align: center;">State<br>
</td>
<td style="vertical-align: center;"><input name="State" value="<%=uni.getState()%>"><br>
</td>
</tr>
<tr>
<td style="vertical-align: center;">Location<br>
</td>
<td style="vertical-align: center;"><input name="Location" value="<%=uni.getLocation()%>"><br>
</td>
</tr>
<tr>
<td style="vertical-align: center;">Control<br>
</td>
<td style="vertical-align: center;"><input name="Control" value="<%=uni.getControl()%>"> </td>
</tr>
<tr>
<td style="vertical-align: center;">Number of Students<br>
</td>
<td style="vertical-align: center;"><input name="NumberOfStudents" value="<%=uni.getNumStudents()%>" > </td>
</tr>
<tr>
<td style="vertical-align: center;">Percent Female<br>
</td>
<td style="vertical-align: center;"><input name="PercentFA" value="<%=uni.getPercentFemale()%>"> </td>
</tr>
<tr>
<td style="vertical-align: center;">SAT Verbal<br>
</td>
<td style="vertical-align: center;"><input name="SATVerbal" value="<%=uni.getSATVerbal()%>" > </td>
</tr>
<tr>
<td style="vertical-align: center;">SAT Math<br>
</td>
<td style="vertical-align: center;"><input name="SATMath" value="<%=uni.getSATMath()%>" > </td>
</tr>
<tr>
<td style="vertical-align: center;">Expenses<br>
</td>
<td style="vertical-align: center;"><input name="Expenses" value = "<%=uni.getExpenses() %>" > </td>
</tr>
<tr>
<td style="vertical-align: center;">Percent Financial Aid<br>
</td>
<td style="vertical-align: center;"><input name="PercentAid" value="<%=uni.getPercentFA()%>" > </td>
</tr>
<tr>
<td style="vertical-align: center;">Number Of Applicants<br>
</td>
<td style="vertical-align: center;"><input name="NumApplicants" value="<%=uni.getNumApplicants()%>" > </td>
</tr>
<tr>
<td style="vertical-align: center;">Percent Admitted<br>
</td>
<td style="vertical-align: center;"><input name="PercentAdmitted" value="<%=uni.getPercentAdmitted()%>" > </td>
</tr>
<tr>
<td style="vertical-align: center;">Percent Enrolled<br>
</td>
<td style="vertical-align: center;"><input name="PercentEnrolled" value="<%=uni.getPercentEnrolled()%>" > </td>
</tr>
<tr>
<td style="vertical-align: center;">Academic Scale<br>
</td>
<td style="vertical-align: center;"><input name="AcademicScale" value="<%=uni.getAcademicScale()%>" > </td>
</tr>
<tr>
<td style="vertical-align: center;">Social Scale (1-5)<br>
</td>
<td style="vertical-align: center;"><input name="SocialScale" value="<%=uni.getSocialScale()%>" > </td>
</tr>
<tr>
<td style="vertical-align: center;">Quality of Life (1-5)<br>
</td>
<td style="vertical-align: center;"><input name="QualityOfLife" value="<%=uni.getQualLife()%>" > </td>
</tr>
<tr>
<td style="vertical-align: center;">Graduation Rate<br>
</td>
<td style="vertical-align: center;"><input name="GraduationRate" value="<%=uni.getGradRate()%>" > </td>
</tr>
<tr>
<td style="vertical-align: center;">University Link<br>
</td>
<td style="vertical-align: center;"><input name="UniversityLink" value="<%=uni.getLink()%>" > </td>
</tr>

<tr>
<td style="vertical-align: center;"><input value="Edit"
name="Edit" type="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td style="vertical-align: center;"><input value="Reset"
name="Reset" type="reset"></td>
</tr>
</tbody>
</table>
<br>
</form>
<form method="post" action="UserMenu.jsp" name="Back">
    <input name="Back" value="Back To Main Menu" type="submit">
    <input name="Back" type="hidden">
	</form>
</body>
</html>