package com.formation.wiki.DAO;

import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.formation.wiki.entity.Role;
import com.formation.wiki.entity.Utilisateur;

public class RoleDAO {

	
	private EntityManager em;
	private EntityTransaction tx;

	public RoleDAO() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_WIKI");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}
	
	public Role getRoleById(int id) throws SQLException, TimeoutException {
		Query q = em.createQuery("select role from Role role where role.id= :id");
		q.setParameter("id", id);
		
		
		Role role = (Role) q.getSingleResult();
		tx.begin();
		em.merge(role);
		tx.commit();
		
		return role;

	}
	
}
