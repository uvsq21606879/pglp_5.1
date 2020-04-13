package uvsq.pglp_5_1.pglp_5_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class DaoAffichageGroupe implements DAO<AffichageGroupe>, Serializable {

	private static final long serialVersionUID = -1934423717086910644L;
	
	   private ArrayList<AffichageGroupe> List;
	   
	   public DaoAffichageGroupe() {
	        List = new ArrayList<AffichageGroupe>();
	    }
	public void ajouter(AffichageGroupe object) {
		List.add(object);
		
	}

	public AffichageGroupe get(int id) {
		 for (AffichageGroupe apg : List) {
	            if (apg.getIdPersonnel() == id) {
	                return apg;
	            }
	        }
	        return null;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<AffichageGroupe> getList() {
		
		return (ArrayList<AffichageGroupe>) List.clone();
		
	}

	public void miseAjour(AffichageGroupe object, Map<String, Object> param) {
		if (List.contains(object)) {
            @SuppressWarnings("unchecked")
			ArrayList<InterfacePersonnel> remplace =
					(ArrayList<InterfacePersonnel>) param.get("file");
            if (param.containsKey("file")) {
                object.reset();
                for (InterfacePersonnel ip : remplace) {
                    object.ajouter(ip);
                }
            }
        }
		
	}

	public void supprimer(AffichageGroupe object) {
		
		 List.remove(object);
		
	}
	
	 public void serialize(final String path) {
	        ObjectOutputStream writer = null;
	        try {
	            FileOutputStream F = new FileOutputStream(path);
	            writer = new ObjectOutputStream(F);
	            writer.writeObject(this);
	            writer.flush();
	            writer.close();
	        } catch (IOException e) {
	            System.err.println("La serialization a echoue vers le fichier ");
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
	 
	  public static DaoAffichageGroupe deserialize(final String path) {
	        ObjectInputStream r = null;
	        DaoAffichageGroupe daoAPG = null;
	        try {
	            FileInputStream file = new FileInputStream(path);
	            r = new ObjectInputStream(file);
	            daoAPG = (DaoAffichageGroupe) r.readObject();
	        } catch (IOException e) {
	            System.err.println(" La deserialization a echoue depuis le fichier ");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        try {
	            if (r != null) {
	                r.close();
	            }
	        } catch (IOException E) {
	            E.printStackTrace();
	        }
	        return daoAPG;
	    }
	
	
}
