<%@page language="java" import="cmc.backend.*" import="cmc.backend.entities.*"
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
String username = request.getParameter("Username");
String password = request.getParameter("Password");

AccountController controller = new AccountController();
User u = controller.login(username,password);


if(u!=null){
	if(u.getType()=='u'){
		response.sendRedirect("UserMenu.jsp");
		session.setAttribute("loggedInUser", username);
		return;
	}
	else{
		response.sendRedirect("AdminMenu.jsp");
		session.setAttribute("loggedInUser", username);
		return;
	}
}
response.sendRedirect("Login.jsp?error=-1");


%>