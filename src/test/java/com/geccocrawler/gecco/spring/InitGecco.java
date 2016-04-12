package com.geccocrawler.gecco.spring;

import org.springframework.stereotype.Service;

import com.geccocrawler.gecco.GeccoEngine;

@Service
public class InitGecco extends SpringGeccoEngine {

	@Override
	public void init() {
		GeccoEngine.create()
		.pipelineFactory(springPipelineFactory)
		.classpath("com.geccocrawler.gecco.spring")
		.start("https://github.com/xtuhcy/gecco")
		.interval(3000)
		.start();
	}

}
