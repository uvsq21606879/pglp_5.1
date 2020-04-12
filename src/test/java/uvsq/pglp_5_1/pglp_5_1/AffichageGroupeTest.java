package uvsq.pglp_5_1.pglp_5_1;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

public class AffichageGroupeTest {

	@Test
	public void test() {
		GroupePersonnel p1 = new GroupePersonnel();
		GroupePersonnel p2 = new GroupePersonnel();
		GroupePersonnel p3 = new GroupePersonnel();
		GroupePersonnel p4 = new GroupePersonnel();
		GroupePersonnel p5 = new GroupePersonnel();
		GroupePersonnel p6 = new GroupePersonnel();

		ArrayList<String> numero = new ArrayList<String>();
		numero.add("06 81 64 62 78");
		numero.add("07 71 64 92 18");
		Personnel p = new Personnel.Builder("Seghir", "Said", LocalDate.of(1997, 03, 15), numero).build();
		p6.ajouter(p);
		p4.ajouter(p5);
		p4.ajouter(p6);
		p3.ajouter(p4);
		p1.ajouter(p2);
		p1.ajouter(p3);
		AffichageGroupe apg = new AffichageGroupe();
		apg.parcoursGroupes(p1);
		Iterator<InterfacePersonnel> tmp = apg.iterator();

		ArrayList<InterfacePersonnel> list = new ArrayList<InterfacePersonnel>();
		ArrayList<InterfacePersonnel> list2 = new ArrayList<InterfacePersonnel>();

		for (; tmp.hasNext(); list.add(tmp.next()))
			;
		list2.add(p1);
		list2.add(p2);
		list2.add(p3);
		list2.add(p4);
		list2.add(p5);
		list2.add(p6);
		list2.add(p);
		System.out.println(list2.toString());
		assertTrue(list.toString().equalsIgnoreCase(list2.toString()));
	}

}
