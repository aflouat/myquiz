package fr.dataup.myquiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(scanBasePackages = "fr.dataup.myquiz")

public class MyquizApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyquizApplication.class, args);
		System.out.println("Hello World");
	}
	@Bean
    public WebMvcConfigurer corsConfigurer(CorsConfig corsConfig) {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(corsConfig.corsConfiguration().getAllowedOrigins().toArray(new String[0]));
            }
        };
    }

}
