<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
response.sendRedirect("Login.jsp");
session.setAttribute("loggedInUser", null);	
%>