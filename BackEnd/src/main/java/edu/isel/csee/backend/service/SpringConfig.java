package edu.isel.csee.backend.service;

import edu.isel.csee.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

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
    public GradeService gradeService() { return new GradeService(gradeRepository); }

    @Bean
    public TokenService tokenService() { return new TokenService(tokenRepository); }

}
