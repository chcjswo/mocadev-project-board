package me.mocadev.mocadevprojectboard.repository;

import me.mocadev.mocadevprojectboard.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
