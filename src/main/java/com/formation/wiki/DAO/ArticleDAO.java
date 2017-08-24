package com.formation.wiki.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.formation.wiki.entity.Article;
import com.formation.wiki.entity.Statut;
import com.formation.wiki.entity.Utilisateur;

public class ArticleDAO {

	private EntityManager em;
	private EntityTransaction tx;

	public ArticleDAO() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_WIKI");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	// --------------------------------article approuvé/désaprouvé
	public void setPublishArticle(Article article) {
		Statut st = article.getStatut();

		if (st.getPublished() == false) {
			st.setPublished(true);
		} else {
			st.setPublished(false);
		}

		if (st.getWaitingforvalidation() == false) {
			st.setWaitingforvalidation(true);
		} else {
			st.setWaitingforvalidation(false);
		}

		tx.begin();
		em.merge(article);
		tx.commit();
	}

	// --------------------------------insert article

	public void addArticle(Article article) {

		// autres options
		// em.remove(entity) supress
		// em.merge(entity) maj
		// em.find(entityClass,primary key
		tx.begin();
		em.persist(article);
		tx.commit();
	}

	// --------------------------------delete article
	public void removeArticle(Article article) {

		tx.begin();
		em.remove(article);
		tx.commit();
		// --------------------------------delete article by Id
	}

	public void removeArticleById(int id) {
		Query q = em.createQuery("SELECT a FROM Article a WHERE a.id= :id");
		q.setParameter("id", id);
		Article article = (Article) q.getSingleResult();
		tx.begin();
		em.remove(article);
		tx.commit();
	}

	// --------------------------------find by iD
	public Article findById(int id) {
		Query q = em.createQuery("SELECT a FROM article a WHERE a.id= :id");
		q.setParameter("id", id);
		Article article = (Article) q.getSingleResult();
		return article;

	}

	// --------------------------------find by title
	public Article findByTitle(String title) {
		Query q = em.createQuery("SELECT a FROM article a WHERE a.title= :title");
		q.setParameter("title", title);
		Article article = (Article) q.getSingleResult();
		return article;
	}

	// --------------------------------gelAllArticle
	@SuppressWarnings("unchecked")
	public List<Article> getAllArticle(String title) {
		Query q = em.createQuery("SELECT a FROM article a");

		List<Article> listArticles = (List<Article>) q.getResultList();
		return listArticles;
	}

	// --------------------------------gelAllArticle pr un autheur
	@SuppressWarnings("unchecked")
	public List<Article> getAllArticleByAuthor(String user) {
		Query q = em.createQuery("SELECT a FROM article a WHERE a.user= :user");
		q.setParameter("user", user);
		List<Article> listArticles = (List<Article>) q.getResultList();
		return listArticles;
	}

}