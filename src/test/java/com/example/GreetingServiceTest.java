package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


public class GreetingServiceTest {

    UserRepository userRepository = mock(UserRepository.class);
    GreetingService greetingService = new GreetingService(userRepository);


    @Test
    void should_say_hello() {
        given(userRepository.findByName("Dorothy")).willReturn(null);

        assertThat(greetingService.hello("Dorothy"))
                .isEqualTo(new Greet("Hello Dorothy, good morning"));
    }

    @Test
    void should_not_say_hello_two_times(){
        given(userRepository.findByName("Dorothy")).willReturn(null)
                .willReturn(new User("Dorothy"));

        greetingService.hello("Dorothy");

        assertThat(greetingService.hello("Dorothy"))
                .isEqualTo(new Greet("I saw you before, Dorothy"));
    }

}
