package uvsq.pglp_5_1.pglp_5_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Iterator;

public class AffichageGroupe implements Iterable<InterfacePersonnel>, Serializable {

	private static final long serialVersionUID = -3373682237002368918L;

	public Iterator<InterfacePersonnel> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	private int idPersonnel;
	private int idGenerator = 0;
	ArrayDeque<InterfacePersonnel> file;

	public AffichageGroupe() {
		file = new ArrayDeque<InterfacePersonnel>();
		idPersonnel = idGenerator = idGenerator + 1;

	}

	public int getIdPersonnel() {
		return this.idPersonnel;
	}

	public void ajouter(final InterfacePersonnel IntrPersonnel) {
		file.add(IntrPersonnel);
	}

	@Override
	public String toString() {
		String personnel = "";
		GroupePersonnel tmp;
		// affichage du parcours
		for (InterfacePersonnel c2 : file) {
			if (c2.getClass().equals(GroupePersonnel.class)) {
				tmp = (GroupePersonnel) c2;
				personnel += tmp.getIdPersonnel() + "\n";
			} else {
				personnel += ((Personnel) c2).toString();
			}
		}
		return personnel;
	}

	public void serialize(final String chemin) {
		ObjectOutputStream writer = null;
		try {
			FileOutputStream fichier = new FileOutputStream(chemin);
			writer = new ObjectOutputStream(fichier);
			writer.writeObject(this);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			System.err.println("La serialization a echoue vers le fichier");
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
	
	public static AffichageGroupe deserialize(final String chemin) {
        ObjectInputStream reader = null;
        AffichageGroupe apg = null;
        try {
            FileInputStream fichier = new FileInputStream(chemin);
            reader = new ObjectInputStream(fichier);
            apg = (AffichageGroupe) reader.readObject();
        } catch (IOException e) {
        	System.err.println("La deserialization a echoue vers le fichier");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return apg;
    }

}
