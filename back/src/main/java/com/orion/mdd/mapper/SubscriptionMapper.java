package com.orion.mdd.mapper;

import com.orion.mdd.dto.request.SubscriptionDto;
import com.orion.mdd.model.Subscription;
import com.orion.mdd.model.Topic;
import com.orion.mdd.model.User;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SubscriptionMapper {
    public SubscriptionDto toDto(User user, Topic topic) {
        SubscriptionDto subscriptionDto = new SubscriptionDto();
        subscriptionDto.setUser(user);
        subscriptionDto.setTopic(topic);
        return subscriptionDto;
    }

    public Subscription toEntity(SubscriptionDto subscriptionDto) {
        if (subscriptionDto == null) {
            return null;
        }
        return Subscription.builder()
                .id(UUID.randomUUID())
                .user(subscriptionDto.getUser())
                .topic(subscriptionDto.getTopic())
                .build();
    }
}
