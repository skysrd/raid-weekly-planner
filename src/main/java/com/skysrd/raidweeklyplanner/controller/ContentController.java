package com.skysrd.raidweeklyplanner.controller;

import com.skysrd.raidweeklyplanner.domain.request.ContentRequest;
import com.skysrd.raidweeklyplanner.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;

@RestController
@RequiredArgsConstructor
@RequestMapping("/content")
public class ContentController {
    private final ContentService contentService;

    @PostMapping("")
    public ResponseEntity<?> createContent(@RequestBody ContentRequest contentRequest) {
        return ResponseEntity.ok(contentService.createContent(contentRequest));
    }

    @GetMapping("")
    public ResponseEntity<?> getContents() {
        return ResponseEntity.ok(contentService.getContents());
    }

    @GetMapping("/{contentId}")
    public ResponseEntity<?> getContent(@PathVariable Long contentId) {
        return ResponseEntity.ok(contentService.getContent(contentId));
    }

    @PatchMapping("/{contentId}")
    public void updateContent(@PathVariable Long contentId, @RequestBody ContentRequest contentRequest) {
        contentService.updateContent(contentId, contentRequest);
    }
}
