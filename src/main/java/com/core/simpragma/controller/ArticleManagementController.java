package com.core.simpragma.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	public ResponseEntity<ResponseMessage> userRegister(@Valid @RequestBody RegistrationInfo registrationInfo) {
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

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
}
