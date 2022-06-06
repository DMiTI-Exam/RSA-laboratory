package com.dmiti.rsa.model;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

import static com.dmiti.rsa.util.Util.characters;

public class RSAEncoder {
    private static final Logger logger = LoggerFactory.getLogger(RSAEncoder.class);

    /**
     * Primes p and q in bounds [2^(n-1) + 1; 2^n - 1] where n - bit length
     */
    private ImmutablePair<Integer, Integer> primesBitLength;

    /**
     * Min value for e number (power for message)
     */
    private Integer eBound;

    /**
     * Public key represents a pair with N and e numbers
     */
    private ImmutablePair<BigInteger, BigInteger> publicKey;

    /**
     * Private key represents a d number (reciprocal of e)
     */
    private BigInteger privateKey;

    public RSAEncoder(ImmutablePair<Integer, Integer> primesBitLength, Integer eBound) {
        this.primesBitLength = primesBitLength;
        this.eBound = eBound;
    }

    public List<String> encode(String message) {
        BigInteger[] primes = generatePrimes();
        BigInteger p = primes[0];
        BigInteger q = primes[1];

        BigInteger n = p.multiply(q);
        BigInteger phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        BigInteger e = generateE(phiN);
        publicKey = new ImmutablePair<>(n, e);
        privateKey = calculateD(phiN, e);

        List<String> partedMessage = splitMessage(message);
        codeParts(partedMessage);

        return partedMessage;
    }

    private BigInteger[] generatePrimes() {
        Random random = new Random(System.currentTimeMillis());
        int minBitLength = primesBitLength.left;
        int maxBitLength = primesBitLength.right;

        List<Integer> bitLengths = random.ints(minBitLength, maxBitLength)
                .limit(2)
                .boxed()
                .collect(Collectors.toList());

        BigInteger p;
        BigInteger q;
        do {
            p = BigInteger.probablePrime(bitLengths.get(0), random);
            q = BigInteger.probablePrime(bitLengths.get(1), random);
        } while (p.compareTo(q) == 0);

        return new BigInteger[] {p, q};
    }

    private BigInteger generateE(BigInteger phiN) {
        int degree = eBound;
        while (phiN.gcd(BigInteger.valueOf(degree)).compareTo(BigInteger.ONE) != 0) {
            ++degree;
        }

        return BigInteger.valueOf(degree);
    }

    private BigInteger calculateD(BigInteger phiN, BigInteger e) {
        BigInteger k = BigInteger.valueOf(2);
        while (phiN.multiply(k).add(BigInteger.ONE).mod(e).compareTo(BigInteger.ZERO) != 0) {
            k = k.add(BigInteger.ONE);
        }

        return phiN.multiply(k).add(BigInteger.ONE).divide(e);
    }

    private List<String> splitMessage(String message) {
        char[] chars = message.toCharArray();
        List<String> messageParts = new ArrayList<>();
        for (char digit : chars) {
            String part = ArrayUtils.indexOf(characters, digit) + 100 + "";
            messageParts.add(part);
        }

        return messageParts;
    }

    private void codeParts(List<String> parts) {
        String part;
        for (int i = 0; i < parts.size(); ++i) {
            part = parts.get(i);
            BigInteger encryptedPart = new BigInteger(part).modPow(publicKey.right, publicKey.left);
            parts.set(i, encryptedPart.toString());
        }
    }

    public String decode(List<String> codedMessage) {
        StringBuilder encodedMessage = new StringBuilder();
        for (String code : codedMessage) {
            int index = new BigInteger(code).modPow(privateKey, publicKey.left).intValue() - 100;
            encodedMessage.append(characters[index]);
        }

        return encodedMessage.toString();
    }

    public ImmutablePair<BigInteger, BigInteger> getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(ImmutablePair<BigInteger, BigInteger> publicKey) {
        this.publicKey = publicKey;
    }

    public ImmutablePair<Integer, Integer> getPrimesBitLength() {
        return primesBitLength;
    }

    public void setPrimesBitLength(ImmutablePair<Integer, Integer> primesBitLength) {
        this.primesBitLength = primesBitLength;
    }

    public Integer getE() {
        return eBound;
    }

    public void setE(Integer eBound) {
        this.eBound = eBound;
    }
}
