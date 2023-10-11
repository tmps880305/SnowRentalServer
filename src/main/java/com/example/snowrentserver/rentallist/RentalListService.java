package com.example.snowrentserver.rentallist;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RentalListService {

    private final RentalListRepository rentalListRepository;

    @Autowired
    public RentalListService(RentalListRepository rentalListRepository) {
        this.rentalListRepository = rentalListRepository;
    }

    public List<RentalList> getRentalLists() {
        return rentalListRepository.findAll();
    }

    public void addNewRentalList(RentalList rentalList) {
        Optional<RentalList> rentalListOptional = rentalListRepository.findRentalListByName(rentalList.getName());
        if (rentalListOptional.isPresent()) {
            throw new IllegalStateException("Name exist");
        }

        rentalListRepository.save(rentalList);
    }

    public void deleteRentalList(Long id) {
        boolean rentalListExist = rentalListRepository.existsById(id);
        if (!rentalListExist) {
            throw new IllegalStateException("Id (" + id + ") does NOT exist.");
        }

        rentalListRepository.deleteById(id);
    }

    @Transactional
    public void updateRentalList(Long id, String description) {
        RentalList rentalList = rentalListRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("Id (" + id + ") does NOT exist.")
        );


        if (description != null && description.length() > 0 && !Objects.equals(description, rentalList.getDescription())) {
            rentalList.setDescription(description);
        }

    }
}
