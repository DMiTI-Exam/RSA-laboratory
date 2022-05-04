package com.dmiti.rsa.model;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.*;

@Component
public class RSAEncoder {
    private static final Logger logger = LoggerFactory.getLogger(RSAEncoder.class);

    private char[] characters = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'а', 'б', 'в', 'г',
            'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч',
            'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', 'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л',
            'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я', ' ',
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+',
            ',', '-', '.', '/', ':', ';', '<', '>', '?', '@', '[', '\\', ']', '^', '_', '`', '~', '№', '=', '|', '/',
            '{', '}'};

    /**
     * Primes p and q in bounds [2^(n-1) + 1; 2^n - 1] where n - bit length
     */
    private ImmutablePair<Integer, Integer> primesBitLength;

    /**
     * Min and max value for e number (power for message)
     */
    private ImmutablePair<Integer, Integer> eBounds;

    /**
     * Public key represents a pair with N and e numbers
     */
    private ImmutablePair<BigInteger, BigInteger> publicKey;

    /**
     * Private key represents a d number (reciprocal of e)
     */
    private BigInteger privateKey;

    protected RSAEncoder() {

    }

    public RSAEncoder(ImmutablePair<Integer, Integer> primesBitLength, ImmutablePair<Integer, Integer> eBounds) {
        this.primesBitLength = primesBitLength;
        this.eBounds = eBounds;
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

        // TODO: Transform the message to the array of numbers
        List<String> partedMessage = splitMessage(message);
        codeParts(partedMessage);

        // TODO: remove after debugging
        logNumbers(p, q, phiN, partedMessage);

        return partedMessage;
    }

    private BigInteger[] generatePrimes() {
        Random random = new Random(System.currentTimeMillis());
        int minBitLength = primesBitLength.left;
        int maxBitLength = primesBitLength.right;

        PrimitiveIterator.OfInt iterator = random.ints(minBitLength, maxBitLength)
                .limit(10)
                .distinct()
                .limit(2)
                .iterator();

        BigInteger p = BigInteger.probablePrime(iterator.nextInt(), random);
        BigInteger q = BigInteger.probablePrime(iterator.nextInt(), random);
        return new BigInteger[] {p, q};
    }

    private BigInteger generateE(BigInteger phiN) {
        Random random = new Random(System.currentTimeMillis());
        int minBound = eBounds.left;
        int maxBound = eBounds.right;

        int degree;
        do {
            degree = random.ints(minBound, maxBound)
                    .findFirst()
                    .orElse(0);
        } while (phiN.gcd(BigInteger.valueOf(degree)).compareTo(BigInteger.ONE) != 0);

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

        // TODO: remove after debugging
        logger.info("Message parts: " + messageParts);
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

        // TODO: remove after debugging
        logger.info("decrypted message = " + encodedMessage.toString());

        return encodedMessage.toString();
    }

    private void logNumbers(BigInteger p, BigInteger q, BigInteger phiN, List<String> partedMessage) {
        logger.info(String.format("Prime numbers:\n\tp = %s\n\tq = %s\n" +
                "Public key:\n\tN = %s\n\te = %s\nEuler function: %s\nPrivate key:\n" +
                "\td = %s\nEncrypted message parts: %s", p, q, publicKey.left, publicKey.right, phiN,
                privateKey, partedMessage));
    }
}
