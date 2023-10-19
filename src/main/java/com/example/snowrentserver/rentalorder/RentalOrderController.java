package com.example.snowrentserver.rentalorder;

import com.example.snowrentserver.rentallist.RentalList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/rentalorder")
public class RentalOrderController {

    private final RentalOrderService rentalOrderService;

    @Autowired
    public RentalOrderController(RentalOrderService rentalOrderService) {
        this.rentalOrderService = rentalOrderService;
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public void registerNewOrder(@RequestBody RentalOrder rentalOrder) {
        rentalOrderService.addNewRentalOrder(rentalOrder);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<RentalOrder> getRentalLists() {
        return rentalOrderService.getRentalOrder();
    }

}
