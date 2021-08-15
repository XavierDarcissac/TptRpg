package rpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rpg.model.Arme;

public interface IArmeRepository extends JpaRepository<Arme, Long> {

	
	@Query("SELECT a FROM Arme a ORDER BY a.PrixAchat ASC")
	Arme orderByBuyingPriceAsc();
	
	@Query("SELECT a FROM Arme a ORDER BY a.PrixAchat DESC")
	Arme orderByBuyingPriceDesc();
	
	@Query("SELECT a FROM Arme a ORDER BY a.PrixVente ASC")
	Arme orderBySellingPriceAsc();
	
	@Query("SELECT a FROM Arme a ORDER BY a.PrixVente DESC")
	Arme orderBySellingPriceDesc();
	
	@Query("SELECT a FROM Arme a ORDER BY a.TypeArme")
	Arme findAllByTypeArme();
	
	// Pour trouver les classer en fonction de leur type
	@Query("SELECT a FROM Arme a ORDER BY a.TypeArme ASC")
	Arme findAllByTypeArmeAsc();
	@Query("SELECT a FROM Arme a ORDER BY a.TypeArme DESC")
	Arme findAllByTypeArmeDesc();
	
	//Pour choisir un type precis à afficher
	@Query("SELECT a FROM Arme a WHERE a.TypeArme = :type")
	Arme findTypeArme(@Param("type") Long TypeArme);
	
	@Query("SELECT a.PrixAchat FROM Arme a where a.nom = :nom")
	Arme findArmeBuyingPriceFromName(@Param("nom") Long nom);
}
