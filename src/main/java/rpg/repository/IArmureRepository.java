package rpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rpg.model.Armure;

public interface IArmureRepository extends JpaRepository<Armure, Long> {

	
	@Query("SELECT a FROM Armure a ORDER BY p.PrixAchat ASC")
	Armure orderByBuyingPriceAsc();
	
	@Query("SELECT a FROM Armure a ORDER BY p.PrixAchat DESC")
	Armure orderByBuyingPriceDesc();
	
	@Query("SELECT a FROM Armure a ORDER BY p.PrixVente ASC")
	Armure orderBySellingPriceAsc();
	
	@Query("SELECT a FROM Armure a ORDER BY p.PrixVente DESC")
	Armure orderBySellingPriceDesc();
	
}
