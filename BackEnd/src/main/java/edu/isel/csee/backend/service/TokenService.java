package edu.isel.csee.backend.service;

import edu.isel.csee.backend.controller.RestException;
import edu.isel.csee.backend.form.document.Token;
import edu.isel.csee.backend.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TokenService {

    private final TokenRepository tokenRepository;

    @Autowired
    public TokenService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Transactional
    public List<Token> getTokenList() { return tokenRepository.findAll(); }

    @Transactional
    public Token saveToken(Token token) {

        validateDuplicateToken(token);

        return tokenRepository.save(token);
    }

    @Transactional
    public Long deleteToken(String token) {

        validateExistenceUser(token);

        return tokenRepository.deleteByToken(token);
    }

    @Transactional
    public Token getToken(String token) {

        validateExistenceUser(token);

        Optional<Token> tokenEntityWrapper = tokenRepository.findByToken(token);
        Token tokenEntity = tokenEntityWrapper.get();

        Token result = new Token
                (
                        tokenEntity.getId(),
                        tokenEntity.getToken(),
                        tokenEntity.getItoken(),
                        tokenEntity.getGroup(),
                        tokenEntity.getClassName(),
                        tokenEntity.getInstructor(),
                        tokenEntity.isFeedback(),
                        tokenEntity.getCreateDate(),
                        tokenEntity.getDueDate(),
                        tokenEntity.getPoint(),
                        tokenEntity.getCompiled(),
                        tokenEntity.getOracle(),
                        tokenEntity.getPackages(),
                        tokenEntity.getClasses(),
                        tokenEntity.getCustomException(),
                        tokenEntity.getCustomStructure(),
                        tokenEntity.getOverriding(),
                        tokenEntity.getOverloading(),
                        tokenEntity.getThread(),
                        tokenEntity.getJavadoc(),
                        tokenEntity.getEncapsulation(),
                        tokenEntity.getInheritSuper(),
                        tokenEntity.getInheritInterface(),
                        tokenEntity.getCount(),
                        tokenEntity.getFilePath()
                );

        return result;
    }

    private void validateDuplicateToken(Token token) {
        tokenRepository.findByToken(token.getToken())
                .ifPresent(m -> {
                    throw new RestException(HttpStatus.INTERNAL_SERVER_ERROR, token.getToken() + " already exist!");
                });
    }

    private void validateExistenceUser(String token) {
        if(tokenRepository.findByToken(token).isEmpty())
            throw new RestException(HttpStatus.INTERNAL_SERVER_ERROR, "No existence in DB "+ "(" + token + ")");
    }
}
