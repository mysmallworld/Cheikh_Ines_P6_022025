package com.orion.mdd.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {
    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotBlank
    private LocalDate datePublication;
}
