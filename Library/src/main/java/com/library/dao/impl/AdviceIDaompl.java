package com.library.dao.impl;

import com.library.entity.Advice;

import java.util.List;

public interface AdviceIDaompl {
    public List<Advice> queryAllAdvice(String sql, Object[] params);
    public void queryAllUpdate(String sql,Object[] params);
    public int queryAllCount(String sql,Object[] params);
}
