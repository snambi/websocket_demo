package demo.tomcat;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import demo.ServletInitializer;

@Configuration
public class ContainerConfig {

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
	    
		SciTomcatEmbeddedServletContainerFactory factory = new SciTomcatEmbeddedServletContainerFactory();
	    
		//factory.setPort(9000);
		
	    factory.setSessionTimeout(10, TimeUnit.MINUTES);
	    factory.addServletContainerInitializer( ServletInitializer.class );
	    
	    //factory.addErrorPages(new ErrorPage(HttpStatus.404, "/notfound.html");
	    return factory;
	}
}
