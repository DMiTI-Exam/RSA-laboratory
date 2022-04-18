package com.dmiti.rsa.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.PrimitiveIterator;
import java.util.Random;

@Component
public class RSAEncoder {
    private static final Logger logger = LoggerFactory.getLogger(RSAEncoder.class);

    private BigInteger p;
    private BigInteger q;
    private BigInteger n;
    private BigInteger d;
    private BigInteger e;
    private BigInteger phiN;

    public RSAEncoder() {

    }

    public BigInteger encode(String message) {
        generatePrimes();
        logger.info("p = " + p.toString());
        logger.info("q = " + q.toString());

        this.n = p.multiply(q);
        logger.info("n = " + n.toString());
        this.phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        logger.info("phiN = " + phiN.toString());

        generateE();
        calculateD();

        logger.info("e = " + e.toString());
        logger.info("d = " + d.toString());

        // TODO: Transform the message to the array of numbers
        BigInteger msg = new BigInteger("34500000000000");
        BigInteger encrypted_msg = msg.modPow(e, n);

        logger.info("encrypted message = " + encrypted_msg.toString());
        return encrypted_msg;
    }

    private void generatePrimes() {
        Random random = new Random(System.currentTimeMillis());
        int minBitLength = 5;
        int maxBitLength = 93;

        PrimitiveIterator.OfInt iterator = random.ints(minBitLength, maxBitLength)
                .limit(2)
                .iterator();

        p = BigInteger.probablePrime(iterator.nextInt(), random);
        q = BigInteger.probablePrime(iterator.nextInt(), random);
    }

    private void generateE() {
        Random random = new Random(System.currentTimeMillis());
        int minBound = 3;
        int maxBound = 50;

        int degree;
        do {
            degree = random.ints(minBound, maxBound)
                    .findFirst()
                    .orElse(0);
        } while (phiN.gcd(BigInteger.valueOf(degree)).compareTo(BigInteger.ONE) != 0);

        this.e = BigInteger.valueOf(degree);
    }

    private void calculateD() {
        BigInteger k = BigInteger.valueOf(2);
        while (phiN.multiply(k).add(BigInteger.ONE).mod(e).compareTo(BigInteger.ZERO) != 0) {
            k = k.add(BigInteger.ONE);
        }

        this.d = phiN.multiply(k).add(BigInteger.ONE).divide(e);
    }

    public BigInteger decode(BigInteger code) {
        BigInteger decryptedMessage = code.modPow(d, n);
        logger.info("decrypted message = " + decryptedMessage.toString());
        return decryptedMessage;
    }
}
