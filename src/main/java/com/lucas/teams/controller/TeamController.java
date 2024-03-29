package com.lucas.teams.controller;


import com.lucas.teams.models.Team;
import com.lucas.teams.services.ITeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/teams")
public class TeamController {

    private final ITeamService teamService;

    public TeamController(ITeamService teamService){
        this.teamService = teamService;
    }
    @GetMapping(value = "/list")
    public ResponseEntity<List<Team>> getAll(){
        List<Team> teams = teamService.getAll();
        return ResponseEntity.ok().body(teams);
    }

    @PostMapping()
    public ResponseEntity<Team> create(@RequestBody Team team){
        Team create = teamService.create(team);
        return new ResponseEntity<>(create, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Team> update(@RequestBody Team team){
        Team update = teamService.update(team);
        return ResponseEntity.ok().body(team);
    }
    @GetMapping("{id}")
    public ResponseEntity<Team> getOne(@PathVariable Integer id){
        Team team = teamService.getOne(id);
        return ResponseEntity.ok().body(team);
    }


}
