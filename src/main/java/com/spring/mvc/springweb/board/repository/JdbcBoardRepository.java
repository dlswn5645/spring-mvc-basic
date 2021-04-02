package com.spring.mvc.springweb.board.repository;

import com.spring.mvc.springweb.board.domain.Board;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("jdbcBoardRepo")
public class JdbcBoardRepository implements BoardRepository{

    //설정정보 필드 등록
    private String userId = "java_web3";
    private String userPw = "202104";
    private String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";//db접속 위치
    private String driverName = "oracle.jdbc.driver.OracleDriver";//드라이버 클래스이름

    //tbl_board(board_no(int),writer,title,content(String))
    //SELECTALL
    @Override
    public List<Board> getArticles() {
        List<Board> boardList = new ArrayList<>();
        Connection connection = null;

        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(dbUrl, userId, userPw);
            String sql = "SELECT * FROM tbl_board";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Board findBoard = new Board(
                        resultSet.getInt("board_no"),
                        resultSet.getString("writer"),
                        resultSet.getString("title"),
                        resultSet.getString("content")
                );

                boardList.add(findBoard);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return boardList;
    }

    //INSERT
    @Override
    public void insertArticle(Board article) {
        Connection connection = null;

        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(dbUrl,userId,userPw);
            String sql = "INSERT INTO tbl_board (board_no,writer,title,content)" +
                    "VALUES(seq_board.nextval,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, article.getWriter());
            statement.setString(2,article.getTitle());
            statement.setString(3,article.getContent());

            statement.executeUpdate();

            System.out.println("데이터 입력 성공");
        } catch (Exception e) {
            System.out.println("데이터 입력 실패");
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //DELETE
    @Override
    public void deleteArticle(int BoardNo) {

        Connection connection = null;

        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(dbUrl, userId, userPw);
            String sql = "DELETE FROM tbl_board WHERE board_no=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,BoardNo);
            statement.executeUpdate();

            System.out.println("데이터 삭제 성공");

        } catch (Exception e) {
            System.out.println("데이터 삭제 실패");
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    //SELECT
    @Override
    public Board getContent(int boardNo) {

        Connection connection = null;

        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(dbUrl, userId, userPw);
            String sql = "SELECT * FROM tbl_board WHERE board_no=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, boardNo);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                return new Board(
                        resultSet.getInt("board_no"),
                        resultSet.getString("writer"),
                        resultSet.getString("title"),
                        resultSet.getString("content")
                );

            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //UPDATE
    @Override
    public void modifyArticle(Board Article) {
        Connection connection = null;

        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(dbUrl, userId, userPw);
            String sql = "UPDATE tbl_board SET writer=?,title=?,content=? WHERE board_no=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, Article.getWriter());
            statement.setString(2, Article.getTitle());
            statement.setString(3, Article.getContent());
            statement.setInt(4, Article.getBoardNo());
            statement.executeUpdate();

            System.out.println("데이터 수정 성공");

        } catch (Exception e) {
            System.out.println("데이터 수정 실패");
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
