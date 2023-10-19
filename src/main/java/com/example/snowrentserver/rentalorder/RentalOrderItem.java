package com.example.snowrentserver.rentalorder;

import com.example.snowrentserver.rentallist.RentalList;
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
    @ManyToOne
    @JoinColumn(name = "listId")
    private RentalList rentalList;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private RentalOrder rentalOrder;
    private int amount;

    public RentalOrderItem() {
    }

    public RentalOrderItem(RentalList rentalList, RentalOrder rentalOrder, int amount) {
        this.rentalList = rentalList;
        this.rentalOrder = rentalOrder;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RentalList getRentalList() {
        return rentalList;
    }

    public void setRentalList(RentalList rentalList) {
        this.rentalList = rentalList;
    }

    public RentalOrder getRentalOrder() {
        return rentalOrder;
    }

    public void setRentalOrder(RentalOrder rentalOrder) {
        this.rentalOrder = rentalOrder;
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
                ", rentalList=" + rentalList +
                ", rentalOrder=" + rentalOrder +
                ", amount=" + amount +
                '}';
    }
}
