package com.jasonz.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class EmailValidatorTest {
    // TODO Write test for EmailValidator
    // The names of the methods should give you a pointer what to test for

    @Test
    public void ensureThatEmailValidatorReturnsTrueForValidEmail() {
        assertTrue(EmailValidator.isValidEmail("lars.vogel@gmail.com"));
    }

    @Test
    @DisplayName("Ensure that the usage of a subdomain is still valid, see https://en.wikipedia.org/wiki/Subdomain")
    public void emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        fail("Fixme");
    }

    @Test
    @DisplayName("Ensure that a missiong top level domain returns false")
    public void emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        fail("Fixme");
    }

    @Test
    public void emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        fail("Fixme");
    }

    @Test
    public void emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        fail("Fixme");
    }

    @Test
    public void emailValidator_EmptyString_ReturnsFalse() {
        fail("Fixme");
    }

    @Test
    public void emailValidator_NullEmail_ReturnsFalse() {
        fail("Fixme");
    }

}