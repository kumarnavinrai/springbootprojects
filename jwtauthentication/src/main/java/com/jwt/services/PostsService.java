package com.jwt.services;

import com.jwt.model.Posts;
import com.jwt.repo.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class PostsService {

    private final String API_URL = "https://jsonplaceholder.typicode.com/posts";

    @Autowired
    private PostsRepository postsRepository;

    public void fetchAndSavePosts() {
        RestTemplate restTemplate = new RestTemplate();
        Posts[] posts = restTemplate.getForObject(API_URL, Posts[].class);

        if (posts != null) {
            for (Posts post : posts) {
                postsRepository.save(post);
            }
        }
    }

    public int updatePostDateTime(Integer postId, LocalDateTime created, LocalDateTime updated) {
        Long p = postId.longValue();
        return postsRepository.updatePostDateTime(p, created, updated);
    }
}
