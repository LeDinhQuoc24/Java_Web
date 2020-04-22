package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class Product {
    private int id;
    private String name;
    private int price;
    private String image;
    private String origin;
    private String photo;
    private MultipartFile[] fileDatas;
    public Product() {
    }

    public Product(int id, String name, int price, String image, String origin) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.origin = origin;
    }

    public MultipartFile[] getFileDatas() {
        return fileDatas;
    }

    public void setFileDatas(MultipartFile[] fileDatas) {
        this.fileDatas = fileDatas;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Product(int id, String name, int price, String image, String origin, String photo) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.origin = origin;
        this.photo = photo;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}