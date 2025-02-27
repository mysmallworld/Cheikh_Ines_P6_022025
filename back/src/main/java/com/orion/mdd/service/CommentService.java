package com.orion.mdd.service;

import com.orion.mdd.dto.request.CommentDto;
import com.orion.mdd.dto.response.CommentResponse;
import com.orion.mdd.mapper.CommentMapper;
import com.orion.mdd.model.Article;
import com.orion.mdd.model.Comment;
import com.orion.mdd.model.User;
import com.orion.mdd.repository.ArticleRepository;
import com.orion.mdd.repository.CommentRepository;
import com.orion.mdd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ArticleRepository articleRepository;

    public CommentResponse getCommentsByArticle(UUID articleId) {
        try {
            Article article = articleRepository.findById(articleId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Article not found"));

            List<CommentDto> commentDtos = commentRepository.findByArticle(article)
                    .stream()
                    .map(commentMapper::toDto)
                    .collect(Collectors.toList());

            CommentResponse commentResponse = CommentResponse.builder().comments(commentDtos).build();
            return commentResponse;
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }

    public Comment postComment(String token, CommentDto commentDto, UUID articleId) {
        try {
            Comment comment = commentMapper.toEntity(commentDto);

            String userEmail = userService.getUserByToken(token).getEmail();
            User user = userRepository.findByEmail(userEmail);
            comment.setAuthor(user);

            Article article = articleRepository.findArticleById(articleId);
            comment.setArticle(article);

            commentRepository.save(comment);

            return comment;
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }
}
