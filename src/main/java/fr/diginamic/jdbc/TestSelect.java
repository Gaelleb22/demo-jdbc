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

/**Tester les selections sur la BD compta
 * @author formation
 *
 */
public class TestSelect {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ResourceBundle fichierConf = ResourceBundle.getBundle("database");

		String driverName = fichierConf.getString("database.driver");
		Class.forName(driverName);
		String url = fichierConf.getString("database.url");
		String user = fichierConf.getString("database.user");
		String password = fichierConf.getString("database.password");
		Connection connection = DriverManager.getConnection(url, user, password);
		
		List<Fournisseur> fournisseurs = new ArrayList();
		FournisseurDoaJdbc dao = new FournisseurDoaJdbc(connection);
		fournisseurs = dao.extraire();
		
		for (Fournisseur fournisseur : fournisseurs) {
			System.out.println(fournisseur.toString());
		}


	}

}
