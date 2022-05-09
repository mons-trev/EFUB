package jieun.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jieun.board.dto.BoardDto;
import jieun.board.service.BoardService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/")
    public String list(Model model) {
        List<BoardDto> boardDtoList = boardService.getBoardList();
        model.addAttribute("postList", boardDtoList);
        return "board/list.html";
    }

    @GetMapping("/post")
    public String post() {
        return "board/post.html";
    }

    @PostMapping("/post")
    public String write(BoardDto boardDto) {
        boardService.savePost(boardDto);
        return "redirect:/";
    }

    @GetMapping("/post/{id}")
    public String detail(@PathVariable("id") Long id,Model model){
        BoardDto boardDto = boardService.getPost(id);
        model.addAttribute("post",boardDto);
        return "board/detail.html";
    }


    @DeleteMapping("/post/{id}")
    public String deletePost(@PathVariable("id") Long id) {
        boardService.deletePost(id);
        return "redirect:/";
    }

}
