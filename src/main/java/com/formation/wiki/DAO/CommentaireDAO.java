package com.formation.wiki.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.formation.wiki.ConnexionManager;
import com.formation.wiki.entity.Article;
import com.formation.wiki.entity.Commentaire;

public class CommentaireDAO {

	private EntityManager em;
	private EntityTransaction tx;

	public CommentaireDAO() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_WIKI");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}
	
	// -----statut???
	
	
	
	// -----insertion commentaire
	public void addArticle(Commentaire comment) {
		tx.begin();
		em.persist(comment);
		tx.commit();
	}
	// suppression commentairebyID
	public void removeCommentById(int id) {
		Query q = em.createQuery("SELECT c FROM commentaire c WHERE c.id= :id");
		q.setParameter("id", id);
		Commentaire comment = (Commentaire) q.getSingleResult();
		tx.begin();
		em.remove(comment);
		tx.commit();
	}
	
	
	// getALLcommentByAuthor
	@SuppressWarnings("unchecked")
	public List<Commentaire> getAllCommentByAuthor(String user) {
		Query q = em.createQuery("SELECT c FROM commentaire c WHERE c.user= :user");
		q.setParameter("user", user);
		List<Commentaire> listComments = (List<Commentaire>) q.getResultList();
		return listComments;
	}
	
	// getALLcommentByArticle
	public List<Commentaire> getAllCommentByArticleId(int id) {
		Query q = em.createQuery("SELECT a FROM article a WHERE a.id= :id");
		q.setParameter("id", id);
		Article article=(Article) q.getSingleResult();
		List<Commentaire> listComments = article.getCommentaires(); ;
		return listComments;
	}
}
