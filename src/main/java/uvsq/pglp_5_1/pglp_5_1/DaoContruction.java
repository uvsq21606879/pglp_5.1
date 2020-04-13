package uvsq.pglp_5_1.pglp_5_1;

public class DaoContruction {

	private DaoContruction() {

	}

	public static DAO<Personnel> getDaoPersonnel(final String deserialize) {
		if (deserialize == null) {
			return new DaoPersonnel();
		} else {
			return DaoPersonnel.deserialize(deserialize);
		}
	}

	public static DAO<GroupePersonnel> getDaoCompositePersonnels(final String deserialize) {
		if (deserialize == null) {
			return new DaoComposite();
		} else {
			return DaoComposite.deserialize(deserialize);
		}
	}

	public static DAO<AffichageGroupe> getDaoAfficheParGroupe(final String deserialize) {
		if (deserialize == null) {
			return new DaoAffichageGroupe();
		} else {
			return DaoAffichageGroupe.deserialize(deserialize);
		}
	}

}
