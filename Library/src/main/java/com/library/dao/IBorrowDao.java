package com.library.dao;

import com.library.dao.impl.BorrowDaoImpl;
import com.library.entity.Borrow;
import com.library.utils.dbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IBorrowDao implements BorrowDaoImpl {
    @Override
    public List<Borrow> queryAll(String sql, Object[] params) {
        List<Borrow> borrows=null;
        try {
            ResultSet rs = dbUtil.queryAll(sql, params);
            borrows = new ArrayList<Borrow>();
            while (rs.next()){
                Borrow borrow=new Borrow(rs.getInt("nid"),rs.getInt("bid"),rs.getInt("sid"),rs.getDate("borrow_date"),rs.getDate("return_date"));
                borrows.add(borrow);
            }
            dbUtil.closeAll(rs,dbUtil.pstmt,dbUtil.connection);
            return borrows;
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return borrows;
    }

    @Override
    public List<Borrow> queryBid(String sql, Object[] params) {
        List<Borrow> borrows=null;
        try {
            ResultSet rs = dbUtil.queryAll(sql, params);
            borrows = new ArrayList<Borrow>();
            while (rs.next()){
                Borrow borrow=new Borrow(rs.getInt("bid"));
                borrows.add(borrow);
            }
            dbUtil.closeAll(rs,dbUtil.pstmt,dbUtil.connection);
            return borrows;
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return borrows;
    }

    @Override
    public int queryAllCount(String sql, Object[] params) {
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
    public void queryAllUpdate(String sql, Object[] params) {
        dbUtil.allUpdata(sql,params);
    }
}
