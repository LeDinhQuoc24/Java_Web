package vnnhnlm.phantrang_timkiem;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class PhantrangTimkiemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhantrangTimkiemApplication.class, args);
    }
    @Configuration
    @EnableWebMvc
    @EnableTransactionManagement
    @EnableJpaRepositories("vnnhnlm.phantrang_timkiem.repository")
    @ComponentScan("vnnhnlm.phantrang_timkiem")
    @EnableSpringDataWebSupport
    public class ApplicationConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        }
    }

}
