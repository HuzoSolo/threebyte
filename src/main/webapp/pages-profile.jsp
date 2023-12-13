
<%@page import="Dao.UserDaoImp"%>
<%@page import="Models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="sessionBean" class="SessionAndCookie.UseBeanSession" scope="session"/>


             
<%

    if (sessionBean.getUsername() == null) {
        response.sendRedirect("pages-login.jsp");
    }

    User usr = new User("", "", "");
    UserDaoImp usrDao = new UserDaoImp();

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
         <jsp:include page="cookie-control.jsp" flush="true" />

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

                                            <%

                                                if (sessionBean.getRank() == User.Rank.GIGABYTE) {

                                            %>
                                            <li class="nav-item">
                                                <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-settings">Authorization</button>
                                            </li>

                                            <%                                                }
                                            %>

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
                                                <form class="needs-validation" action="edit-profile.jsp" method="post" novalidate>
                                                    <div class="row mb-3">
                                                        <label for="profileImage" class="col-md-4 col-lg-3 col-form-label">Profile Image</label>
                                                        <div class="col-md-8 col-lg-9">
                                                            <img src="<%= sessionBean.getProfilePicture()%>" alt="Profile">
                                                            <div class="pt-2">
                                                                <label for="profilePicture" class="col-md-4 col-lg-3 col-form-label">Profile Picture Link</label>
                                                                <div class="col-md-8 col-lg-9">
                                                                    <input name="picture" type="text" class="form-control" id="picture" value="<%= sessionBean.getProfilePicture()%>" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="row mb-3">
                                                        <label for="username" class="col-md-4 col-lg-3 col-form-label">Username</label>
                                                        <div class="col-md-8 col-lg-9">
                                                            <input name="username" type="text" class="form-control" id="username" value="<%= sessionBean.getUsername()%>" disabled="true" required>
                                                        </div>
                                                    </div>

                                                    <div class="row mb-3">
                                                        <label for="email" class="col-md-4 col-lg-3 col-form-label">E-mail</label>
                                                        <div class="col-md-8 col-lg-9">
                                                            <input name="email" type="text" class="form-control" id="email" value="<%= sessionBean.getEmail()%>" required>
                                                        </div>
                                                    </div>

                                                    <div class="text-center">
                                                        <button type="submit" class="btn btn-ubuntu">Save Changes</button>
                                                    </div>
                                                </form><!-- End Profile Edit Form -->

                                            </div>

                                            <%
                                                if (sessionBean.getRank() == User.Rank.GIGABYTE) {
                                            %>
                                            <div class="tab-pane fade profile-edit pt-3" id="profile-settings">
                                                
                                                <!-- role Edit Form -->
                                                <form class="needs-validation" action="auth.jsp" method="post" novalidate>
                                                    
                                                    <div class="row mb-3">
                                                        <label for="username" class="col-md-4 col-lg-3 col-form-label">Username</label>
                                                        <div class="col-md-8 col-lg-9">
                                                            <input name="username" type="text" class="form-control" id="username" required>
                                                        </div>
                                                    </div>

                                                    <div class="row mb-3">
                                                        <label for="role" class="col-md-4 col-lg-3 col-form-label">Roles</label>
                                                        <div class="col-md-8 col-lg-9">
                                                            <select name="role" class="form-select" id="role" required>
                                                            <option selected disabled value="">Choose...</option>
                                                            <option value="0">BIT</option>
                                                            <option value="1">BYTE</option>
                                                            <option value="2">KILOBYTE</option>
                                                            <option value="3">MEGABYTE</option>
                                                            <option value="4">GIGABYTE</option>
                                                        </select>
                                                        </div>
                                                    </div>

                                                    <div class="text-center">
                                                        <button type="submit" class="btn btn-ubuntu">Save Changes</button>
                                                    </div>
                                                </form><!-- End role Edit Form -->
                                                
                                   

                                            </div>
                                            <%
                                                }
                                            %>

                                            <div class="tab-pane fade pt-3" id="profile-change-password">
                                                <!-- Change Password Form -->
                                                <form class="needs-validation" action="reset-password.jsp" method="post" novalidate>

                                                    <div class="row mb-3">
                                                        <label for="currentPassword" class="col-md-4 col-lg-3 col-form-label">Current Password</label>
                                                        <div class="col-md-8 col-lg-9">
                                                            <input name="password" type="password" class="form-control" id="currentPassword" required>
                                                        </div>
                                                    </div>

                                                    <div class="row mb-3">
                                                        <label for="newPassword" class="col-md-4 col-lg-3 col-form-label">New Password</label>
                                                        <div class="col-md-8 col-lg-9">
                                                            <input name="newpassword" type="password" class="form-control" id="newPassword" required>
                                                        </div>
                                                    </div>

                                                    <div class="row mb-3">
                                                        <label for="renewPassword" class="col-md-4 col-lg-3 col-form-label">Re-enter New Password</label>
                                                        <div class="col-md-8 col-lg-9">
                                                            <input name="renewpassword" type="password" class="form-control" id="renewPassword" required>
                                                        </div>
                                                    </div>

                                                    <div class="text-center">
                                                        <button type="submit" class="btn btn-ubuntu" id="changePasswordBtn" disabled>Change Password</button>
                                                    </div>
                                                </form><!-- End Change Password Form -->

                                                <script>

                                                    // Real-time validation
                                                    document.getElementById('newPassword').addEventListener('input', function () {
                                                        validateRealTime();
                                                    });

                                                    document.getElementById('renewPassword').addEventListener('input', function () {
                                                        validateRealTime();
                                                    });

                                                    function validateRealTime() {
                                                        var newPassword = document.getElementById('newPassword').value;
                                                        var renewPassword = document.getElementById('renewPassword').value;
                                                        var changePasswordBtn = document.getElementById('changePasswordBtn');

                                                        if (newPassword === renewPassword) {
                                                            changePasswordBtn.disabled = false;
                                                        } else {
                                                            changePasswordBtn.disabled = true;
                                                        }
                                                    }
                                                </script>


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