package com.example.snowrentserver.rentalorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class RentalOrderService {

    private final RentalOrderRepository rentalOrderRepository;
    private final RentalOrderItemRepository rentalOrderItemRepository;

    @Autowired
    public RentalOrderService(RentalOrderRepository rentalOrderRepository, RentalOrderItemRepository rentalOrderItemRepository) {
        this.rentalOrderRepository = rentalOrderRepository;
        this.rentalOrderItemRepository = rentalOrderItemRepository;
    }

    public List<RentalOrder> getRentalOrder() {
        return rentalOrderRepository.findAll();
    }


    public void addNewRentalOrder(RentalOrder rentalOrder) {
        Optional<RentalOrder> rentalOrderOptional = rentalOrderRepository.findRentalOrderByCustomerName(rentalOrder.getCustomerName());
        if (rentalOrderOptional.isPresent()) {
            throw new IllegalStateException("Name exist");
        }

        List<RentalOrderItem> newOrderItems = rentalOrder.getItems();
        newOrderItems.forEach(this::addNewOrderItem);

        rentalOrderRepository.save(rentalOrder);
    }
    public void addNewOrderItem(RentalOrderItem rentalOrderItem){
        rentalOrderItemRepository.save(rentalOrderItem);
    }


}
