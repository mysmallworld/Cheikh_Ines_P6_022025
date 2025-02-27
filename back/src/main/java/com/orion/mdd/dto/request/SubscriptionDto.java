package com.orion.mdd.dto.request;

import com.orion.mdd.model.Topic;
import com.orion.mdd.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDto {
    private UUID id;
    private User user;
    private Topic topic;
}
