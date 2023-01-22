package com.example.questapp.webApi.controllers;

import com.example.questapp.business.CommentService;
import com.example.questapp.business.requests.CommentCreateRequest;
import com.example.questapp.business.requests.CommentUpdateRequest;
import com.example.questapp.entities.Comment;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId,
                                        @RequestParam Optional<Long> postId){
        return commentService.getAllCommentsWithParam(userId,postId);
    }

    @PostMapping
    public Comment createOneComment(@RequestBody CommentCreateRequest request){
        return commentService.createOneComment(request);
    }

    @GetMapping("/{commentId}")
    public Comment getOneComment(@PathVariable Long commentId){
        return commentService.getOneCommentById(commentId);
    }

    @PutMapping("/{commentId}")
    public Comment updateOneComment(@PathVariable Long  commentId, @RequestBody CommentUpdateRequest request){
        return commentService.updateOneCommentById(commentId,request);
    }

    @DeleteMapping("/{commentId}")
    public void deleteOneComment(@PathVariable Long commentId){
        commentService.deleteOneCommentById(commentId);
    }
}
