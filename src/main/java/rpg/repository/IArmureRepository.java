package rpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rpg.model.Armure;

public interface IArmureRepository extends JpaRepository<Armure, Long> {

	
	@Query("SELECT a FROM Armure a ORDER BY a.PrixAchat ASC")
	Armure orderByBuyingPriceAsc();
	
	@Query("SELECT a FROM Armure a ORDER BY a.PrixAchat DESC")
	Armure orderByBuyingPriceDesc();
	
	@Query("SELECT a FROM Armure a ORDER BY a.PrixVente ASC")
	Armure orderBySellingPriceAsc();
	
	@Query("SELECT a FROM Armure a ORDER BY a.PrixVente DESC")
	Armure orderBySellingPriceDesc();
	
	// Pour trouver les classer en fonction de leur type
	@Query("SELECT a FROM Armure a ORDER BY a.TypeArmure ASC")
	Armure findAllByTypeArmureAsc();
	@Query("SELECT a FROM Armure a ORDER BY a.TypeArmure DESC")
	Armure findAllByTypeArmureDesc();
	
	//Pour choisir un type precis à afficher
	@Query("SELECT a FROM Armure a WHERE a.TypeArmure = :type")
	Armure findTypeArmure(@Param("type") Long TypeArmure);
	
	
	@Query("SELECT a.PrixAchat FROM Armure a where a.nom = :nom")
	Armure findArmureBuyingPriceFromName(@Param("nom") Long nom);
	@Query("select a from Armure a where a.nom = :nom")
	Armure findByName(@Param("nom") String nom);
}
