package com.formation.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

import org.junit.Test;

import com.formation.util.UtilisateurException;
import com.formation.wiki.DAO.ArticleDAO;
import com.formation.wiki.DAO.UtilisateurDAO;
import com.formation.wiki.entity.Article;
import com.formation.wiki.entity.Utilisateur;

public class UtilisateurDAOtest {
	//
//	@Test
//	public void IsUserstest() throws UtilisateurException {
//		System.out.println("testisuserExist");
//		assertTrue(UtilisateurDAO.isUserExist("admin", "admin"));
//		assertFalse(UtilisateurDAO.isUserExist("test", "test"));
//		int nberror=0;
//		try {
//			UtilisateurDAO.isUserExist(null, "test");
//		} catch (UtilisateurException u) {
//			u.printStackTrace();
//			nberror++;
//		}
//		try {
//			UtilisateurDAO.isUserExist(null, null);
//		} catch (UtilisateurException u) {
//			u.printStackTrace();
//
//			nberror++;
//		}
//		try {
//			UtilisateurDAO.isUserExist("test", null);
//		} catch (UtilisateurException u) {
//			u.printStackTrace();
//			nberror++;
//		}
//		assertEquals(3,nberror);
//
//	}

	@Test(expected = UtilisateurException.class)
	public void getUsertest() throws UtilisateurException {

//		assertTrue(UtilisateurDAO.getUser(1).getClass().isInstance(new Utilisateur()));
//		System.out.println(UtilisateurDAO.getUser(1));
//		UtilisateurDAO.getUser(null);
		// UtilisateurDAO.getUser(0);

	}

	@Test(expected = UtilisateurException.class)
	public void insertUsertest() throws UtilisateurException {

//		UtilisateurDAO.insertUser("gino", "bob", "bob", "bob", "bob", "0560650660");
//		UtilisateurDAO.insertUser("roger", "bob", "bob", "bob", "bob", "0560650660");

	}

	@Test
	public void getAllUserstest() {

		Utilisateur u = new Utilisateur();
//		if (!UtilisateurDAO.getAllUsers().isEmpty())
//			for (int i = 0; i < UtilisateurDAO.getAllUsers().size(); i++) {
//				assertTrue(UtilisateurDAO.getAllUsers().get(i).getClass().isInstance(u));

			}
//		else {
//			fail("pas de BDD");
//		}
//	}
}
