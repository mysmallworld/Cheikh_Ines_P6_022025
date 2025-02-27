package com.orion.mdd.repository;

import com.orion.mdd.model.Subscription;
import com.orion.mdd.model.Topic;
import com.orion.mdd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, UUID> {
    Subscription findByUserAndTopic(User user, Topic topic);
}
