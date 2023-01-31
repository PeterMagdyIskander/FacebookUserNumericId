package com.example.groupservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @RequestMapping("/users/{userProfile}")
    public String getUserID(@PathVariable String userProfile) {
        return groupService.getId(userProfile);
    }

}
