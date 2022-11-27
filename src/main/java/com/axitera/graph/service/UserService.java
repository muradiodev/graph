package com.axitera.graph.service;

import com.axitera.graph.entity.Users;
import com.axitera.graph.model.EmployeesView;

import java.time.LocalDateTime;
import java.util.List;


public interface UserService {

    List<EmployeesView> findAll(LocalDateTime start, LocalDateTime end);

    Users findById(int theId);

    void save(Users users);

    void deleteById(int theId);
}
