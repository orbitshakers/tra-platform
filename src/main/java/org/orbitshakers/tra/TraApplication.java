package org.orbitshakers.tra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

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
