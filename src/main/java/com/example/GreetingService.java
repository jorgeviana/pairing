package com.example;

import lombok.Value;

public class GreetingService {
    public Greet hello(String name) {
        return new Greet("Hello " + name + ", good morning");
    }
}

@Value
class Greet {
    String message;
}

//  { "message": "Hello...." }
//
