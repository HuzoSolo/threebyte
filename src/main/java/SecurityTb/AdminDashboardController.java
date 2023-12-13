/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SecurityTb;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author muhuz
 */
// AdminDashboardController.java
public class AdminDashboardController {

    public String getAdminDashboardPage(HttpServletRequest request, String url) {
        Boolean jsEnabled = (Boolean) request.getSession().getAttribute("jsEnabled");
        if (jsEnabled != null && jsEnabled) {
            // JavaScript etkinse, admin panelini göster
            
            return "404.jsp";
            
        } else {
            // JavaScript devre dışı bırakıldıysa, bir hata sayfasını göster
            return url;
        }
    }
}
