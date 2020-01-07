package com.library.service.impl;

import com.library.entity.Advice;

import java.util.List;

public interface AdviceServiceImpl {
    public void addAdvice(Object[] params);
    public List<Advice> queryAllAdvice(Object[] params);
    public int queryAllCountAdvice();
    public int queryPassCountAdvice();
    public void updatePassById(Object[] params);
    public void updateNoPassById(Object[] params);
    public List<Advice> queryAllPass(Object[] params);
    public void addVote(Object[] params);
    public  List<Advice> queryVote(Object[] params);
}
