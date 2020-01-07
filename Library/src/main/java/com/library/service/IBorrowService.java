package com.library.service;

import com.library.dao.IBorrowDao;
import com.library.entity.Borrow;
import com.library.service.impl.BorrowServiceImpl;

import java.util.List;

public class IBorrowService implements BorrowServiceImpl {
    IBorrowDao borrowDao=new IBorrowDao();
    List<Borrow> borrows=null;
    @Override
    public List<Borrow> queryAllBorrow(Object[] params) {
        String sql="select * from borrow limit ?,?";
        return borrowDao.queryAll(sql,params);
    }

    @Override
    public int queryAllCountBorrow() {
        String sql="SELECT COUNT(1) FROM borrow";
        return borrowDao.queryAllCount(sql,null);
    }

    @Override
    public void delBorrowById(Object[] params) {
        String sql="DELETE FROM borrow WHERE nid= ?";
        borrowDao.queryAllUpdate(sql,params);
    }

    @Override
    public List<Borrow> queryBorrowBookBySid(Object[] params) {
        String sql="select bid from borrow where sid= ?"+"limit ?,?";
        return borrows=borrowDao.queryBid(sql,params);
    }

    @Override
    public int countBorrowBookBySid(String username) {
        String sql="select count(bid) from borrow where sid= ?";
        Object[] params=new Object[]{username};
        return borrowDao.queryAllCount(sql,params);
    }

    @Override
    public void addBorrow(Object[] params) {
        String sql="INSERT INTO borrow (bid,sid,borrow_date) VALUES(?,?,?)";
        borrowDao.queryAllUpdate(sql,params);
    }

}
