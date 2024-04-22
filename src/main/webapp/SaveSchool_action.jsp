<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="cmc.backend.entities.*" import="cmc.backend.*" import="java.util.*"%>
    <%@include file="VerifyLoginUser.jsp" %>
    
<%
UniversityController uc = new UniversityController();
uc.saveSchool(user.getUsername(), request.getParameter("School"));
response.sendRedirect("Search.jsp");

%>