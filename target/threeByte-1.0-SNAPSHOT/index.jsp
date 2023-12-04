<%@page import="Models.User"%>
<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<<<<<<< Updated upstream
<jsp:useBean id="usebean" class="SessionAndCookie.UseBeanSession" scope="session"/>
<%@ page import="javax.servlet.http.Cookie"%>
<%@page import="Dao.UserDaoImp" %>
=======
<jsp:useBean id="sessionBean" class="SessionAndCookie.UseBeanSession" scope="session"/>
>>>>>>> Stashed changes

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

<<<<<<< Updated upstream
        <title>ThreeByte Forum</title>
=======
        <title>Welcome <% if (sessionBean.getUsername() != null) {
                out.println(sessionBean.getUsername());
            } else {
                out.println("please Login!");
            }%>!</title>
>>>>>>> Stashed changes
        <meta content="" name="description">
        <meta content="" name="keywords">

        <!-- Favicons -->
        <link href="assets/img/favicon.png" rel="icon">
        <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.gstatic.com" rel="preconnect">
<<<<<<< Updated upstream
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

        <!-- Vendor CSS Files -->
        <link href=" assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href=" assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href=" assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href=" assets/vendor/quill/quill.snow.css" rel="stylesheet">
        <link href=" assets/vendor/quill/quill.bubble.css" rel="stylesheet">
        <link href=" assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href=" assets/vendor/simple-datatables/style.css" rel="stylesheet">

        <!-- Template Main CSS File -->
        <link href=" assets/css/style.css" rel="stylesheet">
=======
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


>>>>>>> Stashed changes

    </head>

    <body>

<<<<<<< Updated upstream
        <%
            //User usr = new User();
            //usr.setUsername("furki");
            //Cookie usernameCookie = new Cookie("kullaniciAdi", usr.getUsername());
            //usernameCookie.setMaxAge(720 * 3600); // Çerezin ömrü saniye cinsinden, burada 1 saat * 30 gün
            //response.addCookie(usernameCookie);

            //usebean.setId(11);
            //usebean.SetName("artun");
            //usebean.setRole("Admin");
            //usebean.addToSessions("Session1");
            //out.println("Session time:"+ usebean.showAge());
            User newuser = new User("art","art@gmail.com","123123");
            
            UserDaoImp  usrdao = new UserDaoImp();
            
           
            out.println(usrdao.getUser(123).getEmail());

            
        %>
=======
        <jsp:include page="navbar.jsp" flush="true" />


        <main class="p-5">

            <div class="pagetitle">
                <h1>Hottest Topics 🔥</h1>
                <nav>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                        <li class="breadcrumb-item active">Entries</li>
                    </ol>
                </nav>
            </div><!-- End Page Title -->


            <%

                if (sessionBean.getUsername() == null) {

                    out.println("<div class='row mt-3 mb-3 p-2'> <div class='col-12 '> <div style='display: flex; justify-content: flex-end;'><a class='btn btn-secondary disabled' href='write-topic.jsp' ><i class='bi bi-feather pe-1'></i>Login for Write a topic!</a></div> </div> </div>");

                }

                if (sessionBean.getUsername() != null) {

                    out.println("<div class='row mt-3 mb-3 p-2'> <div class='col-12 '> <div style='display: flex; justify-content: flex-end;'><a class='btn btn-ubuntu' href='write-topic.jsp'><i class='bi bi-feather pe-1'></i> Write a topic!</a></div> </div> </div>");
                }

            %>
>>>>>>> Stashed changes




<<<<<<< Updated upstream
        <!-- Vendor JS Files -->
        <script src=" assets/vendor/apexcharts/apexcharts.min.js"></script>
        <script src=" assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src=" assets/vendor/chart.js/chart.umd.js"></script>
        <script src=" assets/vendor/echarts/echarts.min.js"></script>
        <script src=" assets/vendor/quill/quill.min.js"></script>
        <script src=" assets/vendor/simple-datatables/simple-datatables.js"></script>
        <script src=" assets/vendor/tinymce/tinymce.min.js"></script>
        <script src=" assets/vendor/php-email-form/validate.js"></script>
=======
            <jsp:include page="topicTable.jsp" flush="true" />


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


>>>>>>> Stashed changes

        <!-- Template Main JS File -->
        <script src=" assets/js/main.js"></script>

    </body>

</html>