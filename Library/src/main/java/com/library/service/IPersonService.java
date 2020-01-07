package com.library.service;

import com.library.dao.IPersonDao;
import com.library.entity.Person;
import com.library.service.impl.PersonServiceImpl;

import java.util.List;

public class IPersonService implements PersonServiceImpl {
    IPersonDao personDao=new IPersonDao();
    @Override
    public List<Person> queryAllPerson(Object[] params) {
        String sql="select * from person limit ?,?";
        return personDao.queryAllPerson(sql,params);
    }

    @Override
    public int queryAllCountPerson() {
        String sql="SELECT COUNT(1) FROM person";
        return  personDao.queryAllCount(sql,null);
    }

    @Override
    public void updatePersonById(Object[] params) {
        String sql="UPDATE person SET sid=?,truename=?,sex=?,classname=?,phone=? WHERE id=?";
        personDao.queryAllUpdate(sql,params);
    }

    @Override
    public void delPersonById(Object[] params) {
        String sql="DELETE FROM person WHERE id= ?";
        personDao.queryAllUpdate(sql,params);
    }
}
