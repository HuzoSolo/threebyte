<%-- 
    Document   : topicTable
    Created on : Dec 2, 2023, 8:50:32 PM
    Author     : muhuz
--%>
<%@page import="Dao.UserDaoImp"%>
<%@page import="Models.User"%>
<%@page import="Dao.TopicDaoImp"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Models.Topic"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>


        <div class="row">
            <div class="col-xl-2 col-lg-2 col-md-1 col-sm-12"></div>
            <div class="col-xl-8 col-lg-8 col-md-8 col-sm-12">


                <table class="table table-hover">
                    <thead>
                        <tr>
                            <!--table controls-->
                            <td scope="col">

                                <div class="row pt-2">

                                    <div class="col-sm-12 col-md-6 col-lg-6 col-xl-6">
                                        <div class="btn-group" role="group" aria-label="Basic example">
                                            <!--filter-->
                                            <button type="button" class="btn btn-light btn-lg">
                                                <i class="bi bi-filter"></i>
                                            </button>
                                            <!--sort-->
                                            <button type="button" class="btn btn-light btn-lg">
                                                <i class="bi bi-sort-down-alt"></i>
                                            </button>
                                        </div>
                                    </div>

                                    <div class="col-sm-12 col-md-6 col-lg-6 col-xl-6">
                                        <!-- Pagination -->
                                        <ul class="pagination justify-content-end mobile">
                                            <li class="page-item"><a class="page-link" href="#"> New </a></li>
                                            <li class="page-item"><a class="page-link" href="#"> Week </a></li>
                                            <li class="page-item"><a class="page-link" href="#"> Month </a></li>
                                        </ul>
                                    </div>

                                </div>






                            </td>
                        </tr>
                    </thead>
                    <tbody>

                        <%

                            ArrayList<Topic> topics = new ArrayList<Topic>();

                            TopicDaoImp TopicDao = new TopicDaoImp();

                            topics = TopicDao.getAllTopics();

                            for (int i = topics.size()-1; i >= 0; i--) {
                                User usrTpc = new User("", "", "");
                                UserDaoImp usrDaoTpc = new UserDaoImp();
                                usrTpc = usrDaoTpc.getUserbyId(topics.get(i).getUserId());
                        %>

                        <tr onclick="redirectToSpecificLink('topic.jsp?id=<%= topics.get(i).getId()%>')">

                            <th scope="row">
                                <div class="row" style="height: 6rem;">
                                    <!--card tags-->
                                    <div class="col-sm-12 col-xl-1 dad">
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col">
                                                    <p class="card-text"> <span
                                                            class="badge bg-primary-light">#Tag</span>
                                                    </p>
                                                </div>
                                                <div class="col">
                                                    <p class="card-text"> <span
                                                            class="badge bg-primary-light">#Tag</span>
                                                    </p>
                                                </div>
                                                <div class="col">
                                                    <p class="card-text"> <span
                                                            class="badge bg-primary-light">#Tag</span>
                                                    </p>
                                                </div>
                                                <div class="col">
                                                    <p class="card-text"> <span
                                                            class="badge bg-primary-light">#Tag</span>
                                                    </p>
                                                </div>


                                            </div>
                                        </div>
                                    </div>
                                    <!--card info-->
                                    <div class="col-sm-12 col-xl-12 ps-3">
                                        <div class="card-body">
                                            <h6 class="card-title"><% out.println(topics.get(i).getTitle()); %></h6>
                                            <div class="row">
                                                <div class="col">
                                                    <p class="card-text ps-4">by <% out.println(usrTpc.getUsername()); %></p>
                                                </div>
                                                <div class="col">
                                                    <p class="card-text text-end"><% out.println(topics.get(i).getCreatedAt());%></p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </th>
                        </tr>


                        <%
                            }
                        %>

                    </tbody>
                </table>

            </div>
            <div class="col-xl-2 col-lg-2 col-md-1 col-sm-12"></div>
        </div>

        <style>
            .card {
                border: none;
                border-radius: 0.25rem;
                box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.1);
                transition: transform 0.3s ease-in-out;
            }

            .card-body {
                padding: 0.75rem;
            }

            .card-title {
                color: #3a3b3c;
                font-size: 0.875rem;
                font-weight: 500;
            }

            .card-text {
                color: #8d8e90;
                font-size: 0.75rem;
                font-weight: 400;
            }
        </style>

        <script>
            function redirectToSpecificLink(link) {

                window.location.href = link;
            }
        </script>


    </body>
</html>
