# gecco-spring
gecco爬虫和spring结合使用
##Download

	<dependency>
	    <groupId>com.geccocrawler</groupId>
	    <artifactId>gecco-spring</artifactId>
	    <version>1.0.0</version>
	</dependency>

##QuickStart
	//引入SpringPipelineFactory
	@Resource(name="springPipelineFactory")
	private PipelineFactory springPipelineFactory;

	//启动GeccoEngine时，设置springPipeLineFactory
	GeccoEngine.create()
	.pipelineFactory(springPipelineFactory)
	.classpath("com.geccocrawler.gecco.demo")
	//爬虫userAgent设置
	.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.85 Safari/537.36")
	//开始抓取的页面地址
	.start("https://github.com/xtuhcy/gecco")
	//开启几个爬虫线程
	.thread(1)
	//单个爬虫每次抓取完一个请求后的间隔时间
	.interval(2000)
	.run();
