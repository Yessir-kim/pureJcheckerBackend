package edu.isel.csee.backend.repository;

import edu.isel.csee.backend.form.document.Grade;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface GradeRepository extends MongoRepository<Grade, Long> {
    Optional<Grade> findByStudentNumAndToken(String studentNum, String token);
    Long deleteById(String id);
    List<Grade> findByItoken(String itoken);
}
