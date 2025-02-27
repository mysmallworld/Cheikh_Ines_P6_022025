package com.orion.mdd.controller;

import com.orion.mdd.dto.request.TopicDto;
import com.orion.mdd.service.SubscriptionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @Operation(
            summary = "Update a subscription",
            description = "Allows a user to subscribe or unsubscribe a topic"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Subscribe/unsubscribe a topic"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @PutMapping
    public ResponseEntity<String> updateSubscription(@RequestBody TopicDto topicDto,
                                                              @RequestHeader("Authorization") String token){
        String subscription = subscriptionService.updateSubscription(topicDto.getTitle(), token);
        return new ResponseEntity<>(subscription, HttpStatus.OK);
    }
}
