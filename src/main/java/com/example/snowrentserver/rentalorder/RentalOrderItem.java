package com.example.snowrentserver.rentalorder;

import jakarta.persistence.*;

@Entity
@Table
public class RentalOrderItem {

    @Id
    @SequenceGenerator(
            name = "rentalorderItem_sequence",
            sequenceName = "rentalorderItem_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rentalorderItem_sequence"
    )

    private Long id;
    private Long rentalListId;
    private int amount;


    public RentalOrderItem() {
    }

    public RentalOrderItem(Long id, Long rentalListId, int amount) {
        this.id = id;
        this.rentalListId = rentalListId;
        this.amount = amount;
    }

    public RentalOrderItem(Long rentalListId, int amount) {
        this.rentalListId = rentalListId;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRentalListId() {
        return rentalListId;
    }

    public void setRentalListId(Long rentalListId) {
        this.rentalListId = rentalListId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "RentalOrderItem{" +
                "id=" + id +
                ", rentalListId=" + rentalListId +
                ", amount=" + amount +
                '}';
    }
}
