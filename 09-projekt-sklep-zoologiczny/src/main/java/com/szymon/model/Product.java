package com.szymon.model;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Column(length = 20000)
    private String description;

    private Double price;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Image smallImage;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Image bigImage;

    private String category;

    public Product() {
    }

    public Product(String title, String description, Double price, Image smallImage, Image bigImage, String category) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.smallImage = smallImage;
        this.bigImage = bigImage;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Image getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(Image smallImage) {
        this.smallImage = smallImage;
    }

    public Image getBigImage() {
        return bigImage;
    }

    public void setBigImage(Image bigImage) {
        this.bigImage = bigImage;
    }
}
