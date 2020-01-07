package com.library.service.impl;

import com.library.entity.Borrow;

import java.util.List;

public interface BorrowServiceImpl {
    public List<Borrow> queryAllBorrow(Object[] params);
    public int queryAllCountBorrow();
    public void delBorrowById(Object[] params);
    public List<Borrow> queryBorrowBookBySid(Object[] params);
    public int countBorrowBookBySid(String username);
    public void addBorrow(Object[] params);
}
