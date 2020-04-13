package uvsq.pglp_5_1.pglp_5_1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class DaoPersonnel implements DAO<Personnel>, Serializable {


	private static final long serialVersionUID = 3843900432749650407L;
	
	 private ArrayList<Personnel> list;
	 
	 public DaoPersonnel() {
	        list = new ArrayList<Personnel>();
	    }

	public void ajouter(Personnel personnel) {
		// TODO Auto-generated method stub
		list.add(personnel);
	}

	public Personnel get(int id) {
		
	        for (Personnel p : list) {
	            if (p.getIdPersonnel() == id) {
	                return p;
	            }
	        }
	        return null;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Personnel> getList() {
		 return (ArrayList<Personnel>) list.clone();
	}

	public void miseAjour(Personnel personnel, Map<String, Object> params) {
		// TODO Auto-generated method stub
			String Nom = "";
			String Prenom = "";
			LocalDate dateNaissance;
			ArrayList<String> NumsTelephone;
		  if (list.remove(personnel)) {
	            
	            if (params.containsKey("Nom")) {
	                Nom = (String) params.get("Nom");
	            } else {
	                Nom = personnel.getNom();
	            }
	            
	            if (params.containsKey("Prenom")) {
	                Prenom = (String) params.get("Prenom");
	            } else {
	                Prenom = personnel.getPrenom();
	            }
	            
	            if (params.containsKey("dateNaissance")) {
	                dateNaissance = (LocalDate) params.get("dateNaissance");
	            } else {
	                dateNaissance = personnel.getDateNaissance();
	            }
	           
	            if (params.containsKey("NumsTelephone")) {
	                ArrayList<String> tmp;
	                tmp = (ArrayList<String>) params.get("NumsTelephone");
	                NumsTelephone = (ArrayList<String>) tmp.clone();
	            } else {
	            	NumsTelephone = personnel.getNumsTelephone();
	            }
	            Personnel p = new Personnel.Builder(
	                Nom, Prenom, dateNaissance, NumsTelephone).build();
	            list.add(p);
	        }
		
	}

	public void supprimer(Personnel personnel) {
		// TODO Auto-generated method stub
		
	}
	
	

}
