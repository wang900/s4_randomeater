package fontys.randomeater;

import fontys.randomeater.builder.ResponseBuilder;
import fontys.randomeater.builder.ResponseDirector;
import fontys.randomeater.builder.RestResponseBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RandomEaterApplication {

	public static void main(String[] args) {
		SpringApplication.run(RandomEaterApplication.class, args);
	}

	@Bean
	public ResponseDirector responseDirector() {
		return new ResponseDirector();
	}

	@Bean
	public ResponseBuilder responseBuilder() {
		return new RestResponseBuilder();
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");
			}
		};
	}
}
