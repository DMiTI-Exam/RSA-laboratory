package com.dmiti.rsa.controller;

import com.dmiti.rsa.model.RSACracker;
import com.dmiti.rsa.model.RSAEncoder;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@Controller
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    private Random random = new Random(System.nanoTime());
    private ThreadPoolTaskExecutor service;
    private ConcurrentMap<String, FutureTask<String>> processes = new ConcurrentHashMap();

    public MainController(@Qualifier("executorService") ThreadPoolTaskExecutor service) {
        this.service = service;
    }

    @GetMapping
    public String mainPage() {
        logger.info("Showing the main page");

        return "index";
    }

    @GetMapping("/laboratory")
    public String laboratoryPage() {
        logger.info("Showing the laboratory page");

        return "main/laboratory";
    }

    @GetMapping("/about")
    public String aboutPage() {
        logger.info("Showing the about page");

        return "main/about";
    }

    @GetMapping("/rsa_generator")
    public String rsaGeneratorPage() {
        logger.info("Showing the rsa generator page");

        return "main/rsa_generator";
    }

    @GetMapping("/poor_rsa")
    public String rsaPoorPage() {
        logger.info("Showing the poor rsa notification");

        return "main/poor_rsa";
    }

    @GetMapping("/stable_rsa")
    public String rsaStablePage() {
        logger.info("Showing the stable rsa notification");

        return "main/stable_rsa";
    }

    @GetMapping("/decrypt_process")
    public String rsaDecryptPage() {
        logger.info("Showing the start decrypt notification");

        return "main/decrypt_process";
    }

    @GetMapping("/training")
    public String trainingPage(Model model) {
        logger.info("Showing the training page");

        int degree = random.ints(3, 501).findFirst().getAsInt();
        RSAEncoder rsaEncoder = new RSAEncoder(new ImmutablePair<>(5, 7), degree);
        List<String> code = rsaEncoder.encode(random.nextInt(1000) + 1 + "");
        String description = String.format("Необходимо расшифровать следующий код, представляющий число (каждая цифра" +
                "шифруется одним числом): %s. Также дано: N = %s, e = %s.\n" +
                        "Для выполнения данного задания используйте алфавит:\n219 - '1', " +
                        "220 - '2', 221 - '3', 222 - '4', 223 - '5', 224 - '6', 225 - '7' " +
                        "226 - '8', 227 - '9', 228 - '0'", code, rsaEncoder.getPublicKey().left,
                rsaEncoder.getPublicKey().right);
        String source = rsaEncoder.decode(code);

        model.addAttribute("description", description);
        model.addAttribute("code", code);
        model.addAttribute("source", source);

        return "main/training";
    }

    @PostMapping("/rsa_generator")
    public String generateRsa(@RequestParam("p_min_value") int minBitLength,
                              @RequestParam("p_max_value") int maxBitLength,
                              @RequestParam("e_min_value") int eMinValue,
                              @RequestParam("message") String message,
                              Model model) {
        RSAEncoder rsaEncoder = new RSAEncoder(new ImmutablePair<>(minBitLength, maxBitLength), eMinValue);

        List<String> encodedMessage = rsaEncoder.encode(message);
        model.addAttribute("N", rsaEncoder.getPublicKey().left);
        model.addAttribute("e", rsaEncoder.getPublicKey().right);
        model.addAttribute("encodedMessage", encodedMessage);
        model.addAttribute("message", message);

        return "main/rsa_generator";
    }

    @PostMapping("/decrypt_process")
    public String startDecrypt(@RequestParam("number_N") String nNumber,
                               @RequestParam("number_e") String eNumber,
                               @RequestParam("message") String message,
                               @RequestParam("pid") String pid,
                               Model model) {
        logger.info(nNumber + " " + eNumber + " " + message + " " + pid);
        List<String> encodedParts = Arrays.stream(message.split(" "))
                .collect(Collectors.toList());
        RSACracker cracker = new RSACracker(new BigInteger(nNumber), new BigInteger(eNumber), encodedParts);

        Callable<String> task = cracker::crack;
        FutureTask<String> decodeTask = new FutureTask<>(task);
        service.submit(decodeTask);
        processes.put(pid, decodeTask);

        return "main/decrypt_process";
    }

    @PostMapping("/check_progress/{pid}")
    @ResponseBody
    public String checkProgress(@PathVariable("pid") String pid) throws InterruptedException {
        FutureTask<String> task = processes.get(pid);
        if (task.isDone()) {
            try {
                return task.get();
            } catch (ExecutionException e) {
                return "Timeout";
            }
        } else {
            return "NONE";
        }
    }
}
