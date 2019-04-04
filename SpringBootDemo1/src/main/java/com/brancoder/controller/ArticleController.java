package com.brancoder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brancoder.entity.Article;
import com.brancoder.entity.Employee;
import com.brancoder.service.ArticleService;

/**
 * @author Brandon 2017/8/14
 */
@RestController
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	//@GetMapping("articles")
	@RequestMapping("/articles/{name}")
	public List<Article> getAllArticles() {
		List<Article> list = articleService.getAllArticles();
		return list;
	}

}
