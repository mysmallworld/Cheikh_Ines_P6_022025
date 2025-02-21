package com.orion.mdd.mapper;

import com.orion.mdd.dto.request.ArticleDto;
import com.orion.mdd.model.Article;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class ArticleMapper {
    public ArticleDto toDto(Article article) {
        ArticleDto articleDto = new ArticleDto();
        articleDto.setId(article.getId());
        articleDto.setTitle(article.getTitle());
        articleDto.setContent(article.getContent());
        articleDto.setTopicTitle(article.getTopic().getTitle());
        articleDto.setDatePublication(article.getDatePublication());
        return articleDto;
    }

    public Article toEntity(ArticleDto articleDto) {
        if (articleDto == null) {
            return null;
        }
        LocalDate now = LocalDate.now();

        return Article.builder()
                .id(UUID.randomUUID())
                .title(articleDto.getTitle())
                .content(articleDto.getContent())
                .datePublication(now)
                .build();
    }
}
