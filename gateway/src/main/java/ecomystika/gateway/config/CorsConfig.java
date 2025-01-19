
package ecomystika.gateway.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    
    
     
    @Override
    public void addCorsMappings(CorsRegistry registry) {
       registry.addMapping("/**")
               
               .allowedOriginPatterns("*")
               .allowedHeaders("*")
              
                .allowedMethods("*");
                      
    }
         @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}