package com.geccocrawler.gecco.spring;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.geccocrawler.gecco.pipeline.Pipeline;

@Service
public class SpringConsolePipeline implements Pipeline<MyGithub> {

	@Override
	public void process(MyGithub bean) {
		System.out.println("SpringConsole:"+JSON.toJSON(bean));
	}

}
