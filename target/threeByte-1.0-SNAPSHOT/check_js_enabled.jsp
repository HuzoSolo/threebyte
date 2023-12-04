<%-- 
    Document   : check_js_enabled
    Created on : Dec 4, 2023, 2:12:37 PM
    Author     : muhuz
--%>

<%@page import="SecurityTb.AdminDashboardController"%>
<%@page import="SecurityTb.CheckJavaScriptServlet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <%
    
     CheckJavaScriptServlet checkJs = new CheckJavaScriptServlet();
     checkJs.doPost(request, response);
     
     AdminDashboardController dashControl = new AdminDashboardController();
     
     String currentURL = request.getRequestURL().toString();
     
     response.sendRedirect(dashControl.getAdminDashboardPage(request, currentURL));
          
     
    %>
</html>
