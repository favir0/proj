package com.fadee.proj.games.services;

import com.fadee.proj.games.repositories.DeveloperRepository;

public class DeveloperService {
    private final DeveloperRepository developerRepository;

    public DeveloperService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }


}
