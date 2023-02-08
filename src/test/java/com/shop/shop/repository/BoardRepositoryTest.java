package com.shop.shop.repository;

import com.shop.shop.entity.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@SpringBootTest
class BoardRepositoryTest {

    @Autowired
    private BoardRepository BoardRepo;

    @PersistenceContext
    EntityManager em;

    @Test
    @DisplayName("게시글_등록_테스트")
    public void BoardEnrollTest(){
        Board board = new Board();

        board.setId(1L);
        board.setTitle("첫번째 게시글");
        board.setWriter("acho");
        board.setContents("내용이에요");
        board.setRegTime(LocalDateTime.now());

        BoardRepo.save(board);
    }
    @Test
    @DisplayName("게시글_등록_리스트")
    public void BoardListTest(){
        for(int i=2;i<=11;i++){
            Board board = new Board();

            board.setTitle("제목"+i);
            board.setWriter("작성자"+i);
            board.setContents("내용"+i);
            board.setRegTime(LocalDateTime.now());

            BoardRepo.save(board);
        }
    }


    @Test
    @DisplayName("게시글 조회 테스트")
    public void BoardGetTest() {
        System.out.println("1번 게시글 조회");
        Board board = BoardRepo.findById(1L).get();
        System.out.println(board.toString());
    }

    @Test
    @DisplayName("게시글 수정 테스트")
    public void BoardModifyTest() {
        System.out.println("1번 게시글 조회");
        Board board= BoardRepo.findById(1L).get();

        System.out.println("1번 게시글 수정");
        board.setTitle("제목 수정 완료");
        BoardRepo.save(board);
    }

    @Test
    @DisplayName("게시글 삭제 테스트")
    public void BoardDeleteTest() {
        Optional<Board> board = BoardRepo.findById(2L);
        board.ifPresent(selectBoard ->{
            BoardRepo.delete(selectBoard);
        });
        System.out.println("삭제완료");
    }

    @Test
    @DisplayName("쿼리 메서드 이용")
    public void QueryTest(){
        List<Board> list=BoardRepo.findAllByWriter("작성자1");
        for(Board board : list){
            System.out.println(board.getTitle());
        }
    }

}