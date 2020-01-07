package com.library.controller;

import com.library.service.IAdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserUpdateServlet",value = "/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        IAdminService adminService=new IAdminService();
        String username = (String) session.getAttribute("username");
        String old_password=request.getParameter("old_password");
        String new_password=request.getParameter("new_password");
        Object[] params=new Object[]{new_password,username,old_password};
        adminService.updateInUserPassword(params);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
