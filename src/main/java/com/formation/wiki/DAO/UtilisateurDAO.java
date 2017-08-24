package com.formation.wiki.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.formation.wiki.entity.Role;
import com.formation.wiki.entity.Utilisateur;

public class UtilisateurDAO {

	private EntityManager em;
	private EntityTransaction tx;

	public UtilisateurDAO() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_WIKI");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	// --------------------------------IS_USER_EXISTS

	public String isUserExist(String login, String mdp) throws SQLException, TimeoutException  {

		String role_user = null;
		
		Query q = em.createQuery("select user from Utilisateur user where user.login= :login and user.password= :mdp");
		q.setParameter("login", login);
		q.setParameter("mdp", mdp);
		
		Utilisateur user_exist = (Utilisateur) q.getSingleResult();

		if (user_exist != null) {
			role_user = user_exist.getRole().getName();
		}

		return role_user;
	}

	// --------------------------------AddUser
	public Role getRoleById(int id) throws SQLException, TimeoutException {
		Query q = em.createQuery("select role from Role role where role.id= :id");
		q.setParameter("id", id);
		
		
		Role role = (Role) q.getSingleResult();
		tx.begin();
		em.merge(role);
		tx.commit();
		
		return role;

	}
	
	public void addUser(Utilisateur user) throws SQLException, TimeoutException{
		
		//		autres options
		// em.remove(entity) supress
		// em.merge(entity) maj
		// em.find(entityClass,primary key
	
		tx.begin();
		em.persist(user);
		tx.commit();
	}

	// --------------------------------find by id
	
	public Utilisateur findById(int id) throws SQLException, TimeoutException {
		Query q = em.createNamedQuery("Utilisateur.findById");
		q.setParameter("id", id);
		Utilisateur user = (Utilisateur) q.getSingleResult();
		return user;

	}
	
	
	// --------------------------------find by login
	
	public Utilisateur findByLogin(String login) throws SQLException, TimeoutException {
		Query q = em.createNamedQuery("Utilisateur.findByLogin");
		q.setParameter("login", login);
		Utilisateur user = (Utilisateur) q.getSingleResult();
		return user;

	}
	
	
	// --------------------------------changer état user
	public void changerEtatUser(Utilisateur user) throws SQLException, TimeoutException{
		if (user.getActiver() == false) {
			user.setActiver(true);
		} else {
			user.setActiver(false);
		}
		tx.begin();
		em.merge(user);
		tx.commit();
	}
	// --------------------------------getAlluser
	@SuppressWarnings("unchecked")
	public List<Utilisateur> getAllUsers() {

		Query q = em.createNamedQuery("Utilisateur.getAllUsers");

		List<Utilisateur> listUsers = (List<Utilisateur>) q.getResultList();
		return listUsers;
	}
	

}