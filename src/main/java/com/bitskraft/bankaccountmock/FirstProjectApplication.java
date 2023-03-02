package com.bitskraft.bankaccountmock;

import com.bitskraft.bankaccountmock.dto.CountryDTO;
import com.bitskraft.bankaccountmock.entity.Country;
import com.bitskraft.bankaccountmock.entity.District;
import com.bitskraft.bankaccountmock.entity.States;
import com.bitskraft.bankaccountmock.entity.StatesRepository;
import com.bitskraft.bankaccountmock.repository.CountryRepository;
import com.bitskraft.bankaccountmock.service.AddressService;
import com.bitskraft.bankaccountmock.service.CountryService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.json.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Objects;

@SpringBootApplication
public class FirstProjectApplication {
    private final StatesRepository statesRepository;
    private final CountryRepository countryRepository;

    public FirstProjectApplication(StatesRepository statesRepository,
                                   CountryRepository countryRepository) {
        this.statesRepository = statesRepository;
        this.countryRepository = countryRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(FirstProjectApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(CountryService countryService) {
        return args -> {
            // read json and write to db
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        Objects.requireNonNull(this.getClass().
                                getResourceAsStream("/nepal-data.json"))));
                StringBuilder sb=new StringBuilder();
                String line;
                while((line= br.readLine())!=null){
                    sb.append(line);
                }
                Gson gson = new Gson();
                CountryDTO countrydetails=gson.fromJson(sb.toString(), CountryDTO.class);
               //System.out.println(countrydetails);
                countryService.save(countrydetails);
            }
            catch (Exception e) {
                System.out.println("Unable to save users: " + e.getMessage());
            }
        };
    }

}
