package com.spring.mvc.springweb.score.api;

import com.spring.mvc.springweb.score.domain.Score;
import com.spring.mvc.springweb.score.mapper.ScoreMyBatisMapper;
import com.spring.mvc.springweb.score.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/score/*")
@RequiredArgsConstructor
//REST 요청 방식 : GET(조회), POST(등록), PUT(수정), DELETE(삭제)
public class ScoreApiController {

    private final ScoreMyBatisMapper scoreMapper;
    private final ScoreService scoreService;

    //점수 목록 조회 GET(조회)
    @GetMapping("/")
    public List<Score> list(){
        List<Score> scoreList = scoreMapper.selectAllScores();
        return scoreList;
    }

    //점수 등록 POST(등록)
    @PostMapping("/")
    //@RequestBody : 클라이언트가 보낸 JSON 데이터를 파싱해서 자바 객체로 생성해줌
    public String register(@RequestBody Score score){
        System.out.println("/api/score/ POST요청: " + score);
        scoreService.insertService(score);
        return "regSuccess";
    }

    //개별 점수 조회
    /*
        *REST API URI 설계 원칙
        ex) 게시판
        *GET(조회):
        * -전체:/board
        * -단일:/board/27
        * POST:/board
        * PUT:/board/27
        * DELETE:/board/27
     */
    @GetMapping("/{stuNum}")
    //@PathVariable : URI에서 데이터를 읽어서 파라미터에 저장하겠다.
    public Score getScore(@PathVariable int stuNum){
        System.out.println("/api/score/" + stuNum + " GET요청");
        return scoreMapper.selectOne(stuNum);
    }

    //점수 정보 삭제
    @DeleteMapping("/{stuNum}")
    public String delete(@PathVariable int stuNum){
        System.out.println("/api/score/" + stuNum + " DELETE요청");
        scoreMapper.deleteScore(stuNum);
        return "deleteSuccess";
    }

}
