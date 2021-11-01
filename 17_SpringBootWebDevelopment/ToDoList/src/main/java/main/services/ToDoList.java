package main.services;
import main.Main;
import org.springframework.boot.SpringApplication;

public class ToDoList implements Runnable{

    @Override
    public void run() {
        SpringApplication.run(Main.class);
    }
}
