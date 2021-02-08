package edu.isel.csee.TesterForDB.service;

import edu.isel.csee.TesterForDB.domain.document.Board;
import edu.isel.csee.TesterForDB.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public Board getPost(String id) {
        Optional<Board> boardEntityWrapper = boardRepository.findById(id);
        Board boardEntity = boardEntityWrapper.get();

        Board board = new Board
                (boardEntity.getId(),
                boardEntity.getWriter(),
                boardEntity.getTitle(),
                boardEntity.getContent(),
                boardEntity.getCreatedDate(),
                boardEntity.getModifiedDate()
                );

        return board;
    }

    @Transactional
    public List<Board> getBoardlist() {
        return boardRepository.findAll();
    }

    @Transactional
    public void savePost(Board board) {
        boardRepository.save(board);
    }


    @Transactional
    public void deletePost(String id) { boardRepository.deleteById(id); }
}
