package com.formation.util;

public class UtilisateurException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * exception dans le cas où un des champs est null, ou les deux
	 */
	private String login, mdp, typeException;

	public UtilisateurException(String login, String mdp) {
		super();
		if (login == null && mdp == null) {
			typeException = "aucun champs renseignés";

		} else if (login == null) {
			typeException = "login non renseignés";
		} else if (mdp == null) {
			typeException = "mdp nom renseignés";
		}
	}

	/**
	 * exception dans le cas ou lidUser n'existe pas ou est null
	 */

	public UtilisateurException(Integer idUser) {
		if (idUser == null) {
			typeException = "çà marche pas sans ID";

		} else if (idUser.equals(0)) {
			typeException = "0 n'est pas possible";
		} else {
			typeException = "IdUser non présent dans la bdd";
		}
	}

	/**
	 * exception pr l'insertion d'un utilisateur existant
	 */

	public UtilisateurException(String login) {
		if (login == null) {
			typeException = "çà marche pas sans login";

		} else {
			typeException = login + " existe déjà";
		}
	}

	@Override
	public String toString() {
		return typeException;
	}

}
