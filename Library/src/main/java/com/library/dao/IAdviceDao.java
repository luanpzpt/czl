package com.library.dao;

import com.library.dao.impl.AdviceIDaompl;
import com.library.entity.Advice;
import com.library.utils.dbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IAdviceDao implements AdviceIDaompl {
    @Override
    public List<Advice> queryAllAdvice(String sql, Object[] params) {
        List<Advice> adviceList=null;
        try {
            ResultSet rs = dbUtil.queryAll(sql, params);
            adviceList = new ArrayList<Advice>();
            while (rs.next()){
                Advice advice=new Advice(rs.getInt("id"),rs.getString("name"),rs.getString("author"),
                        rs.getString("publish"),rs.getString("content"),rs.getString("img"),
                        rs.getInt("pass"),rs.getInt("vote"));
                adviceList.add(advice);
            }
            dbUtil.closeAll(rs,dbUtil.pstmt,dbUtil.connection);
            return adviceList;
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return adviceList;
    }

    @Override
    public void queryAllUpdate(String sql, Object[] params) {
        dbUtil.allUpdata(sql,params);
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
}
