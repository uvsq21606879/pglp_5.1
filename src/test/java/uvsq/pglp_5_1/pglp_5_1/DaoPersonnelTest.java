package uvsq.pglp_5_1.pglp_5_1;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

public class DaoPersonnelTest {

	@Test
	public void test() {
		DaoPersonnel P = new DaoPersonnel();
		ArrayList<String> numero = new ArrayList<String>();
		numero.add("06 81 64 62 78");
		numero.add("07 71 64 92 18");
		Personnel p1 = new Personnel.Builder("Seghir", "Said", LocalDate.of(1997, 03, 04), numero).build();
		Personnel p2 = new Personnel.Builder("Rayane", "ssss", LocalDate.of(1998, 05, 04), numero).build();
		P.ajouter(p1);
		P.ajouter(p2);
		assertTrue(P.getList().size() == 2 && P.getList().get(0) == p1 && P.getList().get(1) == p2);

	}


}
