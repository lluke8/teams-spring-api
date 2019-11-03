package com.lucas.teams.services.impl;

import com.lucas.teams.models.Player;
import com.lucas.teams.repositories.IPlayerRepository;
import com.lucas.teams.services.IPlayerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService implements IPlayerService {


    private final IPlayerRepository playerRepository;

    public PlayerService(IPlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }


    @Override
    public List<Player> getAll() {
        return playerRepository.findAll();
    }
}
