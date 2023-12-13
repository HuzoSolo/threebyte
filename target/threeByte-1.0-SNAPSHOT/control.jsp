<%-- 
    Document   : control
    Created on : Dec 4, 2023, 2:31:29 PM
    Author     : muhuz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <script type="text/javascript">
            window.onload = function () {
                var hiddenInput = document.createElement("input");
                hiddenInput.type = "hidden";
                hiddenInput.name = "jsEnabled";
                hiddenInput.value = "true";

                var hiddenInput2 = document.createElement("input");
                hiddenInput2.type = "hidden";
                hiddenInput2.name = "url";
                var currentURL = window.location.href;
                hiddenInput2.value = currentURL;

                var form = document.createElement("form");
                form.method = "post";
                form.action = "check_js_enabled.jsp";
                form.style.display = "none";
                form.appendChild(hiddenInput, hiddenInput2);
                document.body.appendChild(form);

                form.submit();
            };
        </script>
    </body>
</html>
-->