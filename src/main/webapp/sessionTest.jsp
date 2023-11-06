<%-- 
    Document   : SesionTest
    Created on : Nov 6, 2023, 6:20:16 PM
    Author     : muhuz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="usebean" class="SessionAndCookie.UseBeanSession" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            out.println(usebean.getName());
            out.println(usebean.getId());
            out.println(usebean.getSessions());
        %>
    </body>
</html>
