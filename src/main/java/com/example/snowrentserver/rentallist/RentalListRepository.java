package com.example.snowrentserver.rentallist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RentalListRepository extends JpaRepository<RentalList, Long> {

//    @Query("SELECT s FROM RentalList WHERE s.name =?1")
    Optional<RentalList> findRentalListByName(String name);
}
