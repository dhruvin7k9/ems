package springBoot.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class EmsApplication extends SpringBootServletInitializer {
	
	@Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	    return builder.sources(EmsApplication.class);
	  }
	
	public static void main(String[] args) {
		SpringApplication.run(EmsApplication.class, args);
	}
}