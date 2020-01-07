package com.library.dao;

import com.library.dao.impl.UserDaoImpl;
import com.library.entity.User;
import com.library.utils.dbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IUserDao implements UserDaoImpl {
    @Override
    public List<User> queryAllUser(String sql,Object[] params) {
        List<User> users=null;
        try {
            ResultSet rs = dbUtil.queryAll(sql, params);
            users = new ArrayList<User>();
            while (rs.next()){
                User user=new User(rs.getInt("sid"),rs.getString("username"),rs.getString("password"),rs.getInt("ticket"));
                users.add(user);
            }
            dbUtil.closeAll(rs,dbUtil.pstmt,dbUtil.connection);
            return users;
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void queryAllUpdate(String sql, Object[] params) {
        dbUtil.allUpdata(sql,params);
    }

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
