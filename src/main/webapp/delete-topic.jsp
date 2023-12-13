<%-- 
    Document   : delete-comment
    Created on : Dec 10, 2023, 3:26:00 AM
    Author     : muhuz
--%>

<%@page import="Dao.TopicDaoImp"%>
<%@page import="Models.Topic"%>
<%@page import="Models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="sessionBean" class="SessionAndCookie.UseBeanSession" scope="session"/>
<%
    int id = Integer.parseInt(request.getParameter("id"));

    Topic topic = new Topic();
    TopicDaoImp topicDao = new TopicDaoImp();

    topic = topicDao.getTopic(id);

    if (topic.getUserId() == sessionBean.getId() || sessionBean.getRank() == User.Rank.GIGABYTE) {

        topicDao.deleteTopic(id);
        response.sendRedirect("index.jsp");

    } else {

        response.sendRedirect("index.jsp");

    }
    
//ilerileyen sürümlerde topicler silinirken o topic'e ait tüm commentler silinmeli! 
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
    </body>
</html>
