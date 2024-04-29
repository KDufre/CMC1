<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cmc.backend.entities.*" import="cmc.backend.*" %>
    <%@include file="VerifyLoginAdmin.jsp" %>
<% 
boolean success = false;
	try{
	AccountController editjuser = new AccountController();
	User newnew = new User(request.getParameter("Username"), 
			request.getParameter("Password"), 
			request.getParameter("Type").charAt(0), 
			request.getParameter("FirstName"), 
			request.getParameter("LastName"), 
			request.getParameter("Status").charAt(0));
	success = editjuser.editUser(newnew);
	if(newnew.isActivated()==false && user.getUsername().equals(request.getParameter("Username"))){
		response.sendRedirect("Logout_action.jsp?error=-2");
		return;
	}
	}catch(Exception e){
		
	}
	response.sendRedirect("AdminMenu.jsp?success=" + success);
	%>