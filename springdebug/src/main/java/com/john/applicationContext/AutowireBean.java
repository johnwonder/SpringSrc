package com.john.applicationContext;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/1/10
 */
public class AutowireBean implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {

		System.out.println("properties");
	}

	private ArticleService articleService;

	private ArticleService article;

	public ArticleService getArticleService() {
		return articleService;
	}


	@Autowired
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	public ArticleService getArticle() {
		return article;
	}

	public void setArticle(ArticleService article) {
		this.article = article;
	}
}
