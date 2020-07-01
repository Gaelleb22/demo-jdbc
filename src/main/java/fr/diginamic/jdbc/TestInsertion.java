package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


/**Tester les insertions sur la BD compta
 * @author formation
 *
 */
public class TestInsertion {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ResourceBundle fichierConf = ResourceBundle.getBundle("database");

		String driverName = fichierConf.getString("database.driver");
		Class.forName(driverName);
		String url = fichierConf.getString("database.url");
		String user = fichierConf.getString("database.user");
		String password = fichierConf.getString("database.password");
		Connection connection = DriverManager.getConnection(url, user, password);
		
		java.sql.Statement statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO fournisseur(NOM) values ('La Maison de la Peinture')");
		statement.close();
		
		java.sql.Statement statement2 = connection.createStatement();
		ResultSet curseur = statement2.executeQuery("SELECT * FROM fournisseur");
		while(curseur.next()) {
			System.out.println(curseur.getInt("ID")+" "+curseur.getString("NOM"));
		}

		curseur.close();
		statement2.close();
		connection.close();

	}

}
