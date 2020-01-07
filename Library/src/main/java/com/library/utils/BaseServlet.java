package com.library.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");  //设置请求和响应编码
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String md=request.getParameter("method");
        //定义变量,存放功能执行完毕之后要转发的路径
        String path=null;

        // 当前类的字节码对象（当前类在内存中的对象）
        Class clazz = this.getClass();
        // 获取clazz上的名称为 md 方法
        try {
            Method method = clazz.getMethod(md, HttpServletRequest.class, HttpServletResponse.class);
            if(null != method){
                 path = (String)method.invoke(this, request, response);
            }
            if(null!=path){
                //服务端的转发
                request.getRequestDispatcher(path).forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
