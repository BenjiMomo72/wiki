package com.formation.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import org.junit.Test;

import com.formation.wiki.DAO.ArticleDAO;
import com.formation.wiki.DAO.UtilisateurDAO;
import com.formation.wiki.entity.Article;

public class ArticleDAOtests {
	// static public void insertArticle(String nomArticle, int idUser, String
	// content)
	@Test
	public void insertArticletest() {
		// test insert
		// assertTrue(ArticleDAO.insertArticle("Article 3", 2, "mon premier
		// blaablabalbalbalbalabla"));
		// assertTrue(ArticleDAO.insertArticle(null, 2, "mon premier
		// blaablabalbalbalbalabla"));
		// assertFalse(ArticleDAO.insertArticle("Article 3", null, "mon premier
		// blaablabalbalbalbalabla"));
		//
		// assertTrue(ArticleDAO.insertArticle("Article 3", 2, null));
		// assertFalse(ArticleDAO.insertArticle(null, null, null));
		//
		// // test taille de la base de données
		// int l = ArticleDAO.getAllArticles().size();
		// ArticleDAO.insertArticle("Article 3", 2, "mon premier
		// blaablabalbalbalbalabla");
		// assertEquals(l + 1, ArticleDAO.getAllArticles().size());
		// System.out.println(ArticleDAO.getAllArticles().size());
	}

	// static public void deleteArticle(int idArticle)
	@Test
	public void deleteArticletest() {
		// int l = ArticleDAO.getAllArticles().size();
		// ArticleDAO.deleteArticle(null);
		// assertNotEquals(l + -1, ArticleDAO.getAllArticles().size());
		// int l2 = ArticleDAO.getAllArticles().size();
		// ArticleDAO.deleteArticle(12);
		// assertEquals(l2-1, ArticleDAO.getAllArticles().size());
		//
		// System.out.println(ArticleDAO.getAllArticles().size());
	}

	// public static Article getArticleById(int idArticle)
	@Test
	public void getArticleByIdtest() {
		fail("Not yet implemented");
	}

	// public static Article getArticleByName(String nomArticle)
	@Test
	public void getArticleByNametest() {

		fail("Not yet implemented");
	}

	// public static List<Article> getAllArticles()
	@Test
	public void getAllArticlestest() {
		Article a= new Article();
//		if (!ArticleDAO.getAllArticles().isEmpty())
//			for (int i = 0; i < ArticleDAO.getAllArticles().size(); i++)
//		{
//		 assertTrue(ArticleDAO.getAllArticles().get(i).getClass().isInstance(a));}
//		else { fail("pas de BDD");
//		}
	}
}
