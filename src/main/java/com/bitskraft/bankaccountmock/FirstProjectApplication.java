package com.bitskraft.bankaccountmock;

import com.bitskraft.bankaccountmock.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.*;
import java.util.Objects;

@SpringBootApplication
public class FirstProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstProjectApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(AddressService addressService) {
        return args -> {
            // read json and write to db
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        Objects.requireNonNull(this.getClass().
                                getResourceAsStream("/nepal-data.json"))));
            } catch (Exception e) {
                System.out.println("Unable to save users: " + e.getMessage());
            }
        };
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
