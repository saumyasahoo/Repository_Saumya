package com.core.saumya.serviceimpl;

import static com.core.saumya.vo.Constant.FAILURE;
import static com.core.saumya.vo.Constant.INVALID_UN_PWD;
import static com.core.saumya.vo.Constant.NEW_ARTICLE;
import static com.core.saumya.vo.Constant.NEW_USER;
import static com.core.saumya.vo.Constant.SUCCESS;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.core.saumya.repositry.ArticleManagementRepositry;
import com.core.saumya.repositry.ArticleRepositry;
import com.core.saumya.service.ArticleManagementService;
import com.core.saumya.vo.AccessToken;
import com.core.saumya.vo.Article;
import com.core.saumya.vo.Articles;
import com.core.saumya.vo.LoginInfo;
import com.core.saumya.vo.RegistrationInfo;
import com.core.saumya.vo.ResponseMessage;

@Service
public class ArticleManagementServiceImpl implements ArticleManagementService {

	ResponseMessage responseCode = null;
	AccessToken accessToken = null;

	@Autowired
	ArticleManagementRepositry articleManagementRepositry;
	@Autowired
	ArticleRepositry articleRepositry;

	@Override
	@Transactional
	public ResponseMessage createUser(RegistrationInfo registrationInfo) {
		articleManagementRepositry.save(registrationInfo);
		responseCode = new ResponseMessage();
		responseCode.setMessage(NEW_USER);
		return responseCode;

	}

	@Override
	public AccessToken validateUser(LoginInfo loginInfo) {
		RegistrationInfo registrationInfo = new RegistrationInfo();
		registrationInfo.setUserName(loginInfo.getUserName());
		String passWord = articleManagementRepositry.findPassWordByUserName(registrationInfo.getUserName());
		if (passWord != null && passWord.equals(loginInfo.getPassWord())) {
			String token = UUID.randomUUID().toString();
			accessToken = new AccessToken();
			accessToken.setMessage(SUCCESS);
			accessToken.setAccessToken(token);
			return accessToken;
		}

		else {
			accessToken = new AccessToken();
			accessToken.setMessage(FAILURE);
			accessToken.setMessage(INVALID_UN_PWD);
			return accessToken;
		}
	}

	@Override
	public ResponseMessage addArticle(Article article) {
		articleRepositry.save(article);
		responseCode = new ResponseMessage();
		responseCode.setMessage(NEW_ARTICLE);
		return responseCode;
	}

	public List<Articles> getAllArticle(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		List<Article> pagedResult = articleRepositry.findAll(paging);
		List<Articles> articles=new ArrayList<>();
		for (Article articles2 : pagedResult) {
			Articles articles3=new Articles();
			articles3.setAuthor(articles2.getAuthor());
			articles3.setBody(articles2.getBody());
			articles3.setTitle(articles2.getTitle());
			articles.add(articles3);
		}
		return articles;
	}

}
