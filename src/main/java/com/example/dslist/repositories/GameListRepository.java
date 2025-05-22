package com.example.dslist.repositories;

import com.example.dslist.entities.GameList;
import com.example.dslist.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
