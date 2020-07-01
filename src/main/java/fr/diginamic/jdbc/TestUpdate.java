package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.dao.FournisseurDoaJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

/**Tester les modifications sur la BD compta
 * @author formation
 *
 */
public class TestUpdate {

	public static void main(String[] args) {
		
		
		FournisseurDoaJdbc dao = new FournisseurDoaJdbc();
		int update = dao.update("L''Espace Cr�ation", "L''Espace R�cr�ation");
		
		if(update == 1) {
			System.out.println("changement de nom r�ussit");
		}
		else if(update == 0) {
			System.out.println("erreur");
		}

	}

}
