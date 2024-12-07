package com.example.CoderHackProject.CoderHack.Respository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.CoderHackProject.CoderHack.Model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
