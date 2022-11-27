package com.axitera.graph.service.impl;

import com.axitera.graph.entity.Users;
import com.axitera.graph.mapper.UserMapper;
import com.axitera.graph.model.EmployeesView;
import com.axitera.graph.repo.RepoUsers;
import com.axitera.graph.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final RepoUsers repoUsers;
    private final UserMapper userMapper = UserMapper.INSTANCE;


    @Override
    public List<EmployeesView> findAll(LocalDateTime start, LocalDateTime end) {
        return getEmployeesByChiefId(null, start, end);
    }

    private List<EmployeesView> getEmployeesByChiefId(String chiefId, LocalDateTime start, LocalDateTime end) {
        List<Users> usersByChief = repoUsers.findUsersByChiefAndCreationTimeGreaterThanEqualAndCloseTimeLessThanEqual(chiefId, start, end);
        List<EmployeesView> employeeViewList = userMapper.getEmployeeViewList(usersByChief);

        for (EmployeesView employeesView : employeeViewList) {
            employeesView.setChildren(getEmployeesByChiefId(String.valueOf(employeesView.getUsers().getPersonal_nr()), start, end));
            for (EmployeesView view : employeesView.getChildren()) {
                if (view.getUsers().getRoles().equals("OBOLUS_TEAM_LEAD")) {
                    employeesView.setTln(employeesView.getTln() + 1);
                }
            }
        }
        return employeeViewList;
    }

    @Override
    public Users findById(int theId) {
        Optional<Users> result = repoUsers.findById(theId);

        Users users = null;

        if (result.isPresent()) {
            users = result.get();
        } else {
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
