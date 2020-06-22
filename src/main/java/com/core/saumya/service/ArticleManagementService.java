package com.core.saumya.service;

import java.util.List;

import com.core.saumya.vo.AccessToken;
import com.core.saumya.vo.Article;
import com.core.saumya.vo.Articles;
import com.core.saumya.vo.LoginInfo;
import com.core.saumya.vo.RegistrationInfo;
import com.core.saumya.vo.ResponseMessage;

public interface ArticleManagementService {
	ResponseMessage createUser(RegistrationInfo registrationInfo);

	AccessToken validateUser(LoginInfo loginInfo);

	ResponseMessage addArticle(Article article);

	List<Articles> getAllArticle(Integer pageNo, Integer pageSize);

}
