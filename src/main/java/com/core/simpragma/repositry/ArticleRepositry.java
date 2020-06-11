package com.core.simpragma.repositry;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.core.simpragma.vo.Article;

public interface ArticleRepositry extends CrudRepository<Article, String> {
	
	Article save(Article article);

	List<Article> findAll(Pageable pageable);
}
