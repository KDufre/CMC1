<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cmc.backend.entities.*" import="cmc.backend.*" %>
    <%@include file="VerifyLoginUser.jsp" %>
<% 
	AccountController editjuser = new AccountController();
	User newnew = new User(user.getUsername(), request.getParameter("Password"), request.getParameter("Type").charAt(0), request.getParameter("FirstName"), request.getParameter("LastName"), request.getParameter("Status").charAt(0));
	
	editjuser.editUser(newnew);
	response.sendRedirect("EditProfile.jsp");
%>