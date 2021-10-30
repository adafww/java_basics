package main;

import org.springframework.boot.SpringApplication;

public class ToDoList implements Runnable{

    @Override
    public void run() {
        SpringApplication.run(Main.class);
    }
}
