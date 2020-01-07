package com.library.service.impl;

import com.library.entity.User;

import java.util.List;

public interface UserServiceImpl {
    public boolean checkLoginByUser(Integer sid,String password);
    public List<User> queryTicketBySid(int sid);
    public void downTicket(int sid);
    public List<User> queryUsernameBySid(int sid);
}
