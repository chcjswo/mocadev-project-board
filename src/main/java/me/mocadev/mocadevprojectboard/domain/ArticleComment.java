package me.mocadev.mocadevprojectboard.domain;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-09-29
 **/

@Getter
@ToString
@Table(indexes = {
	@Index(columnList = "content"),
	@Index(columnList = "createdAt"),
	@Index(columnList = "createdBy")
})
@Entity
public class ArticleComment extends AuditingFields {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Setter
	@ManyToOne(optional = false)
	private Article article;
	@Setter
	@Column(nullable = false, length = 500)
	private String content;

	protected ArticleComment() {
	}

	private ArticleComment(Article article, String content) {
		this.article = article;
		this.content = content;
	}

	public static ArticleComment of(Article article, String content) {
		return new ArticleComment(article, content);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof ArticleComment)) {
			return false;
		}
		ArticleComment that;
		that = (ArticleComment) o;
		return id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
