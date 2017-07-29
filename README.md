# gecco-spring
gecco爬虫和spring结合使用。1.2.9版本开始支持spring-boot。spring升级到4.x。
## Download

	<dependency>
	    <groupId>com.geccocrawler</groupId>
	    <artifactId>gecco-spring</artifactId>
	    <version>x.x.x</version>
	</dependency>
![maven](https://img.shields.io/maven-central/v/com.geccocrawler/gecco-spring.svg?style=flat-square)
## 初始化Gecco
加载完成bean后启动Gecco，可以通过继承SpringGeccoEngine类，初始化你的GeccoEngine，需要特别注意的是GeccoEngine需要用非阻塞模式start()运行:

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
## 开发Pipeline
pipeline的开发和之前一样，唯一不同的是不需要@PipelineName("consolePipeline")定义pipeline的名称，而是使用spring的@Service定义，spring的bean名称即为pipeline的名称。可以参考：

	@Service("consolePipeline")
	public class ConsolePipeline implements Pipeline<SpiderBean> {
		@Override
		public void process(SpiderBean bean) {
			System.out.println(JSON.toJSONString(bean));
		}
	}
也可以使用@Configuration和@Bean定义pipeline。如：

    @Configuration
    public class BeanConfigure {
        
        @Bean(name="consolePipeline")
        public ConsolePipeline consolePipeline() {
            return new ConsolePipeline();
        }
    }
## DEMO
参考源代码中测试用例src/test，有详细的例子