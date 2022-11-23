package com.axitera.graph.repo;

import com.axitera.graph.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RepoUsers extends JpaRepository<Users, Integer> {

    public List<Users> findAllByOrderByEmailAsc();
}
