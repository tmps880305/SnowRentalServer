package com.example.snowrentserver.rentallist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RentalListConfig {

//    @Bean
//    CommandLineRunner commandLineRunner(RentalListRepository repository) {
//        return args -> {
//            RentalList rent1 = new RentalList(
//                    "Beginner's Choice",
//                    19.99F,
//                    "Camber soft board, best for beginners."
//            );
//
//            RentalList rent2 = new RentalList(
//                    "Intermediate All Mountain",
//                    29.99F,
//                    "Rock-camber board with medium flex."
//            );
//
//            RentalList rent3 = new RentalList(
//                    "Freestyle Lovers",
//                    34.99F,
//                    "Rock board with bouncing flex for ground trick freestylers."
//            );
//
//            RentalList rent4 = new RentalList(
//                    "Helmet & Armor ",
//                    9.99F,
//                    "Protect yourselves!"
//            );
//
//            repository.saveAll(List.of(rent1, rent2, rent3, rent4));
//
//        };
//    }
}
