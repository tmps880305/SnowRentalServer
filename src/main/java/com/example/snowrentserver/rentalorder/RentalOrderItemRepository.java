package com.example.snowrentserver.rentalorder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RentalOrderItemRepository extends JpaRepository<RentalOrderItem, Long> {

}
