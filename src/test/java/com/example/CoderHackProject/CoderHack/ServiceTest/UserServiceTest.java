package com.example.CoderHackProject.CoderHack.ServiceTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.CoderHackProject.CoderHack.Model.User;
import com.example.CoderHackProject.CoderHack.Service.UserService;

@SpringBootTest
public class UserServiceTest{

    @Autowired
    private UserService userService;

    @Test
    public void testCreatedUser(){
        User user = User.builder().id("1").userName("Aditya").build();

        User userCreated = userService.createUser(user);

        assertEquals(user, userCreated);
        assertEquals(0, userCreated.getScore());
        assertTrue(userCreated.getBadges().isEmpty());
    }

    @Test
    public void testUpdateUserDetails(){
        User user = User.builder().id("1").score(10).build();

        User userUpdated = userService.updateUserDetails("1", 99);

        assertEquals(99, userUpdated.getScore());
        assertNotNull(userUpdated);
    }

}