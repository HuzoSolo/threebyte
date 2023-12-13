<%-- 
    Document   : add-user
    Created on : Dec 5, 2023, 11:04:29 PM
    Author     : muhuz
--%>

<%@page import="Models.User.Rank"%>
<%@page import="Dao.UserDaoImp"%>
<%@page import="Models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Wait What?!</title>
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
    </head>
    <body>

        <main class="p-5">
        <%

            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
                UserDaoImp usrDaoT = new UserDaoImp();

            if (username.equals("") || email.equals("") || password.equals("")) {

        %>

        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            <i class="bi bi-exclamation-diamond fs-5 pe-1"></i> <strong class="pe-1"> Error!</strong> You've sent null input! Are u ok?
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>

        <a class="btn btn-ubuntu" href="pages-register.jsp">Back to Register</a>

        <%        } else if (!email.contains("@") || username.contains(" ") || username.contains("<") || username.contains(">") || username.contains("\\")) {

        %>

        <div class="alert alert-warning alert-dismissible fade show" role="alert">
            <i class="bi bi-exclamation-diamond fs-5 pe-1"></i> <strong class="pe-1"> Error!</strong> Email must contain '@' symbol and you cannot use special symbols or space in username!
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>

        <a class="btn btn-ubuntu" href="pages-register.jsp">Back to Register</a>

        <%        } else if (username.length() < 6 || username.length() > 36) {

        %>

        <div class="alert alert-warning alert-dismissible fade show" role="alert">
            <i class="bi bi-exclamation-diamond fs-5 pe-1"></i> <strong class="pe-1"> Error!</strong> The length of the username must be minimum 6 and maximum 32 characters.
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>

        <a class="btn btn-ubuntu" href="pages-register.jsp">Back to Register</a>

        <%        } else if (email.length() > 60) {

        %>

        <div class="alert alert-warning alert-dismissible fade show" role="alert">
            <i class="bi bi-exclamation-diamond fs-5 pe-1"></i> <strong class="pe-1"> Wow!</strong> is that mail address even legit?!
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>

        <a class="btn btn-ubuntu" href="pages-register.jsp">Back to Register</a>

        <%        } else if (password.length() < 8 || password.length() > 16) {

        %>

        <div class="alert alert-warning alert-dismissible fade show" role="alert">
            <i class="bi bi-exclamation-diamond fs-5 pe-1"></i> <strong class="pe-1"> Error!</strong> The length of the password must be minimum 8 and maximum 16 characters.
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>

        <a class="btn btn-ubuntu" href="pages-register.jsp">Back to Register</a>

        <%                
            }else if(usrDaoT.usernameExist(username)){//isUsernameExists
                    
                %>

        <div class="alert alert-warning alert-dismissible fade show" role="alert">
            <i class="bi bi-exclamation-diamond fs-5 pe-1"></i> <strong class="pe-1"> Error!</strong> This username is already taken better luck next time pal :')
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>

        <a class="btn btn-ubuntu" href="pages-register.jsp">Back to Register</a>

        <%
                    
                } else if(false){//isEmailExists

                    %>

        <div class="alert alert-warning alert-dismissible fade show" role="alert">
            <i class="bi bi-exclamation-diamond fs-5 pe-1"></i> <strong class="pe-1"> Error!</strong> This Email is already taken better luck next time pal :')
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>

        <a class="btn btn-ubuntu" href="pages-register.jsp">Back to Register</a>

        <%

                } else {

                User usr = new User("", "", "");
                UserDaoImp usrDao = new UserDaoImp();
                
      
                usr.setUsername(username);
                usr.setEmail(email);
                usr.setPasswordMd5(password);
                usr.setProfilePicture("https://i.hizliresim.com/qvwey1j.jpg");
                usr.setRank(Rank.BIT);

                usrDao.addUser(usr);

                response.sendRedirect("pages-login.jsp");
            }

        %>
        </main>
        
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
