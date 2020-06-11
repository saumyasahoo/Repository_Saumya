package com.core.simpragma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.core.simpragma.service.ArticleManagementService;
import com.core.simpragma.vo.AccessToken;
import com.core.simpragma.vo.Article;
import com.core.simpragma.vo.Articles;
import com.core.simpragma.vo.LoginInfo;
import com.core.simpragma.vo.RegistrationInfo;
import com.core.simpragma.vo.ResponseMessage;

@RestController
public class ArticleManagementController {

	@Autowired
	private ArticleManagementService articleManagementService;

	private static final int customHttpStatusValue = 201;

	@PostMapping("/register")
	public ResponseEntity<ResponseMessage> userRegister(@RequestBody RegistrationInfo registrationInfo) {
		ResponseMessage responseCode = articleManagementService.createUser(registrationInfo);
		return ResponseEntity.status(customHttpStatusValue).body(responseCode);
	}

	@PostMapping("/login")
	public ResponseEntity<AccessToken> userLogin(@RequestBody LoginInfo loginInfo) {
		AccessToken responseCode = articleManagementService.validateUser(loginInfo);
		return ResponseEntity.ok(responseCode);
	}

	@PostMapping("/addArticle")
	public ResponseEntity<ResponseMessage> addArticle(@RequestBody Article article) {
		ResponseMessage responseCode = articleManagementService.addArticle(article);
		return ResponseEntity.status(customHttpStatusValue).body(responseCode);
	}

	@GetMapping("/articles")
	public ResponseEntity<List<Articles>> viewArticle(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "05") Integer pageSize) {
		List<Articles> articles = articleManagementService.getAllArticle(pageNo, pageSize);
		return ResponseEntity.ok(articles);
	}
}
