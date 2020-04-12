package uvsq.pglp_5_1.pglp_5_1;

import static org.junit.Assert.*;
import java.io.File;
import java.util.Iterator;
import org.junit.Test;

public class GroupePersonnelTest {
	
	@Test
	public void GroupePersonnelTest() {
		GroupePersonnel personnel = new GroupePersonnel();
		Iterator<Personnel> ItPersonnel = personnel.iterator();
		assertFalse(ItPersonnel.hasNext());
	}
	
	public void ajouterTest() {
		GroupePersonnel personnel = new GroupePersonnel();
		personnel.ajouter(new GroupePersonnel());
		Iterator<Personnel> ItPersonnel = personnel.iterator();
		assertTrue(ItPersonnel.hasNext());
	}
	
	@Test
	public void SerializationTest() {
	    GroupePersonnel personnel = new GroupePersonnel();
	    GroupePersonnel personnel2 = new GroupePersonnel();
        personnel.ajouter(personnel2);
        
        personnel.serialize("cp.ser");
        GroupePersonnel personnel3 = GroupePersonnel.deserialize("cp.ser");
        File f = new File("cp.ser");
        f.delete();
        assertTrue(personnel.toString().equals(personnel3.toString()));
	}
	@Test
	public void testSuppression() {
		GroupePersonnel personnel = new GroupePersonnel();
		GroupePersonnel personnel2 = new GroupePersonnel();
		GroupePersonnel iterator = personnel2;
		personnel.ajouter(personnel2);
		personnel.supprimer(iterator);
		Iterator<Personnel> ip = personnel.iterator();
		assertFalse(ip.hasNext());
	}
	
	 @Test
	    public void TestDeserialize() {
	        GroupePersonnel grp = GroupePersonnel.deserialize("test");
	        assertNull(grp);
	    }

}
