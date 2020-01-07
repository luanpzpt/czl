package com.library.controller;

import com.library.entity.Admin;
import com.library.entity.User;
import com.library.service.IAdminService;
import com.library.service.IUserService;
import com.library.utils.StringIsEmpty;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet",value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = request.getParameter("sid");
        String password=request.getParameter("password");
        String searchRadio=request.getParameter("searchRadio");
        IAdminService adminService=new IAdminService();
        IUserService userService=new IUserService();
        if (StringIsEmpty.isEmpty(sid)){
            request.getRequestDispatcher("login.jsp").forward(request,response);  //sid为空或空格 登录不成功
        }
        boolean b=false;
        HttpSession session = request.getSession();
        int flat=-1;
        switch (searchRadio){
            case "user":
                b=userService.checkLoginByUser(Integer.parseInt(sid),password);
                flat=0;
                List<User> list = userService.queryUsernameBySid(Integer.parseInt(sid));
                User user = list.get(0);
                session.setAttribute("sid",sid);
                session.setAttribute("username",user.getUsername());
                break;
            case "admin":
                b=adminService.checkLoginByAdmin(Integer.parseInt(sid),password);
                flat=1;
                List<Admin> list1 = adminService.queryAdminNameBySid(Integer.parseInt(sid));
                Admin admin = list1.get(0);
                session.setAttribute("sid",sid);
                session.setAttribute("username",admin.getUsername());
                break;
        }
        if(b){
            switch (flat){
                case 0:response.sendRedirect("user/userCenter.jsp");break; //根据用户和管理员重定向到不同的页面
                case 1:response.sendRedirect("admin/adminCenter.jsp");break;
            }
        }else
            request.getRequestDispatcher("login.jsp").forward(request,response);  //登录失败
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
