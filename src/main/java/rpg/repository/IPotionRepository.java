package rpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rpg.model.Potion;

public interface IPotionRepository  extends JpaRepository<Potion, Long>{
	
	@Query("SELECT p FROM Potion p ORDER BY p.PrixAchat ASC")
	Potion orderByBuyingPriceAsc();
	
	@Query("SELECT p FROM Potion p ORDER BY p.PrixAchat DESC")
	Potion orderByBuyingPriceDesc();
	
	@Query("SELECT p FROM Potion p ORDER BY p.PrixVente ASC")
	Potion orderBySellingPriceAsc();
	
	@Query("SELECT p FROM Potion p ORDER BY p.PrixVente DESC")
	Potion orderBySellingPriceDesc();
	
	
}
