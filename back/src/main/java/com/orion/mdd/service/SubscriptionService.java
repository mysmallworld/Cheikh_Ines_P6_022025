package com.orion.mdd.service;

import com.orion.mdd.dto.request.SubscriptionDto;
import com.orion.mdd.mapper.SubscriptionMapper;
import com.orion.mdd.model.Subscription;
import com.orion.mdd.model.Topic;
import com.orion.mdd.model.User;
import com.orion.mdd.repository.SubscriptionRepository;
import com.orion.mdd.repository.TopicRepository;
import com.orion.mdd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SubscriptionService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    private SubscriptionMapper subscriptionMapper;

    public String updateSubscription(String topicTitle, String token) {
        try {
            String message;
            String userEmail = userService.getUserByToken(token).getEmail();

            User user = userRepository.findByEmail(userEmail);
            Topic topic = topicRepository.findByTitle(topicTitle);
            Subscription subscriptionToUpdate = subscriptionRepository.findByUserAndTopic(user, topic);

            if(subscriptionToUpdate != null){
                subscriptionRepository.delete(subscriptionToUpdate);
                message = String.format("User %s unsubscribe the topic %s", user.getUsername(), topic.getTitle());
            } else {
                SubscriptionDto subscriptionDto = subscriptionMapper.toDto(user, topic);
                Subscription subscription = subscriptionMapper.toEntity(subscriptionDto);
                subscriptionRepository.save(subscription);
                message = String.format("User %s subscribe the topic %s", user.getUsername(), topic.getTitle());
            }

            return message;
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }

}
