package com.library.dao.impl;

import com.library.entity.Admin;

import java.util.List;

public interface AdminDaoImpl {
    public List<Admin> queryAllAdmin(String sql,Object[] params);
    public void queryAllUpdate(String sql,Object[] params);
}
