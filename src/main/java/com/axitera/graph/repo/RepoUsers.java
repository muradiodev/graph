package com.axitera.graph.repo;

import com.axitera.graph.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface RepoUsers extends JpaRepository<Users, Integer> {

    List<Users> findAllByOrderByEmailAsc();

    List<Users> findUsersByChief(String chiefId);

    List<Users> findUsersByChiefAndCreationTimeGreaterThanEqualAndCloseTimeLessThanEqual(String chiefId, LocalDateTime start, LocalDateTime end);
}
