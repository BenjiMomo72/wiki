package com.formation.wiki;

import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

import com.formation.wiki.DAO.RoleDAO;
import com.formation.wiki.DAO.UtilisateurDAO;
import com.formation.wiki.entity.Role;
import com.formation.wiki.entity.Utilisateur;

public class Main {

	public static void main(String[] args) throws SQLException, TimeoutException {
		// TODO Auto-generated method stub
		UtilisateurDAO dao = new UtilisateurDAO();
	//	RoleDAO rdao=new RoleDAO();
		Role role=dao.getRoleById(1);
		System.out.println(role.getName());
			// Test création et insertion USER OK
			Utilisateur user = new Utilisateur();
			user.setLogin("bppe");
			user.setPassword("rogerzzre");
			user.setActiver(true);
			user.setEmail("belbattach.taha");
			user.setRole(role);
			dao.addUser(user);

		try {
			System.out.println(dao.isUserExist("ben", "roger"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----------------------------");
		System.out.println(dao.findById(9).getActiver());
		dao.changerEtatUser(dao.findById(9));
		System.out.println(dao.findById(9).getActiver());
		// Query query =manager.createNamedQuery("getAllUsers");
		// UtilisateurDAO.isUserExist(null, null);
		// test is user exist
		// if (UtilisateurDAO.isUserExist("abdel", null)) {
		// System.out.println("utilisateur trouvé");
		//
		// } else {
		// System.out.println("utilisateur pas trouvé");
		// }
		// test getuser
		// System.out.println(UtilisateurDAO.getUser(0));
		// test getAllusers
		// List<Utilisateur> listUsers = UtilisateurDAO.getAllUsers();
		// for (Utilisateur u : listUsers) {
		// System.out.println(u.toString());
		// }
		// test insertUSER
		// UtilisateurDAO.insertUser("roger", "bob", "bob", "bob", "bob",
		// "0560650660");

		// insert article
		// ArticleDAO.insertArticle("Article 3", 2,
		// "mon premier
		// blaablabalablablabalbalalblbalbalablabalabalbalbalbalablabalb");

		// delete article
		// ArticleDAO.deleteArticle(2);
		// get Article by id
		// System.out.println(ArticleDAO.getArticleById(1));
		// get Article by name
		// System.out.println("test by name");
		// System.out.println(ArticleDAO.getArticleByName("Article 3"));
		// System.out.println("test by name");
		// get ALLArticle
		// List<Article> listArticles = ArticleDAO.getAllArticles();
		// for (Article a : listArticles) {
		// System.out.println(a.toString());
		// }

		// delete comment
		// CommentaireDAO.deleteComment(6);
		// insert comment
		// CommentaireDAO.insertComment("yipikaieee", 2, 3);

		// recup all comment par l'id de l'article
		// List<Commentaire> listComment = CommentaireDAO.getAllCommentById(3);
		// for (Commentaire c : listComment) {
		// System.out.println(c.toString());
		// }
	}

}
