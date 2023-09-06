package com.crewtest.bots.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
@Slf4j
public class InputReader implements CommandLineRunner {

    private final RequestDecider requestDecider;

    public InputReader(RequestDecider requestDecider) {
        this.requestDecider = requestDecider;
    }

    @Override
    public void run(String... args) throws IOException {
        log.info("Введіть Ваш запит. Для того, щоб завершити роботу введіть 0!");
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while (!line.equals("0")) {
            line = buffReader.readLine();
            requestDecider.getNeededRequest(line);
        }

        System.exit(0);
    }
}
