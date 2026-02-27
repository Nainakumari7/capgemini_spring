package spring_hibernate;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "spring_hibernate")
public class ProjectConfiguration {

    @Bean
    public EntityManager getEntity() {
        return Persistence
        		.createEntityManagerFactory("postgres")
        		.createEntityManager();
    }

}