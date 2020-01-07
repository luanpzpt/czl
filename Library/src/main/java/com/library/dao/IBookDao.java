package com.library.dao;

import com.library.dao.impl.BookDaoImpl;
import com.library.entity.Book;
import com.library.utils.dbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class IBookDao implements BookDaoImpl {
    @Override
    public List<Book> queryAllBook(String sql, Object[] params) {
        List<Book> books=null;
        try {
            ResultSet rs = dbUtil.queryAll(sql, params);
            books = new ArrayList<Book>();
            while (rs.next()){
                Book book=new Book(rs.getString("id"), rs.getString("name"),
                        rs.getDouble("price"), rs.getString("author"),
                        rs.getString("publish"), rs.getInt("date"),
                        rs.getString("language"), rs.getString("ISBN"),
                        rs.getString("type"), rs.getString("location"),
                        rs.getInt("num"));
                books.add(book);
            }
            dbUtil.closeAll(rs,dbUtil.pstmt,dbUtil.connection);

            return books;
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public int queryAllCount(String sql,Object[] params) {
        int count=-1;
        try {
            ResultSet rs = dbUtil.queryAll(sql, params);

            if (rs.next()){
                count = rs.getInt(1);
            }
            dbUtil.closeAll(rs,dbUtil.pstmt,dbUtil.connection);
            return count;
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public LinkedHashMap<String, Integer> queryCounts(String sql, Object[] params) {
        LinkedHashMap<String,Integer> LinkedHashMap=null;
        try {
            ResultSet rs = dbUtil.queryAll(sql, params);
            LinkedHashMap= new LinkedHashMap<String,Integer>();

            while (rs.next()){
                LinkedHashMap.put(rs.getString(1),rs.getInt(2));

            }
            dbUtil.closeAll(rs,dbUtil.pstmt,dbUtil.connection);
            return LinkedHashMap;
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return LinkedHashMap;
    }

    @Override
    public void queryAllUpdate(String sql, Object[] params) {
        dbUtil.allUpdata(sql,params);
    }
}
