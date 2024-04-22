<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cmc.backend.entities.*" import="cmc.backend.*" import="java.util.*"%>

<% 
AccountController ui = new AccountController();
User user = ui.getUser((String)session.getAttribute("loggedInUser"));
if(user==null){
	response.sendRedirect("Login.jsp");
}
else if(user.isAdmin()==true){
	response.sendRedirect("AdminMenu.jsp");
}
%>