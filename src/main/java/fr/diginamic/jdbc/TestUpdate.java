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

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ResourceBundle fichierConf = ResourceBundle.getBundle("database");

		String driverName = fichierConf.getString("database.driver");
		Class.forName(driverName);
		String url = fichierConf.getString("database.url");
		String user = fichierConf.getString("database.user");
		String password = fichierConf.getString("database.password");
		Connection connection = DriverManager.getConnection(url, user, password);

		FournisseurDoaJdbc dao = new FournisseurDoaJdbc(connection);
		int update = dao.update("L''Espace Création", "L''Espace Récréation");
		
		if(update == 1) {
			System.out.println("changement de nom réussit");
		}
		else if(update == 0) {
			System.out.println("erreur");
		}

	}

}
