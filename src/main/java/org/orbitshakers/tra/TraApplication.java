package org.orbitshakers.tra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"org.orbitshakers.tra.entity"})
@EnableJpaRepositories(basePackages={"org.orbitshakers.tra.repo"})
@ComponentScan(basePackages={
		"org.orbitshakers.tra", 
		"org.orbitshakers.tra.filter"
})
@SpringBootApplication
public class TraApplication {

	public static void main(String[] args) {
		SpringApplication.run(TraApplication.class, args);
	}

}
