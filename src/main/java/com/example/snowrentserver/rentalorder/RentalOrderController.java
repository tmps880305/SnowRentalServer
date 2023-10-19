package com.example.snowrentserver.rentalorder;

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
    @PostMapping("/neworder")
    public Boolean registerNewOrder(@RequestBody RentalOrder rentalOrder) {
        try {
            rentalOrderService.addNewRentalOrder(rentalOrder);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<RentalOrder> getRentalLists() {
        return rentalOrderService.getRentalOrder();
    }

}
