package rpg.repository.custom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rpg.repository.IMarchandRepositoryCustom;

public class IMarchandRepositoryCustomImpl implements IMarchandRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

		
	}
