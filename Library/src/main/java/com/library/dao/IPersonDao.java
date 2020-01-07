package com.library.dao;

import com.library.dao.impl.PersonDaoImpl;
import com.library.entity.Person;
import com.library.utils.dbUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IPersonDao implements PersonDaoImpl {
    @Override
    public List<Person> queryAllPerson(String sql, Object[] params) {
        List<Person> people=null;
        try {
            ResultSet rs = dbUtil.queryAll(sql, params);
            people = new ArrayList<Person>();
            while (rs.next()){
                Person person=new Person(rs.getInt("id"),rs.getInt("sid"),rs.getString("truename"),rs.getString("sex"),rs.getString("classname"),rs.getString("phone"));
                people.add(person);
            }
            dbUtil.closeAll(rs,dbUtil.pstmt,dbUtil.connection);
            return people;
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return people;
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
