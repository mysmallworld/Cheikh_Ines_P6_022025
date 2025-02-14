package com.orion.mdd.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class ArticleResponse {
    private UUID id;
    private String title;
    private String content;
    private LocalDate datePublication;
}
