package rpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rpg.model.Arme;

public interface IArmeRepository extends JpaRepository<Arme, Long> {

	
	@Query("SELECT a FROM Arme a ORDER BY p.PrixAchat ASC")
	Arme orderByBuyingPriceAsc();
	
	@Query("SELECT a FROM Arme a ORDER BY p.PrixAchat DESC")
	Arme orderByBuyingPriceDesc();
	
	@Query("SELECT a FROM Arme a ORDER BY p.PrixVente ASC")
	Arme orderBySellingPriceAsc();
	
	@Query("SELECT a FROM Arme a ORDER BY p.PrixVente DESC")
	Arme orderBySellingPriceDesc();
	
	@Query("SELECT a FROM Arme p ORDER BY p.TypeArme")
	Arme findAllByTypeArme();
}
