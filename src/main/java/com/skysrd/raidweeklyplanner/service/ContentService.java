package com.skysrd.raidweeklyplanner.service;

import com.skysrd.raidweeklyplanner.domain.response.ContentResponse;
import com.skysrd.raidweeklyplanner.domain.request.ContentRequest;
import com.skysrd.raidweeklyplanner.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ContentService {
    private final ContentRepository contentRepository;

    @Transactional
    public Long createContent(ContentRequest contentRequest) {
        return contentRepository.save(contentRequest.toContent()).getId();
    }

    @Transactional
    public void updateContent(Long contentId, ContentRequest contentRequest) {
        contentRepository.findById(contentId)
                .orElseThrow(()-> new IllegalArgumentException("Content를 찾을 수 없습니다."))
                .updateContent(
                        contentRequest.getName(),
                        contentRequest.getMinLevel(),
                        contentRequest.getMaxLevel(),
                        contentRequest.getReward()
                );
    }

    public List<ContentResponse> getContents() {
        return contentRepository.findAll().stream()
                .map(ContentResponse::toResponse)
                .collect(Collectors.toList());
    }

    public ContentResponse getContent(Long contentId) {
        return contentRepository.findById(contentId)
                .map(ContentResponse::toResponse)
                .orElseThrow(()->new IllegalArgumentException("Content not found"));
    }
}
