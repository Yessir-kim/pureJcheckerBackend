package edu.isel.csee.backend.service;

import edu.isel.csee.backend.repository.GradeRepository;
import edu.isel.csee.backend.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;

;

public class SpringConfig {

    private final GradeRepository gradeRepository;
    private final TokenRepository tokenRepository;

    @Autowired
    public SpringConfig(GradeRepository gradeRepository,
                        TokenRepository tokenRepository) {

        this.gradeRepository = gradeRepository;
        this.tokenRepository = tokenRepository;
    }

    @Bean
    MongoTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
        return new MongoTransactionManager(dbFactory);
    }
    
    @Bean
    public GradeService gradeService() { return new GradeService(gradeRepository); }

    @Bean
    public TokenService tokenService() { return new TokenService(tokenRepository); }

}
