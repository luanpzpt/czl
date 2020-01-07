package com.library.service.impl;

import com.library.entity.Person;

import java.util.List;

public interface PersonServiceImpl {
    public List<Person> queryAllPerson(Object[] params);
    public int queryAllCountPerson();
    public void updatePersonById(Object[] params);
    public void delPersonById(Object[] params);
}
