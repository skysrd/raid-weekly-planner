package com.skysrd.raidweeklyplanner.service;

import com.skysrd.raidweeklyplanner.domain.entity.Group;
import com.skysrd.raidweeklyplanner.domain.entity.MemberGroup;
import com.skysrd.raidweeklyplanner.domain.request.GroupRequest;
import com.skysrd.raidweeklyplanner.domain.response.GroupDetailResponse;
import com.skysrd.raidweeklyplanner.domain.response.GroupResponse;
import com.skysrd.raidweeklyplanner.repository.GroupRepository;
import com.skysrd.raidweeklyplanner.repository.MemberGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GroupService {
    private final GroupRepository groupRepository;
    private final MemberGroupRepository memberGroupRepository;

    public Long createGroup(GroupRequest groupRequest) {
        return groupRepository.save(groupRequest.toEntity()).getId();
    }

    public void deleteGroup(Long groupId) {
        groupRepository.deleteById(groupId);
    }


    public List<GroupResponse> getGroups() {
        return groupRepository.findAll().stream()
                .map(GroupResponse::toResponse)
                .collect(Collectors.toList());
    }

    public GroupResponse getGroup(Long groupId) {
        return groupRepository.findById(groupId)
                .map(GroupResponse::toResponse)
                .orElseThrow(() -> new IllegalArgumentException("Group not found"));
    }

    public GroupDetailResponse getGroupDetail(Long groupId) {
        return null;
    }
}
