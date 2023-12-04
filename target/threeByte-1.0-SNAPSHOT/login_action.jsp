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

<%
    Hash hs = new Hash();
    UserDaoImp usrDao = new UserDaoImp();
    User sql_user = new User("", "", "");
    
    sql_user = usrDao.getUserbyName(request.getParameter("username"));
    out.println("başladı");
    if (sql_user == null) {
        out.println(request.getParameter("username") + " " + "artın");
    }
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

<%
        }
    }
    ///


%>

