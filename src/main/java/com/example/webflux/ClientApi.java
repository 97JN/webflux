package com.example.webflux;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ClientApi {

    Logger logger = LoggerFactory.getLogger(ClientApi.class);

    @EventListener(ApplicationReadyEvent.class)
    public void get(){
        Flux<User> userFlux = WebClient.create()
                .get()
                .uri("http://localhost:8080")
                .retrieve()
                .bodyToFlux(User.class);
        userFlux.subscribe(user -> logger.info(user.toString()));
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void create(){
//        Flux<User> userFlux = WebClient.create()
//                .post()
//                .uri("http://localhost:8080")
//                .body(Mono.just(new User("5","Kamil")), User.class)
//                .retrieve()
//                .bodyToFlux(User.class);
//        userFlux.subscribe(user -> logger.info(user.toString()));
//    }
}
