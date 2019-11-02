package com.lucas.teams.services.impl;

import com.lucas.teams.models.Team;
import com.lucas.teams.services.ITeamService;
import org.springframework.stereotype.Service;
import com.lucas.teams.repositories.ITeamRepository;

import java.util.List;

@Service
public class TeamService implements ITeamService {

    private final ITeamRepository teamRepository;

    public TeamService(ITeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    @Override
    public Team create(Team team) {
        return teamRepository.save(team);
    }
}
