package com.axitera.graph.service;

import com.axitera.graph.entity.Users;
import org.springframework.ui.Model;

import java.util.List;

public interface UserService {

    public List<Users> findAll();

    public Users findById(int theId);

    public void save(Users users);

    public void deleteById(int theId);
}
