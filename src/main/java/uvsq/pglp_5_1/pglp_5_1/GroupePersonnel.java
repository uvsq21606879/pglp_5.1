package uvsq.pglp_5_1.pglp_5_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;



public class GroupePersonnel implements Iterable<InterfacePersonnel>, Serializable, InterfacePersonnel {


	private static final long serialVersionUID = -2268954669830584120L;
	
	private int idPersonnel;
	private int idGenerator;
	private ArrayList<InterfacePersonnel> Personnels;
	  
	 public GroupePersonnel() {
	        idPersonnel = idGenerator++;
	        Personnels = new ArrayList<InterfacePersonnel>();
	    }
	 @Override
	 public String toString() {
	        String s = "IdPersonnel = " + idPersonnel + "\n";
	        for (InterfacePersonnel ip : Personnels) {
	            s += ip.toString();
	        }
	        return s;
	    }
	 
	
	public GroupePersonnel ajouter(final InterfacePersonnel ip) {
	        if (!Personnels.contains(ip)) {
	        	
	            Personnels.add(ip);
	        }
	        return this;
	    }
	 
	 
	public GroupePersonnel supprimer(InterfacePersonnel ip) {
	        System.out.println(Personnels.remove(ip));
	        return this;
	    }
	 
	 public int getIdPersonnel() {
	        return idPersonnel;
	    }
	 
	  public Iterator<InterfacePersonnel> iterator() {

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
