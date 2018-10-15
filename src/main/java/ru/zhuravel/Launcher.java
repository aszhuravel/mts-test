package ru.zhuravel;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import ru.zhuravel.configuration.ServerConfiguration;

@Configuration
public class Launcher {
    public static void main(String[] args) throws Exception {
        new AnnotationConfigApplicationContext(ServerConfiguration.class);
    }
}