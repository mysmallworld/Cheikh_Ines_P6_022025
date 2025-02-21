package com.orion.mdd.controller;

import com.orion.mdd.dto.response.TopicResponse;
import com.orion.mdd.service.TopicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/topics")
public class TopicController {

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @Operation(
            summary = "Get list of topics",
            description = "Allows a user to get list of topics"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Topics informations"),
            @ApiResponse(responseCode = "404", description = "Topics not found")
    })
    @GetMapping
    public ResponseEntity<TopicResponse> getAllTopics(){
        TopicResponse topicsResponse = topicService.getAllTopics();
        return new ResponseEntity<>(topicsResponse, HttpStatus.OK);
    }
}
