package me.mocadev.mocadevprojectboard.domain;

import java.time.LocalDateTime;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-09-29
 **/
public class ArticleComment {

	private Long id;
	private Article article;
	private String title;
	private String content;

	private LocalDateTime createdAt;
	private String createdBy;
	private LocalDateTime modifiedAt;
	private String modifiedBy;
}
