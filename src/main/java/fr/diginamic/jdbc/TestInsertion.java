package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.dao.FournisseurDoaJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;
import fr.diginamic.jdbc.exceptions.DaoException;


/**Tester les insertions sur la BD compta
 * @author formation
 *
 */
public class TestInsertion {

	public static void main(String[] args) {
		
		try {
			Fournisseur nouveauFournisseur = new Fournisseur("L''Espace Création");
			FournisseurDoaJdbc dao = new FournisseurDoaJdbc();
			dao.insert(nouveauFournisseur);

		} catch (DaoException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
