package com.library.dao.impl;

import com.library.entity.Borrow;

import java.util.List;

public interface BorrowDaoImpl {
    public List<Borrow> queryAll(String sql, Object[] params);
    public List<Borrow> queryBid(String sql, Object[] params);
    public int queryAllCount(String sql,Object[] params);
    public void queryAllUpdate(String sql,Object[] params);
}
