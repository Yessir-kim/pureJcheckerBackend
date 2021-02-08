package edu.isel.csee.TesterForDB.controller.api;

import edu.isel.csee.TesterForDB.domain.document.Board;
import edu.isel.csee.TesterForDB.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@AllArgsConstructor // Not required @Autowired
@RequestMapping(value="/api/notification") // base url
public class BoardController {

    private BoardService boardService;

    @GetMapping("/")
    public String list(Model model) {
        List<Board> boardList = boardService.getBoardlist();

        model.addAttribute("boardList", boardList);
        return "board/list.html";
    }

    @GetMapping("/post/{id}")
    public String detail(@PathVariable("id") String id, Model model) {
        Board board = boardService.getPost(id);

        model.addAttribute("board", board);
        return "board/detail.html";
    }

    @GetMapping("/post/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        Board board = boardService.getPost(id);

        model.addAttribute("board", board);
        return "board/update.html";
    }

    @GetMapping("/post")
    public String write() {
        return "board/write.html";
    }

    // method = POST 요청이 들어오면 처리하는 부분
    // board 형식과 동일한 객체를 받으면 해당 객체에 생성일, 수정일을 추가하여 저장
    @RequestMapping(value="/post", method= RequestMethod.POST)
    public String write(Board board) {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String nowDate = format.format(new Date());

        board.setCreatedDate(nowDate);
        board.setModifiedDate(nowDate);

        boardService.savePost(board);

        return "redirect:/api/notification/";
    }

    // method = DELETE 요청이 들어오면 처리하는 부분
    // id 통해서 원하는 board 삭제 가능
    @RequestMapping(value="/post/{id}", method= RequestMethod.DELETE)
    public String delete(@PathVariable("id") String id) {

        boardService.deletePost(id);

        return "redirect:/api/notification/";
    }

    // method = PUT 요청이 들어오면 처리하는 부분
    // MongoRepository 에서는 동일한 id를 넣고 다른 부분만 수정하면 save 통해서도 update 가능
    // ModifiedDate update 후 서비스에 전송
    @RequestMapping(value="/post/edit/{id}", method= RequestMethod.PUT)
    public String update(Board board) {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String nowDate = format.format(new Date());
        board.setModifiedDate(nowDate);

        boardService.savePost(board);

        return "redirect:/api/notification/";
    }
}
