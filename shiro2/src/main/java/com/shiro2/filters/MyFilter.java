package com.shiro2.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@WebFilter(urlPatterns = "/*")
public class MyFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("=============");
        MyRequest myRequest = new MyRequest((HttpServletRequest) servletRequest);

        filterChain.doFilter(myRequest,servletResponse);
    }
}
