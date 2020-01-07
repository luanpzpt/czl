package com.library.service;

import com.library.dao.IUserDao;
import com.library.entity.User;
import com.library.service.impl.UserServiceImpl;

import java.util.List;

public class IUserService implements UserServiceImpl {
    IUserDao userDao=new IUserDao();
    Object[] params=null;
    @Override
    public boolean checkLoginByUser(Integer sid, String password) {
        String sql="select * from user";
        boolean flat=false;
        List<User> users = userDao.queryAllUser(sql,null);
        for(User a:users){
            if(a.getSid()==sid&&a.getPassword().equals(password)){
                flat=true;
            }
        }
        return flat;
    }

    @Override
    public List<User> queryTicketBySid(int sid) {
        params=new Object[]{sid};
        String sql="SELECT * FROM `user` WHERE sid=?";
        return userDao.queryAllUser(sql,params);
    }

    @Override
    public void downTicket(int sid) {
        params=new Object[]{sid};
        String sql="UPDATE user set ticket=ticket-1 WHERE sid=?";
        userDao.queryAllUpdate(sql,params);
    }

    @Override
    public List<User> queryUsernameBySid(int sid) {
        params=new Object[]{sid};
        String sql="SELECT * FROM `user` WHERE sid=?";
        return userDao.queryAllUser(sql,params);
    }
}
