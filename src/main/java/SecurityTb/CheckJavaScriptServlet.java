/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SecurityTb;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author muhuz
 */


public class CheckJavaScriptServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jsEnabled = request.getParameter("jsEnabled");
        boolean isJsEnabled = "true".equals(jsEnabled);
        request.getSession().setAttribute("jsEnabled", isJsEnabled);
    }
}


