package com.example.snowrentserver.rentalorder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RentalOrderRepository extends JpaRepository<RentalOrder, Long> {

//    @Query("SELECT s FROM RentalList WHERE s.name =?1")
    Optional<RentalOrder> findRentalOrderByCustomerName(String customerName);
}
