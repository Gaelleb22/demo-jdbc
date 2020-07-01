package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;
import fr.diginamic.jdbc.exceptions.DaoException;

public class FournisseurDoaJdbc implements FournisseurDao{
	
	protected Connection connection = connect();

	public List<Fournisseur> extraire() {
		
		List<Fournisseur> fournisseurs = new ArrayList();
		
		try {
			Statement statement = connect().createStatement();
			ResultSet curseur = statement.executeQuery("SELECT * FROM fournisseur");
			
			while(curseur.next()) {
				int id = curseur.getInt("ID");
				String nom = curseur.getString("NOM");
				Fournisseur fournisseur = new Fournisseur(id, nom);
				fournisseurs.add(fournisseur);
			}
			curseur.close();
			statement.close();
			this.connection.close();
			
			return fournisseurs;
		}catch (SQLException e) {
			throw new DaoException(e);
		}
		
	}

	public void insert(Fournisseur fournisseur) {
		try {
			Statement statement = connect().createStatement();
			statement.executeUpdate("INSERT INTO fournisseur(NOM) values ('"+fournisseur.getNom()+"')");
			statement.close();
			
			java.sql.Statement statement2 = this.connection.createStatement();
			ResultSet curseur = statement2.executeQuery("SELECT * FROM fournisseur");
			while(curseur.next()) {
				System.out.println(curseur.getInt("ID")+" "+curseur.getString("NOM"));
			}

			curseur.close();
			statement2.close();
			this.connection.close();
		} catch (SQLException e) {
			throw new DaoException("Erreur d'accès aux données !", e);
		}
		
	}

	public int update(String ancienNom, String nouveauNom) {
		int nb = 0;
		try {
			Statement statement = connect().createStatement();
			statement.executeUpdate("UPDATE fournisseur SET NOM = '"+nouveauNom+"' WHERE NOM LIKE '%"+ancienNom+"%'");
			statement.close();
			
			java.sql.Statement statement2 = connection.createStatement();
			ResultSet curseur = statement2.executeQuery("SELECT * FROM fournisseur");
			while(curseur.next()) {
				System.out.println(curseur.getInt("ID")+" "+curseur.getString("NOM"));
			}

			curseur.close();
			statement2.close();
			connection.close();
			
			return nb=1;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	public boolean delete(Fournisseur fournisseur) {
		
		boolean delete = false;

		
		try {
			Statement statement = connect().createStatement();
			statement.executeUpdate("DELETE FROM fournisseur WHERE NOM LIKE '%"+fournisseur.getNom()+"%'");
			
			Statement statement2 = this.connection.createStatement();
			ResultSet curseur = statement2.executeQuery("SELECT * FROM fournisseur");
			while(curseur.next()) {
				System.out.println(curseur.getInt("ID")+" "+curseur.getString("NOM"));
			}
			curseur.close();
			statement.close();
			statement2.close();
			this.connection.close();

			return delete = true;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	
	private Connection connect() {
		
		Connection connection = null;
		
		try {
			ResourceBundle fichierConf = ResourceBundle.getBundle("database");

			String driverName = fichierConf.getString("database.driver");
			Class.forName(driverName);
			String url = fichierConf.getString("database.url");
			String user = fichierConf.getString("database.user");
			String password = fichierConf.getString("database.password");
			connection = DriverManager.getConnection(url, user, password);
			
			return connection;
			
		} catch (SQLException e) {
			throw new DaoException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException();
		}
		
	}
	

}
