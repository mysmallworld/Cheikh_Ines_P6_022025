package com.orion.mdd.controller;

import com.orion.mdd.dto.request.ArticleDto;
import com.orion.mdd.dto.request.CommentDto;
import com.orion.mdd.model.Article;
import com.orion.mdd.model.Comment;
import com.orion.mdd.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @Operation(
            summary = "Post a comment",
            description = "Allows a user to post a comment."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comment posted"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @PostMapping("/{id}")
    public ResponseEntity<Comment> postArticle(@Valid @RequestBody CommentDto commentDto,
                                               @RequestHeader("Authorization") String token,
                                               @PathVariable("id") UUID articleId
    ){
        Comment comment = commentService.postComment(token, commentDto, articleId);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }
}
