package com.skysrd.raidweeklyplanner.controller;

import com.skysrd.raidweeklyplanner.domain.request.GroupRequest;
import com.skysrd.raidweeklyplanner.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.ok(groupService.getGroups());
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<?> getGroup(@PathVariable Long groupId) {
        return ResponseEntity.ok(groupService.getGroup(groupId));
    }

    @GetMapping("/details/{groupId}")
    public ResponseEntity<?> getGroupDetail(@PathVariable Long groupId) {
        return ResponseEntity.ok(groupService.getGroupDetail(groupId));
    }
}
