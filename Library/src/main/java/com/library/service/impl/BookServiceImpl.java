package com.library.service.impl;

import com.library.entity.Book;

import java.util.LinkedHashMap;
import java.util.List;

public interface BookServiceImpl {
    public List<Book> queryAllBook(Object[] params);

    public List<Book> queryAllBookByName(Object[] params);
    public List<Book> queryAllBookByElement(String searchRadio,Object[] params,String searchTypeValueSQL);

    public int queryAllCountByElement(String searchRadio,String searchContent1,String searchTypeValueSQL);

    public int queryAllCountByNoElement();
    public int queryAllCountByName(String searchText);

    public void updateBookById(Object[] params);
    public void updateBookNumById(String id);
    public void delBookById(Object[] params);

    public LinkedHashMap<String,Integer> queryDateCountByElementSearch(String searchRadio,String searchContent1);
    public LinkedHashMap<String,Integer> queryTypeCountByElementSearch(String searchRadio,String searchContent1);
    public LinkedHashMap<String,Integer> queryLanguageCountByElementSearch(String searchRadio,String searchContent1);

}
