# gecco-spring
gecco爬虫和spring结合使用
##Download

	<dependency>
	    <groupId>com.geccocrawler</groupId>
	    <artifactId>gecco-spring</artifactId>
	    <version>x.x.x</version>
	</dependency>
![maven](https://img.shields.io/maven-central/v/com.geccocrawler/gecco-spring.svg?style=flat-square)
##使用注解方式配置Spring

扫描com.geccocrawler.gecco.spring，自动注入springPipelineFactory和consolePipeline

	<context:component-scan base-package="com.geccocrawler.gecco.spring" />

##使用非注解方式配置Spring

手动增加bean：springPipelineFactory和consolePipeline

	<bean id="springPipelineFactory" class="com.geccocrawler.gecco.spring.SpringPipelineFactory"/>
	
	<bean id="consolePipeline" class="com.geccocrawler.gecco.spring.ConsolePipeline"/>

##初始化Gecco
加载完成bean后启动Gecco，可以通过继承SpringGeccoEngine类，初始化你的GeccoEngine，需要特别注意的是GeccoEngine需要用非阻塞模式***start()***运行:

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

##DEMO
参考源代码中测试用例src/test，有详细的例子