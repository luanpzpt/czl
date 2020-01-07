package com.library.dao;

import com.library.dao.impl.AdminDaoImpl;
import com.library.entity.Admin;
import com.library.utils.dbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IAdminDao implements AdminDaoImpl {
    @Override
    public List<Admin> queryAllAdmin(String sql,Object[] params) {
        List<Admin> admins=null;
        try {
            ResultSet rs = dbUtil.queryAll(sql, params);
            admins = new ArrayList<Admin>();
            while (rs.next()){
                Admin admin=new Admin(rs.getInt("id"),rs.getString("username"),rs.getString("password"));
                admins.add(admin);
            }
            dbUtil.closeAll(rs,dbUtil.pstmt,dbUtil.connection);
            return admins;
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        return admins;
    }

    @Override
    public void queryAllUpdate(String sql, Object[] params) {
        dbUtil.allUpdata(sql,params);
    }

}
