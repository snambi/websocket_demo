package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude=EmbeddedServletContainerAutoConfiguration.class)
public class DemoWsApplication {

    public static void main(String[] args) {
    	
    
        SpringApplication.run( DemoWsApplication.class, args);
    }
    
    
//    
//    @Bean
//    public ServletContextAware endpointExporterInitializer(final ApplicationContext applicationContext) {
//    	
//    	ServletContextAware sca = new ServletContextAware() {
//            @Override
//            public void setServletContext(ServletContext servletContext) {
//                ServerEndpointExporter exporter = new ServerEndpointExporter();
//                exporter.setApplicationContext(applicationContext);
//                exporter.afterPropertiesSet();
//            }
//        };
//        
//        return sca;
//    }
}
