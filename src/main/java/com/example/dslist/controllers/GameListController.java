package com.example.dslist.controllers;

import com.example.dslist.dto.GameListDTO;
import com.example.dslist.dto.GameMinDTO;
import com.example.dslist.dto.replacementDTO;
import com.example.dslist.services.GameListService;
import com.example.dslist.services.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/lists" // URL: http://localhost:8080/list
)
@Tag(name = "Game List", description = "Game List API")
public class GameListController {

    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    @GetMapping()
    @Operation(
            summary = "Find all game lists",
            description = "Returns a list of all game lists"
    )
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    @Operation(
            summary = "Find all games by list",
            description = "Returns a list of all games by list"
    )
    public List<GameMinDTO> findByList(@PathVariable("listId") Long listId) {
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    @Operation(
            summary = "Replace game in list",
            description = "Replaces a game in the list"
    )
    public void replace(@PathVariable("listId") Long listId,
                        @RequestBody replacementDTO replacementDTO) {
        gameListService.move(listId, replacementDTO.getSourceIndex(), replacementDTO.getDestinationIndex());
    }

    @GetMapping(value = "/{listId}")
    @Operation(
            summary = "Find game list by ID",
            description = "Returns a game list by ID"
    )
    public GameListDTO findById(@PathVariable("listId") Long listId) {
        return gameListService.findById(listId);
    }
}
