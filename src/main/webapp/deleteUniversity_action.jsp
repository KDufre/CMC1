<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="cmc.backend.entities.*" import="cmc.backend.*" import="java.util.*"%>
    <%@include file="VerifyLoginAdmin.jsp" %>
    
<% 
boolean success = false;
try{
	UniversityController dU = new UniversityController();
	success = dU.deleteUniversity(request.getParameter("School"));
	
}catch(Exception e){
	
	}
	response.sendRedirect("ManageUniversities.jsp?success=" + success);
%>