package com.library.controller;

import com.library.entity.*;
import com.library.service.IAdviceService;
import com.library.service.IBookService;
import com.library.service.IBorrowService;
import com.library.service.IPersonService;
import com.library.utils.BaseServlet;
import com.library.utils.StringIsEmpty;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminCenterServlet",value = "/AdminCenterServlet")
public class AdminCenterServlet extends BaseServlet {
    IBookService bookService=new IBookService();
    IPersonService personService=new IPersonService();
    IBorrowService borrowService=new IBorrowService();
    IAdviceService adviceService=new IAdviceService();
    final int pageSize=10;//设置一页显示多少行
    List<Book> books = null;
    List<Person> people= null;
    List<Borrow> borrows= null;
    List<Advice> adviceList=null;
    Object[] params=null;
    int totalCount=-1; //查看有多少条数据
    public String showAllBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String cP=request.getParameter("currentPage");
        int currentPage=-1;
        if(cP != null){
            currentPage=Integer.parseInt(cP);
        }else{
            currentPage=1;          //第一次访问
        }

        params=new Object[]{(currentPage-1)*pageSize,pageSize};
        books=bookService.queryAllBook(params);
        totalCount=bookService.queryAllCountByNoElement();

        Page p=new Page(pageSize,totalCount,books);
        request.setAttribute("p",p);
        return "admin/adminBook.jsp";
    }
    public String searchBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String searchText =request.getParameter("searchText");
        String searchText1="%"+searchText+"%";
        String cP=request.getParameter("currentPage");
        int currentPage=-1;
        if(cP != null){
            currentPage=Integer.parseInt(cP);
        }else{
            currentPage=1;          //第一次访问
        }
        if(StringIsEmpty.isEmpty(searchText)){
            searchText1= (String) session.getAttribute("searchText1");

        }
        params=new Object[]{searchText1,(currentPage-1)*pageSize,pageSize};
        books=bookService.queryAllBookByName(params);
        totalCount=bookService.queryAllCountByName(searchText1);

        Page p=new Page(pageSize,totalCount,books);
        session.setAttribute("p",p);
        session.setAttribute("searchText1",searchText1);

        return "admin/adminBookSearch.jsp";
    }
    public String showAllPerson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String cP=request.getParameter("currentPage");
        int currentPage=-1;
        if(cP != null){
            currentPage=Integer.parseInt(cP);
        }else{
            currentPage=1;          //第一次访问
        }

        params=new Object[]{(currentPage-1)*pageSize,pageSize};
        people=personService.queryAllPerson(params);
        totalCount=personService.queryAllCountPerson();
        Page p=new Page(pageSize,totalCount,people);
        session.setAttribute("p",p);
        return "admin/adminPerson.jsp";
    }
    public String showAllBorrow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String cP=request.getParameter("currentPage");
        int currentPage=-1;
        if(cP != null){
            currentPage=Integer.parseInt(cP);
        }else{
            currentPage=1;          //第一次访问
        }
        params=new Object[]{(currentPage-1)*pageSize,pageSize};
        borrows=borrowService.queryAllBorrow(params);
        totalCount=borrowService.queryAllCountBorrow();

        Page p=new Page(pageSize,totalCount,borrows);
        session.setAttribute("p",p);

        return "admin/adminBorrow.jsp";
    }
    public String personUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String text =null;
        params=new Object[6];
        for(int i=0;i<=4;i++){
            text=request.getParameter("text"+i);
            params[i]=text;
        }
        if((text=request.getParameter("updateId"))!=null) {
            params[5]=text;
        }
        personService.updatePersonById(params);
        return "AdminCenterServlet?method=showAllPerson";
    }
    public String bookUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String text =null;
        String re=null;
        params=new Object[10];
        for(int i=0;i<=9;i++){
            text=request.getParameter("text"+i);
            params[i]=text;
        }
        if((text=request.getParameter("update1"))!=null) {
            params[9]=text;
            re="/AdminCenterServlet?method=showAllBook";
        }
        if((text=request.getParameter("update2"))!=null) {
            params[9]=text;
            re="/AdminCenterServlet?method=searchBook";
        }
        bookService.updateBookById(params);
        return re;
    }
    public String bookDel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id =null;
        String re=null;
        if(request.getParameter("delId")!=null) {
            id = request.getParameter("delId");
            re="/AdminCenterServlet?method=showAllBook";
        }
        if(request.getParameter("delId2")!=null) {
            id = request.getParameter("delId2");
            re="/AdminCenterServlet?method=searchBook";
        }
        params=new Object[]{id};
        bookService.delBookById(params);
        return re;
    }
    public String personDel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id =null;
        if(request.getParameter("delId")!=null) {
            id = request.getParameter("delId");
        }
        params=new Object[]{id};
        personService.delPersonById(params);
        return "AdminCenterServlet?method=showAllPerson";
    }
    public String borrowDel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id =null;
        if(request.getParameter("delId")!=null) {
            id = request.getParameter("delId");
        }
        params=new Object[]{id};
        borrowService.delBorrowById(params);
        return "AdminCenterServlet?method=showAllBorrow";
    }
    public String requestAdvice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String cP=request.getParameter("currentPage");
        int currentPage=-1;
        if(cP != null){
            currentPage=Integer.parseInt(cP);
        }else{
            currentPage=1;          //第一次访问
        }

        params=new Object[]{(currentPage-1)*pageSize,pageSize};
        adviceList=adviceService.queryAllAdvice(params);
        totalCount=adviceService.queryAllCountAdvice();
        Page p=new Page(pageSize,totalCount,adviceList);
        session.setAttribute("p",p);

        return "admin/adminAdvice.jsp";
    }
    public String passAdvice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id =null;
        String pass=null;
        if(request.getParameter("pass")!=null) {
            pass = request.getParameter("pass");
            id=request.getParameter("id");
            params=new Object[]{id};
            if("1".equals(pass)){                 // 1 为审查通过传递的参数
                adviceService.updatePassById(params);
            }else {
                adviceService.updateNoPassById(params);
            }
        }
        return "/AdminCenterServlet?method=requestAdvice";
    }
}
