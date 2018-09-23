package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @DisplayName("should verify a user and return 1 if user is found")
    @Test
    void testForUserValidation(){
        User user = new User("123-4567","user@123");
        assertEquals(1,user.verify("123-4567","user@123"));
    }
}