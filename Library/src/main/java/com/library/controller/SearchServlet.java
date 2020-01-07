package com.library.controller;

import com.library.entity.Book;
import com.library.entity.Page;
import com.library.service.IBookService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "SearchServlet",value = "/SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");  //设置请求和响应编码
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        IBookService bookService=new IBookService();
        final int pageSize=5;//设置一页显示多少行

        String searchRadio=request.getParameter("searchRadio");        //获取搜索的类型和内容
        String searchContent=request.getParameter("searchContent");
        String searchContent1="%"+searchContent+"%";      //模糊查询
        String searchType = request.getParameter("searchType");
        String searchTypeValue =request.getParameter("searchTypeValue");
        //========
        int totalCount=-1; //查看有多少条数据
        String searchTypeValueSQL="";
        String cP=request.getParameter("currentPage");
        int currentPage=-1;
        if(cP != null){   //第一次访问
            currentPage=Integer.parseInt(cP);
            searchTypeValueSQL=(String) session.getAttribute("searchTypeValueSQL");
        }else
            currentPage=1;

        if(searchRadio==null&&searchContent==null) {   //第二次   获取搜索类型
            searchRadio = (String) session.getAttribute("searchRadio");
            searchContent1 = (String) session.getAttribute("searchContent1");
        }
        if (searchType!=null){            //==========
            searchTypeValueSQL="and"+" "+searchType+"="+"'"+searchTypeValue+"'";
        }

        Object[] params=new Object[]{searchContent1,(currentPage-1)*pageSize,pageSize};
        List<Book> books = null;
        Map<String,Integer> mapDCount=null;
        Map<String,Integer> mapTCount=null;
        Map<String,Integer> mapLCount=null;
        //========================================
        books=bookService.queryAllBookByElement(searchRadio,params,searchTypeValueSQL);
        totalCount=bookService.queryAllCountByElement(searchRadio,searchContent1,searchTypeValueSQL);

        mapDCount=bookService.queryDateCountByElementSearch(searchRadio,searchContent1);
        mapTCount=bookService.queryTypeCountByElementSearch(searchRadio,searchContent1);
        mapLCount = bookService.queryLanguageCountByElementSearch(searchRadio,searchContent1);

        Page p=new Page(pageSize,totalCount,books);
        session.setAttribute("p",p);
        session.setAttribute("test","test");
        session.setAttribute("searchRadio",searchRadio);
        session.setAttribute("searchContent1",searchContent1);

        session.setAttribute("mapLCount",mapLCount);
        session.setAttribute("mapTCount",mapTCount);
        session.setAttribute("mapDCount",mapDCount);
        session.setAttribute("searchTypeValueSQL",searchTypeValueSQL);

        response.sendRedirect("searchresult.jsp");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
