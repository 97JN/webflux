package com.example.webflux;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepo extends ReactiveMongoRepository<User, String> {
}
