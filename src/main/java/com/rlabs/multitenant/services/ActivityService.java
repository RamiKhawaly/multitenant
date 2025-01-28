package com.rlabs.multitenant.services;

import com.rlabs.multitenant.beans.Activity;
import com.rlabs.multitenant.repo.ActivityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepo activityRepo;

    public List<Activity> getAll()
    {
        return this.activityRepo.findAll();
    }
}
