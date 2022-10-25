package me.mocadev.mocadevprojectboard.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import me.mocadev.mocadevprojectboard.config.JpaConfig;
import me.mocadev.mocadevprojectboard.domain.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-10-25
 **/
@DisplayName("JPA 연결 테스트")
@DataJpaTest
@Import(JpaConfig.class)
class JpaRepositoryTest {

	private final ArticleRepository articleRepository;
	private final  ArticleCommentRepository articleCommentRepository;

	public JpaRepositoryTest(@Autowired ArticleRepository articleRepository,
							 @Autowired ArticleCommentRepository articleCommentRepository) {
		this.articleRepository = articleRepository;
		this.articleCommentRepository = articleCommentRepository;
	}

	@Test
	@DisplayName("select test")
	void selectTest() {
		final List<Article> articles = articleRepository.findAll();

		assertThat(articles)
			.isNotNull()
			.hasSize(1);
	}

	@Test
	@DisplayName("insert test")
	void insertTest() {
		final long count = articleRepository.count();
		final Article article = Article.of("new", "new content", "#1234");
		articleRepository.save(article);

		assertThat(articleRepository.count())
			.isEqualTo(count + 1);
	}

	@Test
	@DisplayName("update test")
	void updateTest() {
		final Article article = articleRepository.findById(1L).orElseThrow();
		String updatedHashtag = "springboot";
		article.setHashtag(updatedHashtag);
		final Article saved = articleRepository.saveAndFlush(article);

		assertThat(saved).hasFieldOrPropertyWithValue("hashtag", updatedHashtag);
	}

	@Test
	@DisplayName("delete test")
	void deleteTest() {
		// given
		final Article article = articleRepository.findById(1L).orElseThrow();
		final long count = articleRepository.count();
		final long commentCount = articleCommentRepository.count();
		final int size = article.getArticleComments().size();

		// when
		articleRepository.delete(article);

		assertThat(articleRepository.count()).isEqualTo(count - 1);
		assertThat(articleCommentRepository.count()).isEqualTo(commentCount - size);
	}
}
