package com.example.snowrentserver.rentalorder;

import com.example.snowrentserver.rentallist.RentalList;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table
public class RentalOrder {

    @Id
    @SequenceGenerator(
            name = "rentalorder_sequence",
            sequenceName = "rentalorder_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rentalorder_sequence"
    )

    private Long id;
    private String customerName;
    private float height;
    private String postal;
    private String city;
    @ManyToMany
    private List<RentalOrderItem> items;
    private float total;


    public RentalOrder() {
    }

    public RentalOrder(Long id, String customerName, float height, String postal, String city, List<RentalOrderItem> items, float total) {
        this.id = id;
        this.customerName = customerName;
        this.height = height;
        this.postal = postal;
        this.city = city;
        this.items = items;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<RentalOrderItem> getItems() {
        return items;
    }

    public void setItems(List<RentalOrderItem> items) {
        this.items = items;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "RentalOrder{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", height=" + height +
                ", postal='" + postal + '\'' +
                ", city='" + city + '\'' +
                ", items=" + items +
                ", total=" + total +
                '}';
    }
}
