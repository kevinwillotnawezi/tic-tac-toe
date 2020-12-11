package com.example.tictactoe.dao;

import com.example.tictactoe.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultDao extends JpaRepository<Result, Long> {
}
