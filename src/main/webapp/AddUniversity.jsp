<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="cmc.backend.entities.*" import="cmc.backend.*" import="java.util.*"%>
    <%@include file="VerifyLoginAdmin.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add University</title>
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
    background-color: #87CEEB;
}

input[type="text"] {
    width: 100%; /* Make text input fields span the entire width */
    text-align: right;
}

input[type="submit"], input[type="reset"] {
    padding: 10px 20px; /* Add padding to buttons */
    background-color: #87CEEB; /* Green background color */
    color: white; /* White text color */
    border: none;
    border-radius: 4px;
    cursor: pointer;
    margin-top: 10px; /* Add some space between inputs */
    text-align: right;
    border: 2px solid black;
    
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
</head>
<body>
<form method="post" action="AddUniversity_action.jsp" name="AddUniversity"><br>
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
	<td style="vertical-align: top;"><input name="NumStudents"> </td>
	</tr>
	<tr>
	<td style="vertical-align: top;">Percent Female<br>
	</td>
	<td style="vertical-align: top;"><input name="PercentFemale"> </td>
	</tr>
	<tr>
	<td style="vertical-align: top;">SAT Verbal<br>
	</td>
	<td style="vertical-align: top;"><input name="SATVerbal"> </td>
	</tr>
	<tr>
	<td style="vertical-align: top;">SAT MATH<br>
	</td>
	<td style="vertical-align: top;"><input name="SATMath"> </td>
	</tr>
	<tr>
	<td style="vertical-align: top;">Expenses<br>
	</td>
	<td style="vertical-align: top;"><input name="Expenses"> </td>
	</tr>
	<tr>
	<td style="vertical-align: top;">Percent Financial Aid<br>
	</td>
	<td style="vertical-align: top;"><input name="PercentFA"> </td>
	</tr>
	<tr>
	<td style="vertical-align: top;">Number of Applicants<br>
	</td>
	<td style="vertical-align: top;"><input name="NumApplicants"> </td>
	</tr>
	<tr>
	<td style="vertical-align: top;">Percent Admitted<br>
	</td>
	<td style="vertical-align: top;"><input name="PercentAdmitted"> </td>
	</tr>
	<tr>
	<td style="vertical-align: top;">Percent Enrolled<br>
	</td>
	<td style="vertical-align: top;"><input name="PercentEnrolled"> </td>
	</tr>
	<tr>
	<td style="vertical-align: top;">Academics (1-5)<br>
	</td>
	<td style="vertical-align: top;"><input name="Academics"> </td>
	</tr>
	<tr>
	<td style="vertical-align: top;">Social (1-5)<br>
	</td>
	<td style="vertical-align: top;"><input name="Social"> </td>
	</tr>
	<tr>
	<td style="vertical-align: top;">Quality of Life (1-5)<br>
	</td>
	<td style="vertical-align: top;"><input name="QualityOfLife"> </td>
	</tr>
	<td style="vertical-align: top;"><input value="Add University"
	name="Add" type="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td style="vertical-align: top;"><input value="Reset"
	name="Reset" type="reset"></td>
	</tr>
	</tbody>
	</table>
	<br>
	</form>
	<form method="post" action="ManageUniversities.jsp" name="Back">
    <input name="Back" value="Back" type="submit">
    <input name="Back" type="hidden">
	</form>
</body>
</html>