package com.geccocrawler.gecco.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.geccocrawler.gecco.GeccoEngine;

@SpringBootApplication
@Configuration
public class App {

	@Bean
	public SpringGeccoEngine initGecco() {
		return new SpringGeccoEngine() {
			@Override
			public void init() {
				GeccoEngine.create()
				.pipelineFactory(springPipelineFactory)
				.classpath("com.geccocrawler.gecco.spring")
				.start("https://github.com/xtuhcy/gecco")
				.interval(3000)
				.loop(true)
				.start();
			}
		};
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}
	
}
