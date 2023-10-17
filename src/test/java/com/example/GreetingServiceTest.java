package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class GreetingServiceTest {

    @Test
    void should_say_hello() {
        GreetingService greetingService = new GreetingService();

        assertThat(greetingService.hello("Dorothy"))
                .isEqualTo(new Greet("Hello Dorothy, good morning"));
    }
}
