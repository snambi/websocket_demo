package demo;

import javax.servlet.ServletContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@SpringBootApplication
public class DemoWsApplication {

    public static void main(String[] args) {
    	
    
        SpringApplication.run( DemoWsApplication.class, args);
    }
    
    @Bean
    public ServletContextAware endpointExporterInitializer(final ApplicationContext applicationContext) {
    	
    	ServletContextAware sca = new ServletContextAware() {
            @Override
            public void setServletContext(ServletContext servletContext) {
                ServerEndpointExporter exporter = new ServerEndpointExporter();
                exporter.setApplicationContext(applicationContext);
                exporter.afterPropertiesSet();
            }
        };
        
        return sca;
    }
}
