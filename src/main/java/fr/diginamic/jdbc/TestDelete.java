package fr.diginamic.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.dao.FournisseurDoaJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

/**Tester suppression de données sur la DB compta
 * @author formation
 *
 */
public class TestDelete {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ResourceBundle fichierConf = ResourceBundle.getBundle("database");

		String driverName = fichierConf.getString("database.driver");
		Class.forName(driverName);
		String url = fichierConf.getString("database.url");
		String user = fichierConf.getString("database.user");
		String password = fichierConf.getString("database.password");
		Connection connection = DriverManager.getConnection(url, user, password);
		
		Fournisseur fournisseur = new Fournisseur("L''Espace Récréation");
		FournisseurDoaJdbc dao = new FournisseurDoaJdbc(connection);
		boolean update = dao.delete(fournisseur);
		
		if(update == true) {
			System.out.println("suppression réussit");
		}
		else if(update == false) {
			System.out.println("erreur");
		}
	}

}
