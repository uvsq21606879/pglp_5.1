package uvsq.pglp_5_1.pglp_5_1;

import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.time.LocalDate;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Personnel implements Serializable {

	private static final long serialVersionUID = -2080828874542305205L;
	private int idPersonnel;
	private String Nom;
	private String Prenom;
	private LocalDate dateNaissance;
	ArrayList<String> NumsTelephone;

	public Personnel(Builder builder) {
		idPersonnel = builder.idPersonnel;
		Nom = builder.Nom;
		Prenom = builder.Prenom;
		dateNaissance = builder.dateNaissance;
		NumsTelephone = builder.NumsTelephone;
	}

	public int getIdPersonnel() {
		return idPersonnel;
	}

	public String getPrenom() {
		return Prenom;
	}

	public String getNom() {
		return Nom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;

	}

	public ArrayList<String> getNumsTelephone() {
		@SuppressWarnings("unchecked")
		ArrayList<String> clone = (ArrayList<String>) NumsTelephone.clone();
		return clone;
	}

	public static class Builder {

		private int idPersonnel;
		private String Nom;
		private String Prenom;
		private LocalDate dateNaissance;
		ArrayList<String> NumsTelephone;
		private int idGenerator = 0;

		public Builder(String nomPersonnel, String Prenom, LocalDate dateNaissance, ArrayList<String> numsTelP) {
			this.Nom = nomPersonnel;
			this.Prenom = Prenom;
			this.dateNaissance = dateNaissance;
			this.NumsTelephone = numsTelP;
			this.idPersonnel = idGenerator = idGenerator + 1;

		}

		public Personnel build() {
			return new Personnel(this);
		}

	}

	public String getPersonnel() {

		String P = this.Nom + "  " + this.Prenom + ", date de naissance:" + this.dateNaissance.toString()
				+ ", Nomeros de telephone : ";
		String Numeros = "";

		for (String i : this.NumsTelephone)
			Numeros = Numeros + i;

		P = P + Numeros;

		return P;

	}

	public void serialize(String path) {
		ObjectOutputStream writer = null;
		try {
			FileOutputStream file = new FileOutputStream(path);
			writer = new ObjectOutputStream(file);
			writer.writeObject(this);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			System.out.println("erreur de serialization vers le fichier /" + path);
		}
		
		try {
			if(writer != null) {
				writer.flush();
				writer.close();
			}
			}catch(IOException E) {
				E.printStackTrace();
			}
		}
	
	public static Personnel deserialize(String path) throws ClassNotFoundException {
		
		ObjectInputStream reader = null;
		Personnel p =null;
		
		try {
			 FileInputStream file = new FileInputStream(path);
	            reader = new ObjectInputStream(file);
	            p = (Personnel) reader.readObject();
		}catch(IOException e) {
			System.err.println( "echec deserialization  /" + path );
			
		}
		
		try {
			if(reader != null) {
				reader.close();
			}
		}catch (IOException E) {
			E.printStackTrace();
		}
		return p;
		
	}
	

}
