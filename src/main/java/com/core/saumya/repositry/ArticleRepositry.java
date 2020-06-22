package com.core.saumya.repositry;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.core.saumya.vo.Article;

public interface ArticleRepositry extends CrudRepository<Article, String> {
	
	Article save(Article article);

	List<Article> findAll(Pageable pageable);
}
