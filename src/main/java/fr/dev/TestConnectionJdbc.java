package fr.dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.mariadb.jdbc.Driver;

/**tester la connection à la BD compta
 * @author formation
 *
 */
public class TestConnectionJdbc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ResourceBundle fichierConf = ResourceBundle.getBundle("database");

//		String driverName = fichierConf.getString("database.driver");
//		Class.forName(driverName);
//		String url = fichierConf.getString("database.url");
//		String user = fichierConf.getString("database.user");
//		String password = fichierConf.getString("database.password");
//		Connection connection = DriverManager.getConnection(url, user, password);

//		System.out.println(connection.toString());

//		connection.close();
		
		String driverName2 = fichierConf.getString("db.clevercloud.driver");
		Class.forName(driverName2);
		String url2 = fichierConf.getString("db.clevercloud.url");
		String user2 = fichierConf.getString("db.clevercloud.user");
		String password2 = fichierConf.getString("db.clevercloud.password");
		Connection connection2 = DriverManager.getConnection(url2, user2, password2);

		System.out.println(connection2.toString());

		connection2.close();

	}

}
