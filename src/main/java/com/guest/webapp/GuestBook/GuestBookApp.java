package com.guest.webapp.GuestBook;

import com.guest.webapp.GuestBook.swagger.EnableSwagger2WebMvc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableSwagger2WebMvc


public class GuestBookApp {

    public static void main(String[] args) {
        SpringApplication.run(GuestBookApp.class, args);
    }
}
