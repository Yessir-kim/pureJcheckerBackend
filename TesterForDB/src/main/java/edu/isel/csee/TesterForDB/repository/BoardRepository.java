package edu.isel.csee.TesterForDB.repository;

import edu.isel.csee.TesterForDB.domain.document.Board;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BoardRepository extends MongoRepository<Board, Long> {
    Optional<Board> findById(String id);
    Long deleteById(String id);
}
