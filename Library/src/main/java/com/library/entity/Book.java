package com.library.entity;

public class Book {
    private String id;
    private String name;
    private double price;
    private String author;
    private String publish;
    private int date;
    private String language;
    private String ISBN;
    private String type;
    private String location;
    private int num;

    public Book() {

    }
    public Book(String id, String name, double price, String author, String publish, int date, String language, String ISBN, String type, String location, int num) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.publish = publish;
        this.date = date;
        this.language = language;
        this.ISBN = ISBN;
        this.type = type;
        this.location = location;
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", publish='" + publish + '\'' +
                ", date=" + date +
                ", language='" + language + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", type='" + type + '\'' +
                ", location='" + location + '\'' +
                ", num=" + num +
                '}';
    }
}
