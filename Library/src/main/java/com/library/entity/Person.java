package com.library.entity;

public class Person {
    private int id;
    private int sid;
    private String truename;
    private String sex;
    private String classname;
    private String phone;

    public Person() {

    }
    public Person(int sid, String truename, String sex, String classname, String phone) {
        this.sid = sid;
        this.truename = truename;
        this.sex = sex;
        this.classname = classname;
        this.phone = phone;
    }
    public Person(int id, int sid, String truename, String sex, String classname, String phone) {
        this.id = id;
        this.sid = sid;
        this.truename = truename;
        this.sex = sex;
        this.classname = classname;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", sid='" + sid + '\'' +
                ", truename='" + truename + '\'' +
                ", sex=" + sex +
                ", classname='" + classname + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
