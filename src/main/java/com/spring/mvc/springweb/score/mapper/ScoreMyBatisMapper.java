package com.spring.mvc.springweb.score.mapper;

import com.spring.mvc.springweb.score.domain.Score;

import org.apache.ibatis.annotations.Mapper;



import java.util.List;

@Mapper
public interface ScoreMyBatisMapper {

    //점수 저장 기능
    void insertScore(Score score);
//    @Insert("INSERT INTO tbl_score " +
//            "(stu_num, name, kor, eng, math, total, average)" +
//            "VALUES (seq_score.nextval, #{score.name}, #{score.kor}, #{score.eng}," +
//            " #{score.math}, #{score.total}, #{score.average})")
//    void insertScore(@Param("score") Score score);

    //전체 점수 조회 기능
    List<Score> selectAllScores();

    //개별 점수 조회 기능
    Score selectOne(int stuNum);

    //점수 삭제 기능
    void deleteScore(int stNum);
}
