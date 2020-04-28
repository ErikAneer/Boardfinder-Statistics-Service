package Boardfinder.stats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/** 
 * Main class of the Stats service
 */
@SpringBootApplication
@EnableEurekaClient
public class BoardstatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardstatsApplication.class, args);
	}

}
