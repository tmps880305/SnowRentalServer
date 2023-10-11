package com.example.snowrentserver.rentallist;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/rentallist")
public class RentalListController {

    private final RentalListService rentalListService;

    @Autowired
    public RentalListController(RentalListService rentalListService) {
        this.rentalListService = rentalListService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<RentalList> getRentalLists() {
        return rentalListService.getRentalLists();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public void registerNewRentalList(@RequestBody RentalList rentalList) {
        rentalListService.addNewRentalList(rentalList);
    }


    @DeleteMapping(path = "{rentallistId}")
    public void deleteRentalList(@PathVariable("rentallistId") Long id) {
        rentalListService.deleteRentalList(id);
    }


    @PutMapping(path = "{rentallistId}")
    public void updateRentalList(@PathVariable("rentallistId") Long id,
                                 @RequestParam(required = false) String description) {
        rentalListService.updateRentalList(id, description);
    }
}
