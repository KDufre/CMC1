<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="cmc.backend.entities.*" import="cmc.backend.*" import="java.util.*"%>
    <%@include file="VerifyLoginUser.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Results Menu</title>
    <style>
		table {
  			font-family: arial, sans-serif;
  			border-collapse: collapse;
  			width: 100%;
			}

td{
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}
th {
	border-width: 2px;
	font-weight: bold;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>

<body>
	<%
	SearchController searchC = new SearchController();
	
	String school = request.getParameter("School");
	String state = request.getParameter("State");
	String location = request.getParameter("Location");
	String control = request.getParameter("Control");
	String minNumberOfStudentsInput = request.getParameter("MinNumStudents");
	int minNumberOfStudents = 0;
	if(minNumberOfStudentsInput!="") {
		minNumberOfStudents = Integer.parseInt(minNumberOfStudentsInput);
	}
	String maxNumberOfStudentsInput = request.getParameter("MaxNumStudents");
	int maxNumberOfStudents = Integer.MAX_VALUE;
	if(maxNumberOfStudentsInput!="") {
		maxNumberOfStudents = Integer.parseInt(maxNumberOfStudentsInput);
	}
	String minPercentFemaleInput = request.getParameter("MinPercentFemale");
	int minPercentFemale = 0;
	if(minPercentFemaleInput!="") {
		minPercentFemale = Integer.parseInt(minPercentFemaleInput);
	}
	String maxPercentFemaleInput = request.getParameter("MaxPercentFemale");
	int maxPercentFemale = Integer.MAX_VALUE;
	if(maxPercentFemaleInput!="") {
		maxPercentFemale = Integer.parseInt(maxPercentFemaleInput);
	}
	String minSATVerbalInput = request.getParameter("MinSATVerbal");
	int minSATVerbal = 0;
	if(minSATVerbalInput!="") {
		minSATVerbal = Integer.parseInt(minSATVerbalInput);
	}
	String maxSATVerbalInput =request.getParameter("MaxSATVerbal");
	int maxSATVerbal = Integer.MAX_VALUE;
	if(maxSATVerbalInput!="") {
		maxSATVerbal = Integer.parseInt(maxSATVerbalInput);
	}
	String minSATMathInput = request.getParameter("MinSATMath");
	int minSATMath = 0;
	if(minSATMathInput!="") {
		minSATMath = Integer.parseInt(minSATMathInput);
	}
	String maxSATMathInput = request.getParameter("MaxSATMath");
	int maxSATMath = Integer.MAX_VALUE;
	if(maxSATMathInput!="") {
		maxSATMath = Integer.parseInt(maxSATMathInput);
	}
	String minExpensesInput = request.getParameter("MinExpenses");
	int minExpenses = 0;
	if(minExpensesInput!="") {
		minExpenses = Integer.parseInt(minExpensesInput);
	}
	String maxExpensesInput = request.getParameter("MaxExpenses");
	int maxExpenses = Integer.MAX_VALUE;
	if(maxExpensesInput!="") {
		maxExpenses = Integer.parseInt(maxExpensesInput);
	}
	String minPercentAidInput = request.getParameter("MinPercentFA");
	int minPercentAid = 0;
	if(minPercentAidInput!="") {
		minPercentAid = Integer.parseInt(minPercentAidInput);
	}
	String maxPercentAidInput = request.getParameter("MaxPercentFA");
	int maxPercentAid = Integer.MAX_VALUE;
	if(maxPercentAidInput!="") {
		maxPercentAid = Integer.parseInt(maxPercentAidInput);
	}
	String minNumOfApplicantsInput = request.getParameter("MinNumApplicants");
	int minNumOfApplicants = 0;
	if(minNumOfApplicantsInput!="") {
		minNumOfApplicants = Integer.parseInt(minNumOfApplicantsInput);
	}
	String maxNumOfApplicantsInput = request.getParameter("MaxNumApplicants");
	int maxNumOfApplicants = Integer.MAX_VALUE;
	if(maxNumOfApplicantsInput!="") {
		maxNumOfApplicants = Integer.parseInt(maxNumOfApplicantsInput);
	}
	String minPercentAdmittedInput = request.getParameter("MinPercentAdmitted");
	int minPercentAdmitted = 0;
	if(minPercentAdmittedInput!="") {
		minPercentAdmitted = Integer.parseInt(minPercentAdmittedInput);
	}
	String maxPercentAdmittedInput = request.getParameter("MaxPercentAdmitted");
	int maxPercentAdmitted = Integer.MAX_VALUE;
	if(maxPercentAdmittedInput!="") {
		maxPercentAdmitted = Integer.parseInt(maxPercentAdmittedInput);
	}
	String minPercentEnrolledInput = request.getParameter("MinPercentEnrolled");
	int minPercentEnrolled = 0;
	if(minPercentEnrolledInput!="") {
		minPercentEnrolled = Integer.parseInt(minPercentEnrolledInput);
	}
	String maxPercentEnrolledInput = request.getParameter("MaxPercentEnrolled");
	int maxPercentEnrolled = Integer.MAX_VALUE;
	if(maxPercentEnrolledInput!="") {
		maxPercentEnrolled = Integer.parseInt(maxPercentEnrolledInput);
	}
	String minAcademicScaleInput = request.getParameter("MinAcademics");
	int minAcademicScale = 0;
	if(minAcademicScaleInput!="") {
		minAcademicScale = Integer.parseInt(minAcademicScaleInput);
	}
	String maxAcademicScaleInput = request.getParameter("MaxAcademics");
	int maxAcademicScale = Integer.MAX_VALUE;
	if(maxAcademicScaleInput!="") {
		maxAcademicScale = Integer.parseInt(maxAcademicScaleInput);
	}
	String minSocialScaleInput = request.getParameter("MinSocial");
	int minSocialScale = 0;
	if(minSocialScaleInput!="") {
		minSocialScale = Integer.parseInt(minSocialScaleInput);
	}
	String maxSocialScaleInput = request.getParameter("MaxSocial");
	int maxSocialScale = Integer.MAX_VALUE;
	if(maxSocialScaleInput!="") {
		maxSocialScale = Integer.parseInt(maxSocialScaleInput);
	}
	String minQualityLifeScaleInput = request.getParameter("MinQualityOfLife");
	int minQualityLifeScale = 0;
	if(minQualityLifeScaleInput!="") {
		minQualityLifeScale = Integer.parseInt(minQualityLifeScaleInput);
	}
	String maxQualityLifeScaleInput = request.getParameter("MaxQualityOfLife");
	int maxQualityLifeScale = Integer.MAX_VALUE;
	if(maxQualityLifeScaleInput!="") {
		maxQualityLifeScale = Integer.parseInt(maxQualityLifeScaleInput);
	}
	String emphasis1 = request.getParameter("Emphasis1");
	String emphasis2 = request.getParameter("Emphasis2");
	String emphasis3 = request.getParameter("Emphasis3");
	String emphasis4 = request.getParameter("Emphasis4");
	String emphasis5 = request.getParameter("Emphasis5");
	
	List<University> sList = searchC.search(school, state, location, control, minNumberOfStudents, maxNumberOfStudents, 
			minPercentFemale, maxPercentFemale, minSATVerbal, maxSATVerbal, minSATMath, maxSATMath, 
			minExpenses, maxExpenses, minPercentAid, maxPercentAid, minNumOfApplicants, maxNumOfApplicants, 
			minPercentAdmitted, maxPercentAdmitted, minPercentEnrolled, maxPercentEnrolled, minAcademicScale, 
			maxAcademicScale, minSocialScale, maxSocialScale, minQualityLifeScale, maxQualityLifeScale, emphasis1, emphasis2, emphasis3, emphasis4, emphasis5);
	%>
<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
<tr>
<th style="vertical-align: top; text-align: center;">University
</th>
<th style="vertical-align: top; text-align: center;">State
</td>
<th style="vertical-align: top; text-align: center;">Students
</th>
<th style="vertical-align: top; text-align: center;">Expenses
</th>
<th style="vertical-align: top; text-align: center;">5 Similar
</th>
<th style="vertical-align: top; text-align: center;" > Add
</th>
</tr>
	
	<%
	for(University uni : sList){
	%>
	
<tr>
<td style="vertical-align: top;"><%= uni.getSchool()%>
</td>
<td style="vertical-align: top;"><%= uni.getState()%>
</td>
<td style="vertical-align: top;"><%= uni.getNumStudents()%>
</td>	
<td style="vertical-align: top;"><%= uni.getExpenses()%>
</td>

<td style="vertical-align: top;">
<form method="post" action="FiveSimilarSchool.jsp" name="Similar">
    <input name="Similar" value="Similar" type="submit">
    <input name="School" value="<%= uni.getSchool() %>" type="hidden">
</form>
</td>
<td style="vertical-align: top;">
<form method="post" action="SaveSchool_action.jsp" name="Add">
    <input name="Add" value="Add" type="submit">
    <input name="School" value="<%= uni.getSchool() %>" type="hidden">
</form>
</td>
	<%} %>
</body>
</html>