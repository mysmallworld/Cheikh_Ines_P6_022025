package com.orion.mdd.service;

import com.orion.mdd.dto.request.TopicDto;
import com.orion.mdd.dto.response.TopicResponse;
import com.orion.mdd.mapper.TopicMapper;
import com.orion.mdd.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private TopicMapper topicMapper;

    public TopicResponse getAllTopics() {
        try {
            List<TopicDto> topicDtos = topicRepository.findAll()
                    .stream()
                    .map(topicMapper::toDto)
                    .collect(Collectors.toList());

            TopicResponse topicResponse = TopicResponse.builder().topics(topicDtos).build();
            return topicResponse;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }
}
