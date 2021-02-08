package edu.isel.csee.TesterForDB.repository;

import edu.isel.csee.TesterForDB.domain.document.Policy;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PolicyRepository extends MongoRepository<Policy, Long> {
}
