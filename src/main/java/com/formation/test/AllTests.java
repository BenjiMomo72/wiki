package com.formation.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ArticleDAOtests.class, CommentaireDAOtest.class, UtilisateurDAOtest.class })
public class AllTests {

}
