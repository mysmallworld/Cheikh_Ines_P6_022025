package com.orion.mdd.controller;

import com.orion.mdd.dto.request.ArticleDto;
import com.orion.mdd.dto.response.ArticleResponse;
import com.orion.mdd.model.Article;
import com.orion.mdd.service.ArticleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/article")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Operation(
            summary = "Get all articles",
            description = "Allows a user to get all articles"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All articles informations"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @GetMapping
    public ResponseEntity<ArticleResponse> getAllArticles(){
        ArticleResponse articlesResponse = articleService.getAllArticles();
        return new ResponseEntity<>(articlesResponse, HttpStatus.OK);
    }

    @Operation(
            summary = "Get an article",
            description = "Allows a user to get an article."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "One article"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> getArticle(@PathVariable("id") UUID id){
        ArticleDto articleDto = articleService.getArticle(id);
        return new ResponseEntity<>(articleDto, HttpStatus.OK);
    }

    @Operation(
            summary = "Post an article",
            description = "Allows a user to post an article."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Article posted"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @PostMapping
    public ResponseEntity<Article> postArticle(@Valid @RequestBody ArticleDto articleDto,
                                               @RequestHeader("Authorization") String token
    ){
        Article article = articleService.postArticle(token, articleDto);
        return new ResponseEntity<>(article, HttpStatus.OK);
    }
}
