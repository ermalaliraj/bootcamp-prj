package com.bootcamp.ms.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication(scanBasePackageClasses = {BootcampProfileApplication.class})
public class BootcampProfileApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootcampProfileApplication.class, args);
    }

}
