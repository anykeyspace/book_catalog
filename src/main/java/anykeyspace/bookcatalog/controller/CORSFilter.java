package anykeyspace.bookcatalog.controller;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CORSFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        servletResponse.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:52705");
        servletResponse.setHeader("Access-Control-Allow-Methods", "GET");
        chain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
