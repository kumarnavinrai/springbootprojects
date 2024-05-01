package com.jwt.repo;

import com.jwt.model.Trees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreesRepository extends JpaRepository<Trees,Integer> {
}
