package com.library.entity;

public class Advice {
    private int id;
    private String name;
    private String author;
    private String publish;
    private String content;
    private String img;
    private int pass;
    private int vote;

    public Advice() {

    }
    public Advice(String name, String author, String publish, String content, String img){
        this.name = name;
        this.author = author;
        this.publish = publish;
        this.content = content;
        this.img = img;
    }
    public Advice(String name, String author, String publish, String content, String img, int pass){
        this.name = name;
        this.author = author;
        this.publish = publish;
        this.content = content;
        this.img = img;
        this.pass = pass;
    }
    public Advice(int id, String name, String author, String publish, String content, String img, int pass,int vote) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publish = publish;
        this.content = content;
        this.img = img;
        this.pass = pass;
        this.vote=vote;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Advice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publish='" + publish + '\'' +
                ", content='" + content + '\'' +
                ", img='" + img + '\'' +
                ", pass=" + pass +
                ", vote=" + vote +
                '}';
    }
}
