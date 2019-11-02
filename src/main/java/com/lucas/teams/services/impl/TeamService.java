package com.lucas.teams.services.impl;

import com.lucas.teams.models.Team;
import com.lucas.teams.services.ITeamService;
import com.lucas.teams.services.exceptions.ObjectNotFoundException;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import com.lucas.teams.repositories.ITeamRepository;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Team update(Team team) {

        if(team.getId()==null){
            throw new ObjectNotFoundException("Invalid id");
        }
       return teamRepository.save(team);

    }

    @Override
    public Team getOne(Integer id) {
        Optional<Team> teamOptional = teamRepository.findById(id);
        if(teamOptional.isPresent()){
            return teamOptional.get();
        }
        throw new ObjectNotFoundException("Invalid id!");
    }
}
