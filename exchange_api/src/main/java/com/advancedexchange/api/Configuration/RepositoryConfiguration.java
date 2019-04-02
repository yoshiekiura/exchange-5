package com.advancedexchange.api.Configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.advancedexchange.api.Entities"})
@EnableJpaRepositories(basePackages = {"com.advancedexchange.api.Repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {

}

/*
While this is an empty Java class file, each of the annotations is very important.

    @Configuration  tells the Spring Framework this is a Java configuration class.
    @EnableAutoConfiguration tells Spring Boot to do its auto configuration magic. This is what has Spring Boot automatically create the Spring Beans with sensible defaults for our tests.
    @EntityScan specifies the packages to look for JPA Entities.
    @EnableJpaRepositories enables the auto configuration of Spring Data JPA.
    @EnableTransactionManagement Enables Spring’s annotation driven transaction management

 */