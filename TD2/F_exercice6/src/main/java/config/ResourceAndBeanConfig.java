package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import services.Compteur;
import services.Facade;

@Configuration
public class ResourceAndBeanConfig {

    @Bean
    public Facade facade(Compteur compteur) {
        return new Facade(compteur);
    }

    @Bean
    public Compteur compteur() {
        return new Compteur();
    }
}
