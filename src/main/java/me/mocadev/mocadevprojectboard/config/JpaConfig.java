package me.mocadev.mocadevprojectboard.config;

import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-10-05
 **/
@EnableJpaAuditing
@Configuration
public class JpaConfig {

	@Bean
	public AuditorAware<String> auditorAware() {
		// TODO: 2022-10-05 스프링 시큐리티로 인증 붙이기 추가할 것
		return () -> Optional.of("chcjswo");
	}
}
