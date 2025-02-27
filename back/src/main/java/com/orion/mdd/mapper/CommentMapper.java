package com.orion.mdd.mapper;

import com.orion.mdd.dto.request.CommentDto;
import com.orion.mdd.model.Comment;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CommentMapper {
    public CommentDto toDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setContent(comment.getContent());
        commentDto.setArticle(comment.getArticle());
        commentDto.setAuthor(comment.getAuthor());
        return commentDto;
    }

    public Comment toEntity(CommentDto commentDto) {
        if (commentDto == null) {
            return null;
        }

        return Comment.builder()
                .id(UUID.randomUUID())
                .content(commentDto.getContent())
                .build();
    }
}
