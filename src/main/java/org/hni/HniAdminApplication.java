package org.hni;

import org.hni.data.domain.User;
import org.hni.data.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HniAdminApplication {

    private static final Logger log = LoggerFactory.getLogger(HniAdminApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(HniAdminApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            // save a couple of users
//            repository.save(new User("John", "Doe"));
//            repository.save(new User("Billy", "Bob"));
//            repository.save(new User("Jeff", "Park"));
//            repository.save(new User("John", "Wanye"));
//            repository.save(new User("Jane", "Doe"));
        };
    }

}
