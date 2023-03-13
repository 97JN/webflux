package com.example.webflux;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class UserApi {

    private UserRepo userRepo;

    public UserApi(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/")
    public Flux<String> get(){
        return Flux.just("Adam","Anna","Marek","Bartosz","Jan","Oliwia","Justyna");
    }
}
