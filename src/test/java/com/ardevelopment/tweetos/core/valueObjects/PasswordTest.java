package com.ardevelopment.tweetos.core.valueObjects;

import com.ardevelopment.tweetos.core.exceptions.NotStrongPasswordException;
import com.ardevelopment.tweetos.core.valueObjects.Password;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {

    @Test
    void should_throw_exception_in_case_weak_password(){
        assertThrows(NotStrongPasswordException.class, ()-> new Password("ppetgyujhed"));
    }

    @Test
    void should_not_throw_in_case_strong_password() {
        Password password = new Password("Mot2$asse");
        assertEquals(password.getValue(), "Mot2$asse");
    }

}