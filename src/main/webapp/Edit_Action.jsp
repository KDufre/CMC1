<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cmc.backend.entities.*" import="cmc.backend.*" %>
    <%@include file="VerifyLoginUser.jsp" %>
<% 
boolean success = false;
	try{
	AccountController editjuser = new AccountController();
	User newnew = new User(user.getUsername(), request.getParameter("State"), request.getParameter("Type").charAt(0), request.getParameter("FirstName"), request.getParameter("LastName"), request.getParameter("Status").charAt(0));
	success = editjuser.editUser(newnew);
	}catch(Exception e){
		
	}
	response.sendRedirect("UserMenu.jsp?success=" + success);
%>