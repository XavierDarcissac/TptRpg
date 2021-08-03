package rpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rpg.model.Objet;

public interface IObjetRepository extends JpaRepository<Objet, Long>{

	
	@Query("SELECT o FROM Objet o ORDER BY p.PrixAchat ASC")
	Objet orderByBuyingPriceAsc();
	
	@Query("SELECT o FROM Objet o ORDER BY p.PrixAchat DESC")
	Objet orderByBuyingPriceDesc();
	
	@Query("SELECT o FROM Objet o ORDER BY p.PrixVente ASC")
	Objet orderBySellingPriceAsc();
	
	@Query("SELECT o FROM Objet o ORDER BY p.PrixVente DESC")
	Objet orderBySellingPriceDesc();
	
	@Query("SELECT o.qte FROM Objet o WHERE o.nom = 'Gold'")
	Objet findGold();
	

	
}
