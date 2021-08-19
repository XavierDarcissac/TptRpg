package rpg.repository.custom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import rpg.model.Potion;
import rpg.repository.IPotionRepositoryCustom;

public class IPotionRepositoryCustomImpl implements IPotionRepositoryCustom {
	@PersistenceContext
	private EntityManager em;

	@Override
	public double PrixAchatPotion(String nom) {
		
		String queryString = "SELECT p.PrixAchat FROM Potion p where p.nom = :nom";
				
		TypedQuery<Potion> query = em.createQuery(queryString, Potion.class);
		
		query.setParameter("nom", nom);
		
		return query.getFirstResult();
		
	}


	
}