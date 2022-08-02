package com.skysrd.raidweeklyplanner.controller;

import com.skysrd.raidweeklyplanner.domain.request.RaidRequest;
import com.skysrd.raidweeklyplanner.service.RaidService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/raid")
public class RaidController {
    private final RaidService raidService;

    @GetMapping("")
    public ResponseEntity<?> getRaids() {
        return ResponseEntity.ok(raidService.getRaids());
    }

    @GetMapping("/{raidId}")
    public ResponseEntity<?> getRaid(@PathVariable Long raidId) {
        return ResponseEntity.ok(raidService.getRaid(raidId));
    }

    @PostMapping("")
    public ResponseEntity<?> createRaid(@RequestBody RaidRequest raidRequest) {
        return ResponseEntity.ok(raidService.createRaid(raidRequest));
    }

    @DeleteMapping("/{raidId}")
    public void deleteRaid(@PathVariable Long raidId) {
        raidService.deleteRaid(raidId);
    }
}
