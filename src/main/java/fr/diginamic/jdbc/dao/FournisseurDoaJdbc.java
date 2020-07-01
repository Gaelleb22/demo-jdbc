package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

public class FournisseurDoaJdbc implements FournisseurDao{
	
	protected Connection connection = null;
	
	public FournisseurDoaJdbc(Connection connection) {
		this.connection = connection;
	}

	public List<Fournisseur> extraire() {
		
		List<Fournisseur> fournisseurs = new ArrayList();
		
		try {
			java.sql.Statement statement=null;
			ResultSet curseur=null;
			statement = this.connection.createStatement();
			curseur = statement.executeQuery("SELECT * FROM fournisseur");
			
			while(curseur.next()) {
				int id = curseur.getInt("ID");
				String nom = curseur.getString("NOM");
				Fournisseur fournisseur = new Fournisseur(id, nom);
				fournisseurs.add(fournisseur);
			}
			curseur.close();
			statement.close();
			this.connection.close();
		}catch (SQLException e) {
			throw new RuntimeException();
		}
		
		return fournisseurs;
	}

	public void insert(Fournisseur fournisseur) {
		try {
			java.sql.Statement statement = this.connection.createStatement();
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
			throw new RuntimeException();
		}
		
	}

	public int update(String ancienNom, String nouveauNom) {
		int nb = 0;
		try {
			java.sql.Statement statement = connection.createStatement();
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
			
			nb=1;
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return nb;
	}

	public boolean delete(Fournisseur fournisseur) {
		
		boolean delete = false;
		
		try {
			java.sql.Statement statement = this.connection.createStatement();
			statement.executeUpdate("DELETE FROM fournisseur WHERE NOM LIKE '%"+fournisseur.getNom()+"%'");
			statement.close();
			
			java.sql.Statement statement2 = this.connection.createStatement();
			ResultSet curseur = statement2.executeQuery("SELECT * FROM fournisseur");
			while(curseur.next()) {
				System.out.println(curseur.getInt("ID")+" "+curseur.getString("NOM"));
			}

			curseur.close();
			statement2.close();
			this.connection.close();
			delete = true;
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return delete;
	}
	

}
