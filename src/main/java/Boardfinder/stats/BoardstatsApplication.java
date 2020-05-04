package Boardfinder.stats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

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
