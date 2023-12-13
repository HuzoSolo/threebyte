<%-- 
    Document   : delete-comment
    Created on : Dec 10, 2023, 3:26:12 AM
    Author     : muhuz
--%>

<%@page import="Models.User"%>
<%@page import="Dao.CommentDaoImpl"%>
<%@page import="Models.Comment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="sessionBean" class="SessionAndCookie.UseBeanSession" scope="session"/>
<%
    int id = Integer.parseInt(request.getParameter("id"));

    Comment comment = new Comment();
    CommentDaoImpl commentDao = new CommentDaoImpl();

    comment = commentDao.getComment(id);

    if (comment.getUserId() == sessionBean.getId() || sessionBean.getRank() == User.Rank.GIGABYTE) {

        commentDao.deleteComment(id);
        response.sendRedirect("topic.jsp?id=" + request.getParameter("topicId") + "&title=" + request.getParameter("title"));

    } else {

        response.sendRedirect("index.jsp");

    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
