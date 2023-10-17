package com.example;

import lombok.Value;

public class GreetingService {
    private UserRepository userRepository;
    public GreetingService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Greet hello(String name) {
        if(userRepository.findByName(name) == null){
            return new Greet("Hello " + name + ", good morning");
        }
        return new Greet("I saw you before, " + name);
    }
}

@Value
class Greet {
    String message;
}

//  { "message": "Hello...." }
//

class UserRepository{

    public User findByName(String name) {
        throw new RuntimeException("NOT IMPLEMENTED YET");
    }
}

@Value
class User{
    String name;
}
