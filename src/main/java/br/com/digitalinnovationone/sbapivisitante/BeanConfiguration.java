package br.com.digitalinnovationone.sbapivisitante;

import br.com.digitalinnovationone.VisitanteRepositoryPort;
import br.com.digitalinnovationone.VisitanteService;
import br.com.digitalinnovationone.VisitanteServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    VisitanteRepositoryPort visitanteRepositoryPort() {
        return new VisitanteRepositoryImpl();
    }

    @Bean
    VisitanteServicePort visitanteServicePort() {
        return new VisitanteService(visitanteRepositoryPort());
    }

}
