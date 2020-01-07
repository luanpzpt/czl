package com.library.service;

import com.library.dao.IBookDao;
import com.library.entity.Book;
import com.library.service.impl.BookServiceImpl;

import java.util.LinkedHashMap;
import java.util.List;

public class IBookService implements BookServiceImpl {
    IBookDao bookDao=new IBookDao();

    @Override
    public List<Book> queryAllBook(Object[] params) {
        String sql="select * from book limit ?,?";
        return bookDao.queryAllBook(sql,params);
    }

    @Override
    public List<Book> queryAllBookByName(Object[] params) {
        String sql="select * from book where name like ?"+"limit ?,?";
        return bookDao.queryAllBook(sql,params);
    }

    @Override
    public List<Book> queryAllBookByElement(String searchRadio,Object[] params,String searchTypeValueSQL) {
        String sql="select * from book where"+" "+searchRadio+" "+"like ?"+" "+searchTypeValueSQL+" "+"limit ?,?";
        return bookDao.queryAllBook(sql,params);
    }
    @Override
    public int queryAllCountByElement(String searchRadio,String searchCoantent1,String searchTypeValueSQL) {
        String sql="SELECT COUNT(1) FROM book where"+" "+searchRadio+" "+"like ?"+" "+searchTypeValueSQL;
        Object[] params=new Object[]{searchCoantent1};
        return bookDao.queryAllCount(sql,params);
    }

    @Override
    public int queryAllCountByNoElement() {
        String sql="SELECT COUNT(1) FROM book";
        return bookDao.queryAllCount(sql,null);
    }

    @Override
    public int queryAllCountByName(String searchText) {
        String sql="SELECT COUNT(1) FROM book where name like ?";
        Object[] params=new Object[]{searchText};
        return bookDao.queryAllCount(sql,params);
    }

    @Override
    public void updateBookById(Object[] params) {
        String sql="UPDATE book SET name=?,price=?,author=?,publish=?,date=?,language=?,ISBN=?,type=?,num=? WHERE id=?";
        bookDao.queryAllUpdate(sql,params);
    }

    @Override
    public void updateBookNumById(String id) {
        String sql="UPDATE book SET num=num-1 where id=?";
        Object[] params=new Object[]{id};
        bookDao.queryAllUpdate(sql,params);
    }

    @Override
    public void delBookById(Object[] params) {
        String sql="DELETE FROM book WHERE id= ?";
        bookDao.queryAllUpdate(sql,params);

    }

    @Override
    public LinkedHashMap<String,Integer> queryDateCountByElementSearch(String searchRadio,String searchContent1) {
        String sql="SELECT `date`,COUNT(`date`) FROM `book` WHERE"+" "+searchRadio+" "+"like ? GROUP BY date ORDER BY `date`+0 DESC";
        Object[] params=new Object[]{searchContent1};
        return  bookDao.queryCounts(sql,params);
    }

    @Override
    public LinkedHashMap queryTypeCountByElementSearch(String searchRadio,String searchContent1) {
        String sql="SELECT `type`,COUNT(`type`) FROM `book` WHERE"+" "+searchRadio+" "+"like ? GROUP BY `type`";
        Object[] params=new Object[]{searchContent1};
        return  bookDao.queryCounts(sql,params);
    }

    @Override
    public LinkedHashMap<String,Integer> queryLanguageCountByElementSearch(String searchRadio,String searchContent1) {
        String sql="SELECT `language`,COUNT(`language`) FROM `book` WHERE"+" "+searchRadio+" "+"like ? GROUP BY `language`";
        Object[] params=new Object[]{searchContent1};
        return  bookDao.queryCounts(sql,params);

    }
}
