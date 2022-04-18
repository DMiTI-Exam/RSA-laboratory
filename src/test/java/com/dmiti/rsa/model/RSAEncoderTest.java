package com.dmiti.rsa.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RSAEncoderTest {
    private RSAEncoder encoder;

    @BeforeEach
    public void setUp() {
        encoder = new RSAEncoder();
    }

    @Test
    public void shouldFindClientByLogin() {
        BigInteger encryptedMessage = encoder.encode("123");
        encoder.decode(encryptedMessage);
    }
}
