package edu.isel.csee.backend.repository;

import edu.isel.csee.backend.form.document.Token;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TokenRepository extends MongoRepository<Token, Long> {
    Long deleteByToken(String token);
    Optional<Token> findByToken(String token);
}
