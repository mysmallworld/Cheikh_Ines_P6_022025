package com.orion.mdd.dto.request;

import com.orion.mdd.model.Article;
import com.orion.mdd.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private UUID id;

    @NotBlank
    private  String content;

    private Article article;

    private User author;
}
