package uvsq.pglp_5_1.pglp_5_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;



public class GroupePersonnel implements Iterable<Personnel>, Serializable {


	private static final long serialVersionUID = -2268954669830584120L;
	
	private int idPersonnel;
	private int idGenerator;
	private ArrayList<Personnel> Personnels;
	  
	 public GroupePersonnel() {
	        idPersonnel = idGenerator++;
	        Personnels = new ArrayList<Personnel>();
	    }
	 @Override
	 public String toString() {
	        String s = "IdPersonnel = " + idPersonnel + "\n";
	        for (Personnel ip : Personnels) {
	            s += ip.toString();
	        }
	        return s;
	    }
	 
	 @SuppressWarnings({ "unlikely-arg-type", "unchecked" })
	public GroupePersonnel ajouter(final GroupePersonnel ip) {
	        if (!Personnels.contains(ip)) {
	        	
	            Personnels.addAll((Collection<? extends Personnel>) ip);
	        }
	        return this;
	    }
	 
	 @SuppressWarnings("unlikely-arg-type")
	public GroupePersonnel supprimer(GroupePersonnel ip) {
	        System.out.println(Personnels.remove(ip));
	        return this;
	    }
	 
	 public int getIdPersonnel() {
	        return idPersonnel;
	    }
	 
	  public Iterator<Personnel> iterator() {
		// TODO Auto-generated method stub
		return Personnels.iterator();
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
	            System.err.println(
	            "La serialization a échoué vers le fichier \""
	            + path + "\"");
	        }
	        try {
	            if (writer != null) {
	                writer.flush();
	                writer.close();
	            }
	        } catch (IOException E) {
	            E.printStackTrace();
	        }
	    }
	  
	  public static GroupePersonnel deserialize(final String path) {
	        ObjectInputStream read = null;
	        GroupePersonnel cp = null;
	        try {
	            FileInputStream file = new FileInputStream(path);
	            read = new ObjectInputStream(file);
	            cp = (GroupePersonnel) read.readObject();
	        } catch (IOException e) {
	            System.err.println(
	            "La deserialization a échoué depuis le fichier \""
	            + path + "\"");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        try {
	            if (read != null) {
	                read.close();
	            }
	        } catch (IOException E) {
	            E.printStackTrace();
	        }
	        return cp;
	    }
	  
	
	
}
