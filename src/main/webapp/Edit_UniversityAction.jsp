<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cmc.backend.entities.*" import="cmc.backend.*" %>
    <%@include file="VerifyLoginAdmin.jsp" %>
<% 
	UniversityController editUni = new UniversityController();
	University mewmew = new University(request.getParameter("School"), request.getParameter("State"), request.getParameter("Location"), 
			request.getParameter("Control"), Integer.parseInt(request.getParameter("NumberOfStudents")),
			Double.parseDouble(request.getParameter("PercentFA")), Integer.parseInt(request.getParameter("SATVerbal")), 
			Integer.parseInt(request.getParameter("SATMath")), 
			Double.parseDouble(request.getParameter("Expenses")), Double.parseDouble(request.getParameter("PercentAid")), 
			Integer.parseInt(request.getParameter("NumApplicants")), 
			Double.parseDouble(request.getParameter("PercentAdmitted")), Double.parseDouble(request.getParameter("PercentEnrolled")), 
			Integer.parseInt(request.getParameter("SocialScale")), 
			Integer.parseInt(request.getParameter("AcademicScale")), Integer.parseInt(request.getParameter("QualityOfLife")), 
			Double.parseDouble(request.getParameter("GraduationRate")),
			request.getParameter("UniversityLink"));
	boolean success = editUni.editUniversity(mewmew);
	response.sendRedirect("AdminMenu.jsp?success=" + success);
%>