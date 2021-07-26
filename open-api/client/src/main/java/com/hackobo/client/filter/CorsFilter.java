package com.hackobo.client.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "Filter")
public class CorsFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        chain.doFilter(request, response);

        System.out.println("filter on......");
        HttpServletResponse res = (HttpServletResponse) response;


    }
}
