
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="sessionBean" class="SessionAndCookie.UseBeanSession" scope="session"/>



<%

    if (sessionBean.getUsername() == null) {
        response.sendRedirect("pages-login.jsp");
    }

%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title><%= sessionBean.getUsername()%>'s Profile</title>
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

        <main id="main" class="main">

            <div class="row">
                <div class="col-xl-1 col-lg-1 col-md-12 col-sm-12"></div>
                <div class="col-xl-10 col-lg-10 col-md-10 col-sm-12">


                    <section class="section profile">
                        <div class="row">

                            <div class="col-xl-12">

                                <div class="card">
                                    <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">

                                        <img src="<%= sessionBean.getProfilePicture()%>" alt="Profile" class="rounded-circle">
                                        <h2><%= sessionBean.getUsername()%></h2>
                                        <h3><%= sessionBean.getRank()%></h3>
                                        <!--
                                            <div class="social-links mt-2">
                                            <a href="#twitter_profile_link" class="twitter"><i class="bi bi-twitter"></i></a>
                                            <a href="#facebook_profile_link" class="facebook"><i class="bi bi-facebook"></i></a>
                                            <a href="#instagram_profile_link#" class="instagram"><i class="bi bi-instagram"></i></a>
                                            <a href="#likedin_profile_link" class="linkedin"><i class="bi bi-linkedin"></i></a>
                                        </div>
                                        -->
                                    </div>
                                </div>

                                <div class="card">
                                    <div class="card-body pt-3">
                                        <!-- Bordered Tabs -->
                                        <ul class="nav nav-tabs nav-tabs-bordered">

                                            <li class="nav-item">
                                                <button class="nav-link active" data-bs-toggle="tab"
                                                        data-bs-target="#profile-overview">Overview</button>
                                            </li>

                                            <li class="nav-item">
                                                <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-edit">Edit Profile</button>
                                            </li>

                                            <li class="nav-item">
                                                <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-settings">Settings</button>
                                            </li>

                                            <li class="nav-item">
                                                <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-change-password">Change
                                                    Password</button>
                                            </li>

                                        </ul>
                                        <div class="tab-content pt-2">

                                            <div class="tab-pane fade show active profile-overview" id="profile-overview">

                                                <h5 class="card-title">Profile Details</h5>

                                                <div class="row">
                                                    <div class="col-lg-3 col-md-4 label ">Username</div>
                                                    <div class="col-lg-9 col-md-8"><%= sessionBean.getUsername()%></div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-lg-3 col-md-4 label">E-mail</div>
                                                    <div class="col-lg-9 col-md-8"><%= sessionBean.getEmail()%></div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-lg-3 col-md-4 label">Rank</div>
                                                    <div class="col-lg-9 col-md-8"><%= sessionBean.getRank()%></div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-lg-3 col-md-4 label">Created at</div>
                                                    <div class="col-lg-9 col-md-8"><%= sessionBean.getCreatedAt()%></div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-lg-3 col-md-4 label">Updated at</div>
                                                    <div class="col-lg-9 col-md-8"><%= sessionBean.getUpdatedAt()%></div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-lg-3 col-md-4 label">Last Login</div>
                                                    <div class="col-lg-9 col-md-8"><%= sessionBean.getLastLogin()%></div>
                                                </div>

                                            </div>

                                            <div class="tab-pane fade profile-edit pt-3" id="profile-edit">

                                                <!-- Profile Edit Form -->
                                                <form action="edit-profile.jsp" method="post">
                                                    <div class="row mb-3">
                                                        <label for="profileImage" class="col-md-4 col-lg-3 col-form-label">Profile Image</label>
                                                        <div class="col-md-8 col-lg-9">
                                                            <img src="<%= sessionBean.getProfilePicture()%>" alt="Profile">
                                                            <div class="pt-2">
                                                                <label for="profilePicture" class="col-md-4 col-lg-3 col-form-label">Profile Picture Link</label>
                                                                <div class="col-md-8 col-lg-9">
                                                                    <input name="picture" type="text" class="form-control" id="picture" value="<%= sessionBean.getProfilePicture()%>">
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="row mb-3">
                                                        <label for="username" class="col-md-4 col-lg-3 col-form-label">Username</label>
                                                        <div class="col-md-8 col-lg-9">
                                                            <input name="username" type="text" class="form-control" id="username" value="<%= sessionBean.getUsername()%>">
                                                        </div>
                                                    </div>

                                                    <div class="row mb-3">
                                                        <label for="email" class="col-md-4 col-lg-3 col-form-label">E-mail</label>
                                                        <div class="col-md-8 col-lg-9">
                                                            <input name="email" type="text" class="form-control" id="email" value="<%= sessionBean.getEmail()%>">
                                                        </div>
                                                    </div>

                                                    <!--
                                                <div class="row mb-3">
                                                    <label for="Twitter" class="col-md-4 col-lg-3 col-form-label">Twitter Profile</label>
                                                    <div class="col-md-8 col-lg-9">
                                                        <input name="twitter" type="text" class="form-control" id="Twitter"
                                                               value="https://twitter.com/#">
                                                    </div>
                                                </div>

                                                <div class="row mb-3">
                                                    <label for="Facebook" class="col-md-4 col-lg-3 col-form-label">Facebook Profile</label>
                                                    <div class="col-md-8 col-lg-9">
                                                        <input name="facebook" type="text" class="form-control" id="Facebook"
                                                               value="https://facebook.com/#">
                                                    </div>
                                                </div>

                                                <div class="row mb-3">
                                                    <label for="Instagram" class="col-md-4 col-lg-3 col-form-label">Instagram Profile</label>
                                                    <div class="col-md-8 col-lg-9">
                                                        <input name="instagram" type="text" class="form-control" id="Instagram"
                                                               value="https://instagram.com/#">
                                                    </div>
                                                </div>

                                                <div class="row mb-3">
                                                    <label for="Linkedin" class="col-md-4 col-lg-3 col-form-label">Linkedin Profile</label>
                                                    <div class="col-md-8 col-lg-9">
                                                        <input name="linkedin" type="text" class="form-control" id="Linkedin"
                                                               value="https://linkedin.com/#">
                                                    </div>
                                                </div>
                                                    -->

                                                    <div class="text-center">
                                                        <button type="submit" class="btn btn-ubuntu">Save Changes</button>
                                                    </div>
                                                </form><!-- End Profile Edit Form -->

                                                <%

                                                %>

                                            </div>

                                            <div class="tab-pane fade pt-3" id="profile-settings">

                                                <!-- Settings Form -->
                                                <form>

                                                    <h1 class="text-muted text-center">Empty Tab ಥ_ಥ</h1>

                                                </form><!-- End settings Form -->

                                            </div>

                                            <div class="tab-pane fade pt-3" id="profile-change-password">
                                                <!-- Change Password Form -->
                                                <form action="reset-password.jsp" method="post">

                                                    <div class="row mb-3">
                                                        <label for="currentPassword" class="col-md-4 col-lg-3 col-form-label">Current Password</label>
                                                        <div class="col-md-8 col-lg-9">
                                                            <input name="password" type="password" class="form-control" id="currentPassword">
                                                        </div>
                                                    </div>

                                                    <div class="row mb-3">
                                                        <label for="newPassword" class="col-md-4 col-lg-3 col-form-label">New Password</label>
                                                        <div class="col-md-8 col-lg-9">
                                                            <input name="newpassword" type="password" class="form-control" id="newPassword">
                                                        </div>
                                                    </div>

                                                    <div class="row mb-3">
                                                        <label for="renewPassword" class="col-md-4 col-lg-3 col-form-label">Re-enter New Password</label>
                                                        <div class="col-md-8 col-lg-9">
                                                            <input name="renewpassword" type="password" class="form-control" id="renewPassword">
                                                        </div>
                                                    </div>

                                                    <div class="text-center">
                                                        <button type="submit" class="btn btn-ubuntu">Change Password</button>
                                                    </div>
                                                </form><!-- End Change Password Form -->

                                                <%                                                    String old = "123456";

                                                    String currentPassword = request.getParameter("password");
                                                    String newPassword = request.getParameter("newpassword");

                                                    if (old.equals(currentPassword)) {

                                                        if (currentPassword != null) {

                                                %>

                                                <div class="alert alert-success alert-dismissible fade show mt-3" role="alert">
                                                    <i class="bi bi-check-all fs-5 pe-1"></i> <strong class="pe-1"> Done!</strong> operation successful!
                                                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                                                </div>

                                                <%                                                            }
                                                    //sql e kaydet newPassord
                                                } else {
                                                    if (currentPassword != null) {

                                                %>

                                                <div class="alert alert-danger alert-dismissible fade show mt-3" role="alert">
                                                    <i class="bi bi-exclamation-diamond fs-5 pe-1"></i> <strong class="pe-1"> Error!</strong> Wrong password! are you sure about you remember old one?
                                                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                                                </div>

                                                <%                                                        }
                                                    }


                                                %>

                                            </div>

                                        </div><!-- End Bordered Tabs -->

                                    </div>
                                </div>

                            </div>
                        </div>
                    </section>


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