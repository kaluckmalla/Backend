package com.bitskraft.bankaccountmock;

import com.bitskraft.bankaccountmock.dto.CountryDTO;
import com.bitskraft.bankaccountmock.repository.CountryRepository;
import com.bitskraft.bankaccountmock.repository.StateRepository;
import com.bitskraft.bankaccountmock.service.CountryService;
import com.google.gson.Gson;
import com.bitskraft.bankaccountmock.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

@SpringBootApplication
public class FirstProjectApplication {
    private final StateRepository statesRepository;
    private final CountryRepository countryRepository;
    private CountryService countryService;

    public FirstProjectApplication(StateRepository statesRepository,
                                   CountryRepository countryRepository,CountryService countryService) {
        this.statesRepository = statesRepository;
        this.countryRepository = countryRepository;
        this.countryService=countryService;
    }

    public static void main(String[] args) {
        SpringApplication.run(FirstProjectApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            // read json and write to db
            try {
                if(countryRepository.count() == 0) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(
                            Objects.requireNonNull(this.getClass().
                                    getResourceAsStream("/nepal-data.json"))));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line);
                    }
                    Gson gson = new Gson();
                    CountryDTO countrydetails = gson.fromJson(sb.toString(), CountryDTO.class);
                    countryService.save(countrydetails);
                    System.out.println("Users Saved!!");
                }
            }
            catch (Exception e) {
                System.out.println("Unable to save users: " + e.getMessage());
            }
        };
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

}
