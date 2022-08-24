//package com.example.springboot.mustache.crud.hike;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Configuration
//public class HikeConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunner(HikeRepository repository) {
//        return args -> {
//            Hike rb = new Hike("RB", "2.5", "700");
//            Hike kc = new Hike("KC", "2", "400");
//            List<Hike> hikes = new ArrayList<>();
//            hikes.add(rb);
//            hikes.add(kc);
//            repository.saveAll(hikes);
//        };
//    }
//}
