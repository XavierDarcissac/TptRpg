package rpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
	
	// Pour trouver les classer en fonction de leur type
	@Query("SELECT p FROM Potion p ORDER BY p.TypePotion ASC")
	Potion findAllByTypePotionAsc();
	@Query("SELECT p FROM Potion p ORDER BY p.TypePotion DESC")
	Potion findAllByTypePotionDesc();
	
	//Pour choisir un type precis à afficher
	@Query("SELECT p FROM Potion p WHERE p.TypePotion = :type")
	Potion findTypePotion(@Param("type") Long TypePotion);
	
	
	@Query("SELECT p.PrixAchat FROM Potion p where p.nom = :nom")
	Potion findPotionBuyingPriceFromName(@Param("nom") Long nom);
	

	
}
