<%-- 
    Document   : topic
    Created on : Dec 2, 2023, 11:11:37 PM
    Author     : muhuz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="sessionBean" class="SessionAndCookie.UseBeanSession" scope="session"/>



              <jsp:include page="cookie-control.jsp" flush="true" />
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

        <title>Write Your Topic!</title>
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

            <div class="card p-5">

                <div class="card-title">
                    <h3>Topic Editor</h3>
                </div>


                <form class="p-4 needs-validation" action="add-topic.jsp" method="post" novalidate>

                    <div class="ps-2">
                        <label class="fw-bold" for="floatingInput">Title</label><br>
                        <span class="text-muted"><small>Be specific and imagine you’re asking a question to another
                                person</small></span>
                        <div class="input-group mb-3">
                            <input type="text" name="title" class="form-control" placeholder="Topic Title" required> 
                            <div class="invalid-feedback">
                                Are you kidding? a topic must have title!
                            </div>
                        </div>
                    </div>

                    <div class="ps-2">
                        <label class="fw-bold" for="floatingInput">Body</label><br>
                        <span class="text-muted"><small>Include all the information someone would need to answer your
                                question</small></span>
                        <div class="input-group mb-3">
                            <textarea class="form-control" name="content" id="exampleFormControlTextarea1" rows="3"
                                      placeholder="Tell us about your ideas!" required></textarea>
                            <div class="invalid-feedback">
                                All good topics must have content!
                            </div>
                        </div>
                    </div>

                    <button type="submit" class="btn btn-ubuntu mt-3"><i class="bi bi-chat-fill"></i> Publish!</button>
                </form>

            </div>
            <!--form-->

            <!-- Modal -->
            <div class="modal fade" id="disclaimer" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Modal Başlık</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            Modal içeriği buraya gelecek.
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Kapat</button>
                            <button type="button" class="btn btn-primary">Kaydet</button>
                        </div>
                    </div>
                </div>
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