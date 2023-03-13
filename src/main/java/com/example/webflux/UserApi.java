package com.example.webflux;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.time.Duration;

@RestController
@RequestMapping("/")
public class UserApi {

    private UserRepo userRepo;

    public UserApi(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    private Flux<User> userFlux;
    public UserApi(){
        userFlux=userFlux.just(new User("1","Adam"),
                new User("2","Justyna"),
                new User("3","Oliwia"),
                new User("4","Marek"));
    }

    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<User> getUser(){
        return userFlux.delayElements(Duration.ofSeconds(2));
    }

    @PostMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<User> getUser(@RequestBody User user){
        return userFlux.mergeWith(Mono.just(user));
    }
}
