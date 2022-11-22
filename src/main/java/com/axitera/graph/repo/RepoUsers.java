package com.axitera.graph.repo;

import com.axitera.graph.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoUsers extends JpaRepository<Users, String> {
}
