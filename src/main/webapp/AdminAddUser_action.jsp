<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cmc.backend.entities.*" import="cmc.backend.*" %>
    <%@include file="VerifyLoginAdmin.jsp" %>
    <%
boolean success = false;
	try{
	AccountController AddUser = new AccountController();
	success = AddUser.addUser(request.getParameter("Username"), request.getParameter("Password"), request.getParameter("FirstName"), 
			request.getParameter("LastName"), request.getParameter("Type").charAt(0)=='a');
	}
catch(Exception e){
	
	}
	response.sendRedirect("AdminMenu.jsp?win=" + success);
%>