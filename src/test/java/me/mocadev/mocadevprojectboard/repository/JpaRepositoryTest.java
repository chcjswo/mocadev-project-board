package me.mocadev.mocadevprojectboard.repository;

import static org.junit.jupiter.api.Assertions.*;

import me.mocadev.mocadevprojectboard.config.JpaConfig;
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

	}
}
