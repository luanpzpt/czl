package com.library.dao.impl;

import com.library.entity.Person;

import java.util.List;

public interface PersonDaoImpl {
    public List<Person> queryAllPerson(String sql, Object[] params);
    public int queryAllCount(String sql,Object[] params);
    public void queryAllUpdate(String sql,Object[] params);
}
