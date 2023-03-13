package com.example.webflux;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class InitService {

    private UserRepo userRepo;

    public InitService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void get(){
//        userRepo.deleteAll().thenMany(Flux.just("Adam","Anna","Marek","Bartosz","Jan","Oliwia","Justyna")
//        ).map(name->new User(name)).
//                flatMap(userRepo::save).
//                thenMany(userRepo.findAll()).
//                subscribe(System.out::println);
//
//    }
}
