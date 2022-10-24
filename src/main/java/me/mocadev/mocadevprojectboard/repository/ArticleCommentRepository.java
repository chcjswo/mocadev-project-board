package me.mocadev.mocadevprojectboard.repository;

import me.mocadev.mocadevprojectboard.domain.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {

}
