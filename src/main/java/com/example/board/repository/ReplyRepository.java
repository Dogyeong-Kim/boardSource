package com.example.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.example.board.entity.Reply;
import java.util.List;
import com.example.board.entity.Board;

public interface ReplyRepository extends JpaRepository<Reply, Long>, QuerydslPredicateExecutor<Reply> {
    // bno 를 기준으로 삭제
    // DELETE FROM reply WHERE board_bno = 1

    @Modifying // delete, update 무조건 사용해야 함
    @Query("DELETE FROM Reply r WHERE r.board.bno = :bno")
    void deleteByBoardBno(Long bno);

    // 특정 글 조회시 달려있는 댓글 모두 가져오기
    List<Reply> findByBoardOrderByRno(Board board);
}
