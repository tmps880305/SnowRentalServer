package com.example.snowrentserver.rentalorder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RentalOrderItemRepository extends JpaRepository<RentalOrderItem, Long> {
    Optional<RentalOrderItem> findRentalOrderItemsByRentalOrder_Id(Long id);

    @Query("SELECT id from RentalOrderItem WHERE rentalOrder= ?1")
    List<Long> findIdByOrder(Optional<RentalOrder> rentalOrder);

}
