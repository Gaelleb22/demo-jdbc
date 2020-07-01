package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.dao.FournisseurDoaJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;
import fr.diginamic.jdbc.exceptions.DaoException;

/**Tester les selections sur la BD compta
 * @author formation
 *
 */
public class TestSelect {

	public static void main(String[] args) {
		
		try {
			List<Fournisseur> fournisseurs = new ArrayList();
			FournisseurDoaJdbc dao = new FournisseurDoaJdbc();
			fournisseurs = dao.extraire();
			
			for (Fournisseur fournisseur : fournisseurs) {
				System.out.println(fournisseur.toString());
			}
		} catch (DaoException e) {
			System.out.println(e.getMessage());
		}
		


	}

}
