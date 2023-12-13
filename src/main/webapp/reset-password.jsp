<%-- 
    Document   : reset-oassword
    Created on : Dec 3, 2023, 3:38:15 PM
    Author     : muhuz
--%>

<%@page import="Dao.UserDaoImp"%>
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
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Password Operation</title>
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

        <div class="container p-5">
            <%                
                String currentPassword = request.getParameter("password");
                String newPassword = request.getParameter("newpassword");
                String renewPassword = request.getParameter("renewpassword");
                
                out.println(currentPassword +" "+newPassword +" "+renewPassword);

                if (newPassword.length() >= 8 && newPassword.length() <= 16) {
                
                    if (newPassword.equals(renewPassword)) {

                        UserDaoImp usrDao = new UserDaoImp();
                        boolean isDone = usrDao.updatePassword(sessionBean.getId(), currentPassword, newPassword);

                        if (isDone) {
            %>

            <div class="alert alert-success alert-dismissible fade show mt-3" role="alert">
                <i class="bi bi-check-all fs-5 pe-1"></i> <strong class="pe-1"> Done!</strong> operation successful!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>

            <%
                        session.invalidate();

                        out.println("<a class='btn btn-ubuntu btn-lg' href='pages-login.jsp'> <i class='bi bi-input-cursor pe-2'></i>Return to Login page!</a>");
                    }
                }
                //sql e kaydet newPassord
            } else {
                if (currentPassword != null) {

            %>

            <div class="alert alert-danger alert-dismissible fade show mt-3" role="alert">
                <i class="bi bi-exclamation-diamond fs-5 pe-1"></i> <strong class="pe-1"> Error!</strong> operation failed! please try again with caution...
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>

            <%                        out.println("<a class='btn btn-ubuntu btn-lg' href='pages-profile.jsp'> <i class='bi bi-person-fill pe-2'></i>Return to Profile page!</a>");
                    }

                }


            %>
        </div>

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
