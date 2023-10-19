package com.example.snowrentserver.rentalorder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RentalOrderRepository extends JpaRepository<RentalOrder, Long> {

//    @Query("SELECT s FROM RentalList WHERE s.name =?1")
    Optional<RentalOrder> findRentalOrderByCustomerName(String customerName);
//    @Query("SELECT city from RentalOrder WHERE id= ?1")
//    List<String> findCityById(Long id);
}
