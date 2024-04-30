<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cmc.backend.entities.*" import="cmc.backend.*" %>
    <%@include file="VerifyLoginAdmin.jsp" %>
    <%
boolean success = false;
	try{
	AccountController deleteUser = new AccountController();
	success = deleteUser.removeUser(request.getParameter("Username"));
	}
catch(Exception e){
		
	}
	response.sendRedirect("AdminMenu.jsp?dubz=" + success);
%>