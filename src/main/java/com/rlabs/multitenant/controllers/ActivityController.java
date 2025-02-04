package com.rlabs.multitenant.controllers;

import com.rlabs.multitenant.beans.Activity;
import com.rlabs.multitenant.repo.ActivityRepo;
import com.rlabs.multitenant.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/get")
    public List<Activity> getAll()
    {
        return this.activityService.getAll();
    }

}
