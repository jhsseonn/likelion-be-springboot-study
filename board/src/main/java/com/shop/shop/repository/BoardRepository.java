package com.shop.shop.repository;

import com.shop.shop.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByBoardNm(int boardNm);

    List<Board> findByBoardTitleOrBoardDetail(String boardTitle, String boardDetail);

    List<Board> findByBoardNmLessThan(int boardNm);

    @Query("select i from Board i where i.boardDetail like %:boardDetail% order by i.boardNm desc")
    List<Board> findByBoardDetail(@Param("boardDetail") String boardDetail);
}
