package com.library.dao.impl;

import com.library.entity.Book;

import java.util.LinkedHashMap;
import java.util.List;

public interface BookDaoImpl {
    public List<Book> queryAllBook(String sql,Object[] params);
    public int queryAllCount(String sql,Object[] params);
    public LinkedHashMap<String,Integer> queryCounts(String sql, Object[] params);
    public void queryAllUpdate(String sql,Object[] params);
}
