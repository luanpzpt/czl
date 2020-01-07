package com.library.entity;

import java.util.Date;

public class Borrow {
    private int nid;
    private int bid;
    private int sid;
    private Date borrow_date;
    private Date return_date;
    public Borrow() {

    }
    public Borrow(int bid) {
        this.bid = bid;
    }

    public Borrow(int nid, int bid, int sid, Date borrow_date, Date return_date) {
        this.nid = nid;
        this.bid = bid;
        this.sid = sid;
        this.borrow_date = borrow_date;
        this.return_date = return_date;
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public Date getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(Date borrow_date) {
        this.borrow_date = borrow_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "nid=" + nid +
                ", bid=" + bid +
                ", sid=" + sid +
                ", borrow_date=" + borrow_date +
                ", return_date=" + return_date +
                '}';
    }
}
