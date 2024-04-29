package com.jwt.repo;

import com.jwt.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Modifying
    @Query("UPDATE Posts p SET p.created = :created, p.updated = :updated WHERE p.id = :postId")
    int updatePostDateTime(Long postId, LocalDateTime created, LocalDateTime updated);

}
