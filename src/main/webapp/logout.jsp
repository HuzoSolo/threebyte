<%-- 
    Document   : logout
    Created on : Dec 3, 2023, 4:51:29 AM
    Author     : muhuz
--%>



<%@page import="SessionAndCookie.UseBeanSession"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="sessionBean" class="SessionAndCookie.UseBeanSession" scope="session"/>


<%

    if (sessionBean.getUsername() == null) {
        response.sendRedirect("pages-login.jsp");
    }

%>


<%
    
    session.invalidate();
    
    response.sendRedirect("index.jsp");

%>
