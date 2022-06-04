package com.dmiti.rsa.model;

import com.dmiti.rsa.util.Util;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.*;

import static com.dmiti.rsa.util.Util.characters;

public class RSACracker {
    private static final Logger logger = LoggerFactory.getLogger(RSACracker.class);

    /**
     * Public key represents a pair with N and e numbers
     */
    private ImmutablePair<BigInteger, BigInteger> publicKey;

    private List<String> messageParts;

    public RSACracker(BigInteger n, BigInteger e, List<String> message) {
        publicKey = new ImmutablePair<>(n, e);
        this.messageParts = message;
    }

    public String crack() throws InterruptedException, TimeoutException, ExecutionException {
        BigInteger numericMsg;
        StringBuilder decodedMessage = new StringBuilder();
        messageParts.remove(0);
        for (String message : messageParts) {
            numericMsg = new BigInteger(message);

            final BigInteger code = numericMsg;
            Callable<BigInteger> task = () -> findDegree(code);

            ExecutorService service = Executors.newSingleThreadExecutor();
            BigInteger s = service.submit(task).get(6, TimeUnit.MINUTES);

            int index = numericMsg.modPow(Util.pow(publicKey.right, s.subtract(BigInteger.ONE)), publicKey.left)
                    .intValue() - 100;

            decodedMessage.append(characters[index]);
        }

        return decodedMessage.toString();
    }

    private BigInteger findDegree(BigInteger numericMsg) {
        BigInteger degree = BigInteger.ONE;
        while (true) {
            boolean isFound = numericMsg
                    .modPow(Util.pow(publicKey.right, degree), publicKey.left)
                    .compareTo(numericMsg) == 0;
            if (isFound) {
                break;
            }

            degree = degree.add(BigInteger.ONE);
        }

        return degree;
    }
}
