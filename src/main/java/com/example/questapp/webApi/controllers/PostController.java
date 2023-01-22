package com.example.questapp.webApi.controllers;

import com.example.questapp.business.PostService;
import com.example.questapp.business.requests.PostCreateRequest;
import com.example.questapp.business.requests.PostUpdateRequest;
import com.example.questapp.entities.Post;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId){
        return postService.getAllPosts(userId);
    }

    @GetMapping("/{postId}")
    public Post getOnePost(@PathVariable Long postId){
        return postService.getOnePostById(postId);
    }

    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequest newPostRequst){
        return postService.createOnePost(newPostRequst);
    }

    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Long postId, @RequestBody PostUpdateRequest updatePost){
        return postService.updateOnePostById(postId,updatePost);
    }

    @DeleteMapping("/{postId}")
    public void deleteOnePost(@PathVariable Long postId){
        postService.deleteOnePostById(postId);
    }
}
