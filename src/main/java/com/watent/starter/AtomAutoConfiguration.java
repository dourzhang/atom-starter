package com.watent.starter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * Atom AutoConfiguration
 * <p>
 * Created by Atom on 2017/4/17.
 */
@Configuration
public class AtomAutoConfiguration {

    @Bean
    public AtomCountRunner atomCountRunner(Collection<CrudRepository> repositories) {
        return new AtomCountRunner(repositories);
    }
}
