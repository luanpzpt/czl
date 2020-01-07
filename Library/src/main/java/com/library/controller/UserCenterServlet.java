package com.library.controller;

import com.alibaba.fastjson.JSON;
import com.library.entity.*;
import com.library.service.IAdviceService;
import com.library.service.IBookService;
import com.library.service.IBorrowService;
import com.library.service.IUserService;
import com.library.utils.BaseServlet;
import com.library.utils.StringIsEmpty;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "UserCenterServlet",value = "/UserCenterServlet")
public class UserCenterServlet extends BaseServlet {
        IUserService userService=new IUserService();
        IBookService bookService=new IBookService();
        IBorrowService borrowService=new IBorrowService();
        IAdviceService adviceService=new IAdviceService();
        List<Book> books = null;
        List<Borrow> borrows=null;
        List<Advice> adviceList=null;
        Object[] params=null;
        final int pageSize=10;//设置一页显示多少行
        int totalCount=-1;//查看有多少条数据
        int currentPage=-1;
    public String showAllBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String cP=request.getParameter("currentPage");
        if(cP != null){
            currentPage=Integer.parseInt(cP);
        }else{
            currentPage=1;  //第一次访问
            String username=(String) session.getAttribute("username");
            int borrowNum=borrowService.countBorrowBookBySid(username);
            Object[] bParams=new Object[]{username,(currentPage-1)*pageSize,pageSize};
            borrows=borrowService.queryBorrowBookBySid(bParams);
            session.setAttribute("borrows",borrows);
            session.setAttribute("borrowNum",borrowNum);
        }
        params=new Object[]{(currentPage-1)*pageSize,pageSize};
        books=bookService.queryAllBook(params);
        totalCount=bookService.queryAllCountByNoElement();
        Page p=new Page(pageSize,totalCount,books);
        session.setAttribute("p",p);
        return "user/userBook.jsp";
    }
    public String searchBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String searchText =request.getParameter("searchText");
        String searchText1="%"+searchText+"%";
        String cP=request.getParameter("currentPage");
        if(cP != null){
            currentPage=Integer.parseInt(cP);
        }else{
            currentPage=1;  //第一次访问
            String username=(String) session.getAttribute("username");
            int borrowNum=borrowService.countBorrowBookBySid(username);
            Object[] bParams=new Object[]{username,(currentPage-1)*pageSize,pageSize};
            borrows=borrowService.queryBorrowBookBySid(bParams);
            session.setAttribute("borrows",borrows);
            session.setAttribute("borrowNum",borrowNum);
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
        return "user/userBookSearch.jsp";
    }
    public String showBorrow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String cP=request.getParameter("currentPage");
        if(cP != null){
            currentPage=Integer.parseInt(cP);
        }else{
            currentPage=1;          //第一次访问
        }
        params=new Object[]{(currentPage-1)*pageSize,pageSize};
        List<Borrow> borrows=null;
        borrows=borrowService.queryAllBorrow(params);
        totalCount=borrowService.queryAllCountBorrow();
        Page p=new Page(pageSize,totalCount,borrows);
        session.setAttribute("p",p);
        return "user/userBorrow.jsp";
    }
    public String addBorrowBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");  //sid
        String bid = (String)request.getParameter("bid");  //bid
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String format = df.format(new Date());   //borrow_date
        params=new Object[]{bid,username,format};
        borrowService.addBorrow(params);        //借书
        bookService.updateBookNumById(bid);    //图书-1

        return "user/userCenter.jsp";
    }
    public String upLoadBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            if(ServletFileUpload.isMultipartContent(request)){   //判断前台是否有Multipart
                File file=null;

                request.setCharacterEncoding("UTF-8");
                DiskFileItemFactory factory=new DiskFileItemFactory();
                //创建文件上传解析器
                ServletFileUpload upload=new ServletFileUpload(factory);
                upload.setHeaderEncoding("UTF-8");
                factory.setSizeThreshold(1024*100);//设置临时缓存大小
                upload.setSizeMax(1024*400); //限制图片大小400kb
                List<FileItem> fileItems = upload.parseRequest(request);
                String name=null;
                String author=null;
                String publish=null;
                String content=null;
                String imgpath=null;
                String savepath = request.getServletContext().getRealPath("/upload");
                for(FileItem f:fileItems){
                    if(f.isFormField()){   //表单数据上传
                        String itemName=f.getFieldName();
                        switch (itemName){
                            case "name":name=f.getString("UTF-8");break;
                            case "author":author=f.getString("UTF-8");break;
                            case "publish":publish=f.getString("UTF-8");break;
                            case "content":content=f.getString("UTF-8");break;
                        }
                    }else{       //文件
                        String fileName=f.getName();
                        System.out.println("文件名"+fileName);
                        String ext=fileName.substring(fileName.lastIndexOf("."));
                        System.out.println("ext="+ext);
                        if(!(ext.equals(".jpg")||ext.equals(".png"))){   //格式不对
                            return "";
                        }
                        String uuid = UUID.randomUUID().toString().replace("-", "");
                        file=new File(savepath,uuid+ext);  //保存唯一名字
                        //获取文件内容
                        imgpath="http://localhost:8080"+request.getContextPath()+"/upload"+"/"+uuid+ext;
                        f.write(file);
                    }
                }
                params=new Object[]{name,author,publish,content,imgpath};
                adviceService.addAdvice(params);
            }
        } catch (FileUploadBase.SizeLimitExceededException e) {
            e.printStackTrace();
        }catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    public String showPass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String cP=request.getParameter("currentPage");
        int currentPage=-1;
        if(cP != null){
            currentPage=Integer.parseInt(cP);
        }else{
            currentPage=1;          //第一次访问
        }
        params=new Object[]{(currentPage-1)*pageSize,pageSize};
        adviceList=adviceService.queryAllPass(params);
        totalCount=adviceService.queryPassCountAdvice();
        Page p=new Page(pageSize,totalCount,adviceList);
        session.setAttribute("p",p);
        return "user/userVote.jsp";
    }
    public void updateVote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String bid=request.getParameter("id");
        Integer sid = Integer.parseInt((String)session.getAttribute("sid"));
        //查找ticket
        List<User> tickets = userService.queryTicketBySid(sid);
        int ticket = tickets.get(0).getTicket();

        if(sid>0&&ticket>0){
            params=new Object[]{bid};
            adviceService.addVote(params);
            System.out.println(bid);
            List<Advice> list = adviceService.queryVote(params);
            userService.downTicket(sid);
            String json= JSON.toJSONString(list);
            PrintWriter out = response.getWriter();
            out.write(json);
        }
    }

}
