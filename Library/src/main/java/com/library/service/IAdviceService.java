package com.library.service;

import com.library.dao.IAdviceDao;
import com.library.entity.Advice;
import com.library.service.impl.AdviceServiceImpl;

import java.util.List;

public class IAdviceService implements AdviceServiceImpl {
    IAdviceDao adviceDao=new IAdviceDao();
    @Override
    public void addAdvice(Object[] params) {
        String sql="INSERT INTO advice (name,author,publish,content,img) VALUES (?,?,?,?,?)";
        adviceDao.queryAllUpdate(sql,params);
    }

    @Override
    public List<Advice> queryAllAdvice(Object[] params) {
        String sql="select * from advice where pass='-1' limit ?,?";
        return adviceDao.queryAllAdvice(sql,params);
    }
    public int queryAllCountAdvice() {
        String sql="SELECT COUNT(1) FROM advice where pass='-1'";
        return  adviceDao.queryAllCount(sql,null);
    }

    @Override
    public int queryPassCountAdvice() {
        String sql="SELECT COUNT(1) FROM advice where pass='1'";
        return  adviceDao.queryAllCount(sql,null);
    }

    @Override
    public void updatePassById(Object[] params) {
        String sql="UPDATE advice set pass='1' WHERE id=?";
        adviceDao.queryAllUpdate(sql,params);
    }

    @Override
    public void updateNoPassById(Object[] params) {
        String sql="UPDATE advice set pass='0' WHERE id=?";
        adviceDao.queryAllUpdate(sql,params);
    }

    @Override
    public List<Advice> queryAllPass(Object[] params) {
        String sql="select * from advice where pass='1' limit ?,?";
        return adviceDao.queryAllAdvice(sql,params);
    }

    @Override
    public void addVote(Object[] params) {
        String sql="UPDATE advice set vote=vote+1 WHERE id=?";
        adviceDao.queryAllUpdate(sql,params);
    }

    @Override
    public List<Advice> queryVote(Object[] params) {
        String sql="select * from advice where id=?";
        return adviceDao.queryAllAdvice(sql,params);
    }

}
