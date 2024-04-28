<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="cmc.backend.entities.*" import="cmc.backend.*" import="java.util.*"%>
    <%@include file="VerifyLoginAdmin.jsp" %>
    
<%
	boolean success = false;
		UniversityController addUniversity = new UniversityController();
	try{
		University addUni = new University(request.getParameter("School"), request.getParameter("State"), request.getParameter("Location"), 
				request.getParameter("Control"), Integer.parseInt(request.getParameter("NumStudents")),
				Double.parseDouble(request.getParameter("PercentFemale")), Integer.parseInt(request.getParameter("SATVerbal")), 
				Integer.parseInt(request.getParameter("SATMath")), 
				Double.parseDouble(request.getParameter("Expenses")), Double.parseDouble(request.getParameter("PercentFA")), 
				Integer.parseInt(request.getParameter("NumApplicants")), 
				Double.parseDouble(request.getParameter("PercentAdmitted")), Double.parseDouble(request.getParameter("PercentEnrolled")), 
				Integer.parseInt(request.getParameter("Academics")), 
				Integer.parseInt(request.getParameter("Social")), Integer.parseInt(request.getParameter("QualityOfLife")), 
				Double.parseDouble(request.getParameter("GraduationRate")),
				request.getParameter("UniversityLink"));
		success = addUniversity.addUniversity(addUni);
		}catch(Exception e){
			
		}
	
	response.sendRedirect("AdminMenu.jsp?AddSuccessfully=" + success);
%>