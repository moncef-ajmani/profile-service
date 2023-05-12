package com.sid;

import com.sid.dao.ProfileRepository;
import com.sid.entities.Profile;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@SpringBootApplication
@RestController
public class ProfileServiceApplication {
    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello from Profile Service";
    }
    public static void main(String[] args) {
        SpringApplication.run(ProfileServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProfileRepository profileRepository){
        return args -> {
            Stream.of("user1","user2","user3").forEach(p->{
                Profile pf = new Profile();
                pf.setFirstName(p);
                profileRepository.save(pf);
            });
            profileRepository.findAll().forEach(System.out::println);
        };
    }
}
