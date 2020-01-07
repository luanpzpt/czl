package com.library.service.impl;

import com.library.entity.Admin;

import java.util.List;

public interface AdminServiceImpl {
    public boolean checkLoginByAdmin(Integer sid, String password);
    public void updateInUserPassword(Object[] params);
    public List<Admin> queryAdminNameBySid(int sid);
}
