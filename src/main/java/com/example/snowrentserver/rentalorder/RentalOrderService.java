package com.example.snowrentserver.rentalorder;

import com.example.snowrentserver.rentallist.RentalList;
import com.example.snowrentserver.rentallist.RentalListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalOrderService {
    private final RentalListRepository rentalListRepository;
    private final RentalOrderRepository rentalOrderRepository;
    private final RentalOrderItemRepository rentalOrderItemRepository;

    @Autowired
    public RentalOrderService(RentalListRepository rentalListRepository, RentalOrderRepository rentalOrderRepository, RentalOrderItemRepository rentalOrderItemRepository) {
        this.rentalListRepository = rentalListRepository;
        this.rentalOrderRepository = rentalOrderRepository;
        this.rentalOrderItemRepository = rentalOrderItemRepository;
    }

    public List<RentalOrder> getRentalOrder() {
        return rentalOrderRepository.findAll();
    }


    public void addNewRentalOrder(RentalOrder rentalOrder) {
        rentalOrderRepository.save(rentalOrder);
        rentalOrder.getItems().forEach(item -> {
            item.setRentalOrder(rentalOrder);
            Optional<RentalList> tmpRentalList = rentalListRepository.findRentalListById(item.getId() + 1L);
            item.setRentalList(tmpRentalList.orElse(null));
            addNewOrderItem(item);
        });
    }

    public void addNewOrderItem(RentalOrderItem rentalOrderItem) {
        rentalOrderItemRepository.save(rentalOrderItem);
    }


}
