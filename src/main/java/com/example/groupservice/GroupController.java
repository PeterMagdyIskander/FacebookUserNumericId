package com.example.groupservice;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    // @RequestMapping("/users/{userProfile}")
    // public String getUserID(@PathVariable String userProfile) {
    // return groupService.getId(userProfile);
    // }

    @RequestMapping("/users")
    public String getUserId(@RequestBody Map<String, String> json) {
        // json = {
        // userProfile: "https://www.facebook.com/profileHandler"
        // }
        return groupService.getId(json.get("userProfile"));
    }

}
