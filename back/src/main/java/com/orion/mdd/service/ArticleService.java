package com.orion.mdd.service;

import com.orion.mdd.dto.request.ArticleDto;
import com.orion.mdd.dto.response.ArticleResponse;
import com.orion.mdd.mapper.ArticleMapper;
import com.orion.mdd.model.Article;
import com.orion.mdd.model.Topic;
import com.orion.mdd.model.User;
import com.orion.mdd.repository.ArticleRepository;
import com.orion.mdd.repository.TopicRepository;
import com.orion.mdd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TopicRepository topicRepository;

    public ArticleResponse getAllArticles() {
        try {
            List<ArticleDto> articleDtos = articleRepository.findAll()
                    .stream()
                    .map(articleMapper::toDto)
                    .collect(Collectors.toList());

            ArticleResponse articleResponse = ArticleResponse.builder().articles(articleDtos).build();
            return articleResponse;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }

    public ArticleDto getArticle(UUID id) {
        try {
            Article article = articleRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Article not found"));
            return articleMapper.toDto(article);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }

    public Article postArticle(String token, ArticleDto articleDto) {
        try {
            Article article = articleMapper.toEntity(articleDto);
            String userEmail = userService.getUserByToken(token).getEmail();

            User user = userRepository.findByEmail(userEmail);
            article.setAuthor(user);

            Topic topic = topicRepository.findByTitle(articleDto.getTopic());
            article.setTopic(topic);

            articleRepository.save(article);

            return article;
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }
}
