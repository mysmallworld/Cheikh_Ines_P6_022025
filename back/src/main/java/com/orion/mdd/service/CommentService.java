package com.orion.mdd.service;

import com.orion.mdd.dto.request.CommentDto;
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

import java.util.UUID;

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

    public Comment postComment(String token, CommentDto commentDto, UUID id) {
        try {
            Comment comment = commentMapper.toEntity(commentDto);

            String userEmail = userService.getUserByToken(token).getEmail();
            User user = userRepository.findByEmail(userEmail);
            comment.setAuthor(user);

            Article article = articleRepository.findArticleById(id);
            comment.setArticle(article);

            commentRepository.save(comment);

            return comment;
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }
}
