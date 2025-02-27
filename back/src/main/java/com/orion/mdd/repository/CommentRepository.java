package com.orion.mdd.repository;

import com.orion.mdd.model.Article;
import com.orion.mdd.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CommentRepository extends JpaRepository<Comment, UUID> {
    List<Comment> findByArticle(Article article);
}
