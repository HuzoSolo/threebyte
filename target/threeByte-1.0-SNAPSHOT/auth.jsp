<%-- 
    Document   : auth
    Created on : Dec 10, 2023, 2:04:26 AM
    Author     : muhuz
--%>

<%@page import="Models.User"%>
<%@page import="Dao.UserDaoImp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="sessionBean" class="SessionAndCookie.UseBeanSession" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Authorization Process</title>

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
        <main class="p-5">
            <%
                String username = request.getParameter("username");
                String role = request.getParameter("role");
                boolean operation = false;

                User usr = new User("", "", "");
                UserDaoImp usrDao = new UserDaoImp();

                if (username.isBlank() && role.isBlank()) {

            %>

            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                <i class="bi bi-exclamation-diamond fs-5 pe-1"></i> <strong class="pe-1"> Null!</strong> Null input! really?
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>

            <a class="btn btn-ubuntu" href="pages-profile.jsp">Back to profile page</a>

            <%            
                } else {

                usr = usrDao.getUserbyName(username);

                if (usr == null) {

            %>

            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                <i class="bi bi-exclamation-diamond fs-5 pe-1"></i> <strong class="pe-1"> Not found!</strong> User doesn't exists. are you sure what you have wrote is correct?
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>

            <a class="btn btn-ubuntu" href="pages-profile.jsp">Back to profile page</a>

            <%            
                } else {

                switch (Integer.parseInt(role)) {
                    case 0:
                        operation = usrDao.updateRank(usr.getId(), User.Rank.BIT);
                        break;

                    case 1:
                        operation = usrDao.updateRank(usr.getId(), User.Rank.BYTE);
                        break;

                    case 2:
                        operation = usrDao.updateRank(usr.getId(), User.Rank.KILOBYTE);
                        break;

                    case 3:
                        operation = usrDao.updateRank(usr.getId(), User.Rank.MEGABYTE);
                        break;

                    case 4:
                        operation = usrDao.updateRank(usr.getId(), User.Rank.GIGABYTE);
                        break;

                }

                if (operation) {

            %>

            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                <i class="bi bi-exclamation-diamond fs-5 pe-1"></i> <strong class="pe-1"> Operation is successful!</strong> <%= username%>'s rank has been updated...
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>

            <a class="btn btn-ubuntu" href="pages-profile.jsp">Back to profile page</a>

            <%
                        }
                    }

                }
            %>
        </main>

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
