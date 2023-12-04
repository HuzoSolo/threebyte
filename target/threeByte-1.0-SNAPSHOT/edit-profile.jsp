<%-- 
    Document   : edit-profile
    Created on : Dec 3, 2023, 3:38:15 PM
    Author     : muhuz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="sessionBean" class="SessionAndCookie.UseBeanSession" scope="session"/>


<%

    if (sessionBean.getUsername() == null) {
        response.sendRedirect("pages-login.jsp");
    }

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%

            String picture = request.getParameter("picture");
            String username = request.getParameter("username");
            String email = request.getParameter("email");

            sessionBean.setProfilePicture(picture);
            sessionBean.setUsername(username);
            sessionBean.setEmail(email);
            

            //sql için kaydetme operasyonları yapılacak
            //basitçe verileri database'e kaydetmek
            
            response.sendRedirect("pages-profile.jsp");

        %>
    </body>
</html>
