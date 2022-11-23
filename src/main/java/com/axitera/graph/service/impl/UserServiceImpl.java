package com.axitera.graph.service.impl;

import com.axitera.graph.entity.Users;
import com.axitera.graph.repo.RepoUsers;
import com.axitera.graph.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final RepoUsers repoUsers;

    @Override
    public List<Users> findAll() {
        return repoUsers.findAllByOrderByEmailAsc();
    }

    @Override
    public Users findById(int theId) {
        Optional<Users> result = repoUsers.findById(theId);

        Users users = null;

        if (result.isPresent()) {
            users = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return users;
    }


    @Override
    public void save(Users users) {
        repoUsers.save(users);
    }

    @Override
    public void deleteById(int theId) {
        repoUsers.deleteById(theId);
    }
}
