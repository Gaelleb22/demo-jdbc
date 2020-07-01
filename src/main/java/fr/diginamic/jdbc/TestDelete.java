package fr.diginamic.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.dao.FournisseurDoaJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

/**Tester suppression de donn�es sur la DB compta
 * @author formation
 *
 */
public class TestDelete {

	public static void main(String[] args) {
		
		
		Fournisseur fournisseur = new Fournisseur("L''Espace R�cr�ation");
		FournisseurDoaJdbc dao = new FournisseurDoaJdbc();
		boolean update = dao.delete(fournisseur);
		
		if(update == true) {
			System.out.println("suppression r�ussit");
		}
		else if(update == false) {
			System.out.println("erreur");
		}
	}

}
