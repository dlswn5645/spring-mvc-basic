package com.spring.mvc.springweb.board.mapper;

import com.spring.mvc.springweb.board.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    //게시글 목록 가져오기
    List<Board> getArticles();

    //게시글 삭제
    void insertArticle(Board article);

    //게시글 삭제
    void deleteArticle(int BoardNo);

    //게시글 내용보기
    Board getContent(int boardNo);

    //게시글 수정
    void modifyArticle(Board Article);
}
