package uvsq.pglp_5_1.pglp_5_1;

import java.util.ArrayList;
import java.util.Map;

public interface DAO<T> {
	
	  void ajouter(T object);
	  
	  T get(int id);
	  
	  ArrayList<T> getList();
	  
	  void miseAjour(T object, Map<String, Object> params);
	  
	  void supprimer(T object);
	  
}
