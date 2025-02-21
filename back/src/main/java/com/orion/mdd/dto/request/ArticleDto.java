package com.orion.mdd.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {
    private UUID id;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotBlank
    private String topic;

    private LocalDate datePublication;
}
