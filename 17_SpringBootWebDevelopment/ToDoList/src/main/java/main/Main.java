package main;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import services.ToDoList;

import java.util.concurrent.Executors;

@SpringBootApplication
public class Main {
    private static final int numberOfCores = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        Executors.newFixedThreadPool(numberOfCores).submit(new ToDoList());
    }
}
