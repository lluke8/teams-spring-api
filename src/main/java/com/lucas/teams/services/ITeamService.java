package com.lucas.teams.services;

import com.lucas.teams.models.Team;

import java.util.List;

public interface ITeamService {
    List<Team> getAll();
    Team create(Team team);
}
