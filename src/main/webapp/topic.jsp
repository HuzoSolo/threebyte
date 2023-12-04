<%-- 
    Document   : topic
    Created on : Dec 2, 2023, 11:11:37 PM
    Author     : muhuz
--%>

<%@page import="Dao.CommentDaoImpl"%>
<%@page import="Models.Topic"%>
<%@page import="Dao.TopicDaoImp"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="Models.Comment"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="sessionBean" class="SessionAndCookie.UseBeanSession" scope="session"/>



<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title><%= request.getParameter("title")%></title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <!-- Favicons -->
        <link href="assets/img/favicon.png" rel="icon">
        <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.gstatic.com" rel="preconnect">
        <link
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
            rel="stylesheet">

        <!-- Vendor CSS Files -->
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
        <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">

        <!-- Template Main CSS File -->
        <link href="assets/css/style.css" rel="stylesheet">


    </head>

    <body>

        <jsp:include page="navbar.jsp" flush="true" />

        <main class="p-5">
            
            <%
            
            TopicDaoImp TopicDao = new TopicDaoImp();
            Topic pageTopic = new Topic();
            
            pageTopic = TopicDao.getTopic(Integer.parseInt(request.getParameter("id")));
            
            %>

            <div class="row">
                <div class="col-xl-1 col-lg-1 col-md-12 col-sm-12"></div>
                <div class="col-xl-10 col-lg-10 col-md-10 col-sm-12">

                    <div class="card p-5">
                        <div class="container">
                            <div class="card-title">
                                <h3><%= pageTopic.getTitle() %></h3>
                            </div>
                            <div class="card-subtitle ps-4 text-muted">
                                <h5>Posted by <%= pageTopic.getUserId() %> on <%= pageTopic.getCreatedAt() %></h5>
                            </div>
                            <hr>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-1">
                                        <div class="row-vertical">
                                            <div class="col">
                                                <div class="btn btn-black rounded-circle mb-3"
                                                     style="width: 2.5rem; height: 2.5rem;">
                                                    <i class="bi bi-caret-up-fill"></i>
                                                </div>
                                            </div>

                                            <div class="col">
                                                <h4 class="vote">
                                                    0
                                                </h4>
                                            </div>

                                            <div class="col">
                                                <div class="btn btn-black rounded-circle mt-3"
                                                     style="width: 2.5rem; height: 2.5rem;">
                                                    <i class="bi bi-caret-down-fill"></i>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-11 ps-2 ps-sm-3">
                                        <p class="text-muted"><%= pageTopic.getContent() %></p>
                                    </div>
                                </div>
                            </div>

                            <div class="row mt-4">
                                <div class="col-md-8">
                                    <h4 class="mb-5">Comments</h4>
                                    <form action="" method="post">
                                        <div class="mb-3 ps-3">
                                            <label for="comment" class="form-label">Write your comment:</label>
                                            <!-- Quill Editor Default -->
                                            <div class="input-group mb-3">
                                                <textarea name="content" class="form-control" id="exampleFormControlTextarea1" rows="5" placeholder="Discuss your opinion!"></textarea>
                                            </div>
                                        </div>
                                        <button type="submit" class="btn btn-ubuntu mt-3"><i class="bi bi-chat-fill"></i> Comment!</button>
                                </div>
                                </form>
                            </div>
                        </div>
                    </div>

                    <!-- comment -->
                    <%
                        String content = request.getParameter("content");
                        ArrayList<Comment> comments = new ArrayList();
                        
                        CommentDaoImpl commentImp = new CommentDaoImpl();
                        
                        comments = commentImp.getAllCommentsByTopicId(pageTopic.getId());
                        
                        if(comments.isEmpty()){
                        out.println("5269");
                        }

                       

                        for (int i = 0; i < comments.size(); i++) {
                            if (comments.get(i).getContent() != null) {

                    %>

                    <div class="card p-5 mt-3">
                        <div class="container">

                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-2">
                                        <!--profile photo of user-->

                                        <!-- profil fotoğrafı yorum yapan kişinin id'si ile kişi bilgileri alındıktan sonra user nesnesinden çekilecektir -->
                                        <!-- ben burada sadece örnek olsun diye koydum-->
                                        <img src="<%= comments.get(i).getUserId() %>" alt="Profile" class="rounded-circle " width="100 rem"
                                             height="100 rem">

                                    </div>
                                    <div class="col-md-10 ps-2 ps-sm-3">
                                        <p class="text-muted"><%= comments.get(i).getContent()%></p>
                                    </div>
                                </div>
                                <div class="text-muted text-end fs-6 pt-2">
                                    Posted by <%= comments.get(i).getUserId()%> on <%= comments.get(i).getCreatedAt()%>
                                </div>
                            </div>

                        </div>
                    </div>

                    <%
                            }
                        }

                    %>

                </div>

            </div>
            <div class="col-xl-1 col-lg-1 col-md-12 col-sm-12"></div>
        </div>




    </main><!-- End #main -->

    <jsp:include page="footer.jsp" flush="true" />

    <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
            class="bi bi-arrow-up-short"></i></a>

    <!-- Vendor JS Files -->
    <script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
    <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="assets/vendor/chart.js/chart.umd.js"></script>
    <script src="assets/vendor/echarts/echarts.min.js"></script>
    <script src="assets/vendor/quill/quill.min.js"></script>
    <script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
    <script src="assets/vendor/tinymce/tinymce.min.js"></script>
    <script src="assets/vendor/php-email-form/validate.js"></script>

    <!-- Template Main JS File -->
    <script src="assets/js/main.js"></script>

</body>

</html>