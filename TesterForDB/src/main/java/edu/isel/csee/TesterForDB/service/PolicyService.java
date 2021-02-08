package edu.isel.csee.TesterForDB.service;

import edu.isel.csee.TesterForDB.domain.document.Board;
import edu.isel.csee.TesterForDB.domain.document.Policy;
import edu.isel.csee.TesterForDB.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PolicyService {

    private final PolicyRepository policyRepository;

    @Autowired
    public PolicyService(PolicyRepository policyRepository) { this.policyRepository = policyRepository; }

    @Transactional
    public void savePost(Policy policy) {
        policyRepository.save(policy);
    }
}
