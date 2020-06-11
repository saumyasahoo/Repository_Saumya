package com.core.simpragma.service;

import java.util.List;

import com.core.simpragma.vo.AccessToken;
import com.core.simpragma.vo.Article;
import com.core.simpragma.vo.Articles;
import com.core.simpragma.vo.LoginInfo;
import com.core.simpragma.vo.RegistrationInfo;
import com.core.simpragma.vo.ResponseMessage;

public interface ArticleManagementService {
	ResponseMessage createUser(RegistrationInfo registrationInfo);

	AccessToken validateUser(LoginInfo loginInfo);

	ResponseMessage addArticle(Article article);

	List<Articles> getAllArticle(Integer pageNo, Integer pageSize);

}
