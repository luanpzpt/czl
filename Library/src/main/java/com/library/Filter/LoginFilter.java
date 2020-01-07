package com.library.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"/admin/*","/user/*"})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");
        if(sid!=null){
            chain.doFilter(req, resp);
            System.out.println("pass");
        }else
            response.sendRedirect(request.getContextPath()+"/"+"login.jsp");

    }

    public void init(FilterConfig config) throws ServletException {
    }

}
