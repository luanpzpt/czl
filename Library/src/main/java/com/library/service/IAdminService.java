package com.library.service;

import com.library.dao.IAdminDao;
import com.library.entity.Admin;
import com.library.service.impl.AdminServiceImpl;

import java.util.List;

public class IAdminService implements AdminServiceImpl {
    IAdminDao IAdminDao=new IAdminDao();
    Object[] params=null;
    @Override
    public boolean checkLoginByAdmin(Integer sid, String password) {
        String sql="select * from admin";
        boolean flat=false;
        List<Admin> admins = IAdminDao.queryAllAdmin(sql,params);
        for(Admin a:admins){
            if(a.getId()==sid&&a.getPassword().equals(password)){
                flat=true;
            }
        }
        return flat;
    }

    @Override
    public void updateInUserPassword(Object[] params) {
        String sql="UPDATE `user` SET `password`=? WHERE username=? and password=?";
        IAdminDao.queryAllUpdate(sql,params);
    }

    @Override
    public List<Admin> queryAdminNameBySid(int sid) {
        params=new Object[]{sid};
        String sql="SELECT * FROM `admin` WHERE id=?";
        return IAdminDao.queryAllAdmin(sql,params);
    }

}
