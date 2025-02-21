package com.orion.mdd.mapper;

import com.orion.mdd.dto.request.TopicDto;
import com.orion.mdd.dto.response.TopicResponse;
import com.orion.mdd.model.Topic;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TopicMapper {
    public TopicDto toDto(Topic topic) {
        TopicDto topicDto = new TopicDto();
        topicDto.setId(topic.getId());
        topicDto.setTitle(topic.getTitle());
        topicDto.setDescription(topic.getDescription());
        return topicDto;
    }
}
