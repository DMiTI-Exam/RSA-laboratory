package com.dmiti.rsa.model;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RSAEncoderTest {
    private RSAEncoder encoder;

    @BeforeEach
    public void setUp() {
        encoder = new RSAEncoder(new ImmutablePair<>(6, 93), new ImmutablePair<>(8, 500));
    }

    @Test
    public void simpleTest() {
        for (int i = 0; i < 10000; ++i) {
            List<String> encryptedMessage = encoder.encode("nGЛудаВ|' ' ?fe4% oirf 034ПОКц4 * 43цощ а gj43 98v @~ Ёа ёю.");
            encoder.decode(encryptedMessage);
        }
    }
}
