package com.library.entity;

public class User {
    private Integer sid;
    private String username;
    private String password;
    private int ticket;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(Integer sid, String username, String password, int ticket) {
        this.sid = sid;
        this.username = username;
        this.password = password;
        this.ticket = ticket;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "User{" +
                "sid=" + sid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", ticket=" + ticket +
                '}';
    }
}
