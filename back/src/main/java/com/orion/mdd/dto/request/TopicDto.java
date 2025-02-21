package com.orion.mdd.dto.request;

import lombok.Data;

import java.util.UUID;

@Data
public class TopicDto {
    private UUID id;
    private String title;
    private String description;
}
