package com.example.snowrentserver.rentallist;

import jakarta.persistence.*;

@Entity
@Table
public class RentalList {

    @Id
    @SequenceGenerator(
            name = "rentallist_sequence",
            sequenceName = "rentallist_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rentallist_sequence"
    )

    private Long id;
    private String name;
    private float price;
    private String description;

    public RentalList() {
    }

    public RentalList(String name, float price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "RentalList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
