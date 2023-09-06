package com.crewtest.bots.utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class InputReader implements CommandLineRunner {

    private final RequestDecider requestDecider;

    public InputReader(RequestDecider requestDecider) {
        this.requestDecider = requestDecider;
    }

    @Override
    public void run(String... args) throws IOException {
        System.out.println("Введіть Ваш запит!");
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while (!line.equals("0")) {
            line = buffReader.readLine();
            requestDecider.getNeededRequest(line);
        }

        System.exit(0);
    }
}
