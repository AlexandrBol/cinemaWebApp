package ua.org.bolshakov.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "TemeFilter", urlPatterns = "/time")
public class TemeFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("TemeFilter before servlet");
        chain.doFilter(req, resp);
        System.out.println("TemeFilter after servlet");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
