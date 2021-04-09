package com.spring.mvc.springweb.board.api;

import com.spring.mvc.springweb.board.domain.Board;
import com.spring.mvc.springweb.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board/*")
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardMapper boardMapper;

    //게시물 전체 조회
    @GetMapping("/")
    public List<Board> list(){
        List<Board> boardList = boardMapper.getArticles();
        return boardList;
    }

    //게시물 개별 조회
    @GetMapping("/{boardNo}")
    public Board content(@PathVariable int boardNo){
        System.out.println("/api/board/" + boardNo+ " GET요청");
        return boardMapper.getContent(boardNo);
    }

    //게시물 등록
    @PostMapping("/")
    public String write(@RequestBody Board article){
        System.out.println("/api/board/ POST요청: " + article);
        boardMapper.insertArticle(article);
        return "insertSuccess";
    }

    //게시물 수정
    @PutMapping("/{boardNo}")
    public String update(@PathVariable int boardNo, @RequestBody Board article){
        System.out.println("/api/board/ PUT요청: " + article);
        article.setBoardNo(boardNo);
        boardMapper.modifyArticle(article);
        return "updateSuccess";
    }

    //게시물 삭제
    @DeleteMapping("/{boardNo}")
    public String delete(@PathVariable int boardNo){
        System.out.println("/api/board/" + boardNo + " DELETE요청");
        boardMapper.deleteArticle(boardNo);
        return "deleteSuccess";
    }

}
