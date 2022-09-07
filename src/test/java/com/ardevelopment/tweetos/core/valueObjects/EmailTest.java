package com.ardevelopment.tweetos.core.valueObjects;

import com.ardevelopment.tweetos.core.exceptions.InvalidEmailException;
import com.ardevelopment.tweetos.core.valueObjects.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void should_throw_exception_in_case_of_invalid_value(){
        assertThrows(InvalidEmailException.class, ()-> new Email("invalid.email"));
    }

    @Test
    void should_not_throw_exception_in_case_valid_value(){
        Email email = new Email("raphaelandrey@gmail.com");
        assertEquals(email.getValue(), "raphaelandrey@gmail.com");
    }

}