package Boardfinder.stats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableEurekaClient
public class BoardstatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardstatsApplication.class, args);
	}

}
