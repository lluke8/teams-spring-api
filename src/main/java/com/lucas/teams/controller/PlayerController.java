package com.lucas.teams.controller;

import com.lucas.teams.models.Player;
import com.lucas.teams.models.Team;
import com.lucas.teams.services.IPlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/players")
public class PlayerController {

    private final IPlayerService playerService;


    public PlayerController(IPlayerService playerService){
        this.playerService = playerService;
    }


    @GetMapping(value = "/list")
    public ResponseEntity<List<Player>> getAll(){
        List<Player> players = playerService.getAll();
        return ResponseEntity.ok().body(players);
    }
}
