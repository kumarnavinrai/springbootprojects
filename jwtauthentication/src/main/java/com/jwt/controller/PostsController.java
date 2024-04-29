package com.jwt.controller;

import com.jwt.model.UpdatePostRequest;
import com.jwt.services.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class PostsController {

    @Autowired
    private PostsService postService;

    @GetMapping("/fetch-posts")
    public String fetchAndSavePosts() {
        postService.fetchAndSavePosts();
        return "Posts fetched and saved successfully!";
    }

    @Transactional
    @PostMapping("/update-posts")
    public String updatePosts(@RequestBody UpdatePostRequest request) {


        int result = postService.updatePostDateTime(request.getPostId(), request.getCreated(), request.getUpdated());
        if (result > 0) {
            return "Posts fetched and updated successfully!";
        } else {
            return "Posts fetched and not updated successfully!";
        }
    }


    @PostMapping("/update-datetime")
    public ResponseEntity<String> updatePostDateTime(@RequestParam Integer postId,
                                                     @RequestParam LocalDateTime created,
                                                     @RequestParam LocalDateTime updated) {

        System.out.println("Post id");
        System.out.println(postId);
        System.out.println("created");
        System.out.println(created);
        System.out.println("updated");
        System.out.println(updated);
        int result = postService.updatePostDateTime(postId, created, updated);
        if (result > 0) {
            return ResponseEntity.ok("Post updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post with ID " + postId + " not found");
        }
    }

}
