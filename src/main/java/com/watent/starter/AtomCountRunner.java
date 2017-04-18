package com.watent.starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.repository.CrudRepository;

import java.util.Arrays;
import java.util.Collection;

/**
 * AtomCountRunner
 * <p>
 * Created by Atom on 2017/4/17.
 */
public class AtomCountRunner implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(AtomCountRunner.class);

    private Collection<CrudRepository> repositories;

    AtomCountRunner(Collection<CrudRepository> repositories) {
        this.repositories = repositories;
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.info("info:{}", Arrays.toString(strings));
        repositories.forEach(crudRepository -> {
            logger.info(String.format("%s has %s entries",
                    getRepositoryName(crudRepository.getClass()),
                    crudRepository.count()));
        });
    }

    private static String getRepositoryName(Class crudRepositoryClass) {
        for (Class repositoryInterface : crudRepositoryClass.getInterfaces()) {
            return repositoryInterface.getSimpleName();
//            if (repositoryInterface.getName().startsWith("com.watent.cloud")) {
//
//            }
        }
        return "UnknownRepository";
    }
}
