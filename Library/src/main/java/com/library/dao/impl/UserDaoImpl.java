package com.library.dao.impl;

import com.library.entity.User;

import java.util.List;

public interface UserDaoImpl {
    public List<User> queryAllUser(String sql,Object[] params);
    public void queryAllUpdate(String sql,Object[] params);
    public int queryAllCount(String sql, Object[] params);
}
