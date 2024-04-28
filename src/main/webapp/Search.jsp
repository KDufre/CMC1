<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="cmc.backend.entities.*" import="cmc.backend.*" import="java.util.*"%>
    <%@include file="VerifyLoginUser.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search for Schools</title>
<style>
body {
    background-color: #777;
    font-family: Arial, sans-serif; /* Added font-family for better readability */
}

.container {
    width: 200%; /* Adjust the width of the container */
    margin: 0 auto; /* Center the container horizontally */
    padding: 20px; /* Add some padding for spacing */
    overflow-y: auto; /* Enable vertical scrolling */
    max-height: 500px; /* Set a maximum height for the container */
}

table {
    width: 100%; /* Make the table width 100% of its container */
    border-collapse: collapse; /* Collapse table borders for a cleaner look */
    border: 6px solid #000; /* Add a black border */
}

th {
    border: 1px solid #dddddd;
    padding: 10px; /* Add padding to cells */
    text-align: left;
    font-weight: bold;
}

th {
    font-weight: bold;
}

tr:nth-child(odd) {
    background-color: #dddddd;
}

tr:nth-child(even) {
    background-color: rgb(211, 250, 211);
}

input[type="text"] {
    width: 100%; /* Make text input fields span the entire width */
    text-align: right;
}

input[type="submit"], input[type="reset"] {
    padding: 10px 20px; /* Add padding to buttons */
    background-color: #4CAF50; /* Green background color */
    color: white; /* White text color */
    border: none;
    border-radius: 4px;
    cursor: pointer;
    margin-top: 10px; /* Add some space between inputs */
    text-align: right;
    border: 2px solid black;
    
}

input[type="submit"]:hover, input[type="reset"]:hover {
    background-color: rgb(211, 250, 211); /* Darker green on hover */
    text-align: right;
}
td {
border: 1px solid #dddddd;
    padding: 2px; /* Add padding to cells */
    text-align: right;
}

</style>
</head>
<body>
	<form method="post" action="SearchResults.jsp" name="Search"><br>
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
	<td style="vertical-align: top;"><input name="MinPercentAdmitted"> </td>
	<td style="vertical-align: top;">and
	</td>
	<td style="vertical-align: top;"><input name="MaxPercentAdmitted"> </td>
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
	<tr>
	<td style="vertical-align: top;">Academics (1-5)<br>
	</td>
	<td style="vertical-align: top;">between
	</td>
	<td style="vertical-align: top;"><input name="MinAcademics"> </td>
	<td style="vertical-align: top;">and
	</td>
	<td style="vertical-align: top;"><input name="MaxAcademics"> </td>
	</tr>
	<tr>
	<td style="vertical-align: top;">Social (1-5)<br>
	</td>
	<td style="vertical-align: top;">between
	</td>
	<td style="vertical-align: top;"><input name="MinSocial"> </td>
	<td style="vertical-align: top;">and
	</td>
	<td style="vertical-align: top;"><input name="MaxSocial"> </td>
	</tr>
	<tr>
	<td style="vertical-align: top;">Quality of Life (1-5)<br>
	</td>
	<td style="vertical-align: top;">between
	</td>
	<td style="vertical-align: top;"><input name="MinQualityOfLife"> </td>
	<td style="vertical-align: top;">and
	</td>
	<td style="vertical-align: top;"><input name="MaxQualityOfLife"> </td>
	</tr>
	<tr>
	<td style="vertical-align: top;">Emphasis (up to five)<br>
	</td>
	<td style="vertical-align: top;"><input name="Emphasis1"> </td>
	</tr>
	<tr>
	<td style="vertical-align: top;"><br>
	</td>
	<td style="vertical-align: top;"><input name="Emphasis2"> </td>
	</tr>
	<tr>
	<td style="vertical-align: top;"><br>
	</td>
	<td style="vertical-align: top;"><input name="Emphasis3"> </td>
	</tr>
	<tr>
	<td style="vertical-align: top;"><br>
	</td>
	<td style="vertical-align: top;"><input name="Emphasis4"> </td>
	</tr>
	<tr>
	<td style="vertical-align: top;"><br>
	</td>
	<td style="vertical-align: top;"><input name="Emphasis5"> </td>
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
	<form method="post" action="UserMenu.jsp" name="Back">
    <input name="Back" value="Back To Main Menu" type="submit">
    <input name="Back" type="hidden">
	</form>
</body>
</html>