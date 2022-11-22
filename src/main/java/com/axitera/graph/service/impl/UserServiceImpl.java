package com.axitera.graph.service.impl;

import com.axitera.graph.entity.Users;
import com.axitera.graph.repo.RepoUsers;
import com.axitera.graph.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final RepoUsers repoUsers;


    @Override
    public List<Users> getAll() {
        log.info("GetAll is running: ");
        return repoUsers.findAll();
    }
}
