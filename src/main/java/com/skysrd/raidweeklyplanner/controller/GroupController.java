package com.skysrd.raidweeklyplanner.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @PostMapping("")
    public ResponseEntity<?> createGroup(@RequestBody GroupRequest groupRequest) {
        return ResponseEntity.ok(groupService.createGroup(groupRequest));
    }

    @DeleteMapping("/{groupId}")
    public void deleteGroup(@PathVariable Long groupId) {
        groupService.deleteGroup(groupId);
    }

    @GetMapping("")
    public ResponseEntity<?> getGroups() {
        return ResponseEntity.ok(groupService.getGroups);
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<?> getGroup(@PathVariable Long groupId) {
        return ResponseEntity.ok(groupService.getGroup);
    }

    @GetMapping("/details/{groupId}")
    public ResponseEntity<?> getGroupDetail(@PathVariable Long groupId) {
        return ResponseEntity.ok(groupService.getGroupDetail);
    }
}
