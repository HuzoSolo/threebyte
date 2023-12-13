<%-- 
    Document   : cookie-control.jsp
    Created on : 10 Ara 2023, 02:28:11
    Author     : artun
--%>

<%@page import="Models.User"%>
<%@page import="Dao.UserDaoImp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="sessionBean" class="SessionAndCookie.UseBeanSession" scope="session"/>
<!DOCTYPE html>
<html>

<body>
    <!-- BEN YAZDIM -->
        <%
            Cookie[] cookies_index = null;
            cookies_index = request.getCookies();
            String cookieUsername = null;
            String cookiePassword = null;
            int i = 0;
            if (cookies_index != null && cookies_index.length >= 3) {

                for (Cookie cookie : cookies_index) {
                    if ("username".equals(cookie.getName())) {
                        cookieUsername = cookie.getValue();
                        i++;
                    }else if ("password".equals(cookie.getName())){
                        cookiePassword = cookie.getValue();
                        i++;
                    }
                    if(i==2) break;
                    
                }

                
                UserDaoImp daousr = new UserDaoImp();
                User controlUser = new User("", "", "");
                controlUser = daousr.getUserbyName(cookieUsername) != null ? daousr.getUserbyName(cookieUsername) : null;
                if (controlUser != null && cookiePassword.contains(controlUser.getPassword())) {
                    sessionBean.setId(controlUser.getId());
                    sessionBean.setUsername(controlUser.getUsername());
                    sessionBean.setPassword(controlUser.getPassword());
                    //out.println(sessionBean.getPassword());
                    sessionBean.setEmail(controlUser.getEmail());
                    sessionBean.setRank(controlUser.getRank());
                    sessionBean.setProfilePicture(controlUser.getProfilePicture());
                    sessionBean.setCreatedAt(controlUser.getCreatedAt());
                    sessionBean.setUpdatedAt(controlUser.getUpdatedAt());
                    sessionBean.setLastLogin(controlUser.getLastLogin());
                }
            }

        %>
        <!-- BEN YAZDIM -->
</body>
</html>
