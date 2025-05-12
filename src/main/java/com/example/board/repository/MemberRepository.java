package com.example.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.example.board.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String>, QuerydslPredicateExecutor<Member> {
    @EntityGraph(attributePaths = { "roleSet" }, type = EntityGraphType.LOAD)
    Member findByEmailAndFromSocial(String email, boolean fromSocial);
}
