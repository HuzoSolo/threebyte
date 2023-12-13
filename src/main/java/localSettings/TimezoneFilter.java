/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package localSettings;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.TimeZone;

/**
 *
 * @author muhuz
 */
public class TimezoneFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // İlgili başlangıç ayarlarını burada yapabilirsiniz.
        // Örneğin, Türkiye zaman dilimini belirleme:
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Istanbul"));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Filtreleme işlemleri burada yapılabilir, ancak genellikle burada bir şey yapmaya gerek yok.
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Filtre sona erdiğinde gerekirse temizleme işlemleri burada yapılabilir.
    }

}
