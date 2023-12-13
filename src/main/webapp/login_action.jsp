<%-- 
    Document   : login_action
    Created on : Dec 4, 2023, 4:14:06 PM
    Author     : muhuz
--%>

<%@page import="SessionAndCookie.UseBeanSession"%>
<%@page import="Models.User"%>
<%@page import="Dao.UserDaoImp"%>
<%@page import="Dao.Hash"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="sessionBean" class="SessionAndCookie.UseBeanSession" scope="session"/>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>ERROR!</title>
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

        <noscript>
        
        <div class="noJs text-center">
            
            <div class="container h1"><i class="bi bi-exclamation-octagon"></i> Javascript is disabled. We advise you to enable it. otherwise your experience with this site could be challenging!</div>
        </div>
        
        </noscript>

        <main class="p-5">

            <%  

                if (request.getParameter("username").isBlank() && request.getParameter("password").isBlank()) {

            %>

            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <i class="bi bi-exclamation-diamond fs-5 pe-1"></i> <strong class="pe-1"> Error!</strong> You've sent null input! Are u ok?
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>

            <a class="btn btn-ubuntu" href="pages-login.jsp">Back to Login</a>

            <%            } else {

                Hash hs = new Hash();
                UserDaoImp usrDao = new UserDaoImp();
                User sql_user = new User("", "", "");

                sql_user = usrDao.getUserbyName(request.getParameter("username"));
                ///

                //burada sql connection ile kullanıcının şifresini kontrol edeceğiz.
                if (sql_user != null && sql_user.getUsername().equals(request.getParameter("username")) && sql_user.getPassword().equals(hs.md5(request.getParameter("password")))) {

                    sessionBean.setId(sql_user.getId());
                    sessionBean.setUsername(sql_user.getUsername());
                    sessionBean.setPassword(sql_user.getPassword());
                    out.println(sessionBean.getPassword());
                    sessionBean.setEmail(sql_user.getEmail());
                    sessionBean.setRank(sql_user.getRank());
                    sessionBean.setProfilePicture(sql_user.getProfilePicture());
                    sessionBean.setCreatedAt(sql_user.getCreatedAt());
                    sessionBean.setUpdatedAt(sql_user.getUpdatedAt());
                    sessionBean.setLastLogin(sql_user.getLastLogin());

                    Cookie[] cookies = null;

                    Cookie userNameCookie = new Cookie("username", "");
                    Cookie passwordCookie = new Cookie("password", "");

                    userNameCookie.setMaxAge(60 * 60 * 24);
                    passwordCookie.setMaxAge(60 * 60 * 24);

                    response.addCookie(userNameCookie);
                    response.addCookie(passwordCookie);

                    cookies = request.getCookies();
                    //cookie işlemleri (beni hatırla varsa ayarlanacak)
                    userNameCookie.setValue(sessionBean.getUsername());
                    passwordCookie.setValue(sessionBean.getPassword());

                    // UseBean Session'a maximum age atamak ve gerektiğinde session sonlandırabilmek için bir adet http session oluşturmalıyız
                    // oluşturacağımız http sessiona bir adet de doğrulama amaçlı attribute atıyoruz bu sayede attribute'un null olma durumuna
                    // göre usebean session'un da varlık durumunu kontrol edebiliriz
                    UseBeanSession bean = (UseBeanSession) session.getAttribute("bean");
                    session.setMaxInactiveInterval(60 * 10);

                    if (bean == null) {
                        bean = new UseBeanSession();
                        session.setAttribute("bean", bean);
                    }

                    response.sendRedirect("index.jsp");

                } else {

                    if (request.getParameter("username") != null && request.getParameter("password") != null) {
            %>

            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <i class="bi bi-exclamation-diamond fs-5 pe-1"></i> <strong class="pe-1"> Error!</strong> Your username or password is wrong.
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>

            <a class="btn btn-ubuntu" href="pages-login.jsp">Back to Login</a>

            <%
                        }
                    }
                    ///
                }


            %>


        </main><!-- End #main -->



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




