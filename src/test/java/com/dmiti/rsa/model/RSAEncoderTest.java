package com.dmiti.rsa.model;

import com.dmiti.rsa.util.Util;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class RSAEncoderTest {
    private RSAEncoder encoder;

    @BeforeEach
    public void setUp() {
        encoder = new RSAEncoder(new ImmutablePair<>(6, 30), new ImmutablePair<>(8, 500));
    }

    @Test
    public void simpleTest() throws InterruptedException, ExecutionException, TimeoutException {
        /*List<String> encryptedMessage = new ArrayList<>();
        for (int i = 0; i < 1; ++i) {
            System.out.println(BigInteger.probablePrime(6, new Random(System.nanoTime())));
            encryptedMessage = encoder.encode("nGЛудаВ|' ' ?fe4% oirf 034ПОКц4 * 43цощ а gj43 98v @~ Ёа ёю.");
            encoder.decode(encryptedMessage);
        }*/

        //List<String> parts = new ArrayList<>(Arrays.asList("226720", "195374", "395355", "267123", "117908", "479999"));
        /*RSACracker cracker = new RSACracker(encoder.getPublicKey().left, encoder.getPublicKey().right,
                encryptedMessage.subList(0, 1));
        System.out.println(cracker.crack());*/

        //System.out.println(Util.pow(BigInteger.valueOf(5), BigInteger.valueOf(4)));


        /*Random random = new Random(System.nanoTime());
        RSAEncoder rsaEncoder = new RSAEncoder(new ImmutablePair<>(4, 10),
                new ImmutablePair<>(3, 1000));
        List<String> code = rsaEncoder.encode(random.nextInt(300) + 1 + "");
        String source = rsaEncoder.decode(code);

        System.out.println("Code: " + code);
        System.out.println("Source message: " + source);*/
    }
}
