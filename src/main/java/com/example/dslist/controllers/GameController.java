package com.example.dslist.controllers;

import com.example.dslist.dto.GameDTO;
import com.example.dslist.dto.GameMinDTO;
import com.example.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/games"
)
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll() {
        return gameService.findAll();
    }

    @GetMapping(value = "/{id}")
    public GameDTO findById(
            @PathVariable("id") Long id) {
        return gameService.findById(id);
    }
}
