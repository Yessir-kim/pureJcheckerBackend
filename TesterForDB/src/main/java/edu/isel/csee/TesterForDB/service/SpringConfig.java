package edu.isel.csee.TesterForDB.service;

import edu.isel.csee.TesterForDB.repository.BoardRepository;
import edu.isel.csee.TesterForDB.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class SpringConfig {

    private final BoardRepository boardRepository;
    private final PolicyRepository policyRepository;

    @Autowired
    public SpringConfig(BoardRepository boardRepository, PolicyRepository policyRepository) {
        this.boardRepository = boardRepository;
        this.policyRepository = policyRepository;
    }

    @Bean
    public BoardService boardService() {
        return new BoardService(boardRepository);
    }

    @Bean
    public PolicyService policyService() { return new PolicyService(policyRepository); }

}
