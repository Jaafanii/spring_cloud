package org.sid;

import org.sid.dao.CompanyRepository;
import org.sid.entities.Company;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class CompanyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanyServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CompanyRepository companyRepository){
        return  args->{
            companyRepository.save(new Company((long) 0,"c1",100));
            companyRepository.save(new Company((long) 0,"c2",200));
            companyRepository.save(new Company((long) 0,"c3",300));
            companyRepository.findAll().forEach(System.out::println);
        };
    }
}
