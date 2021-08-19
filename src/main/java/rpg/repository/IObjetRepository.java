package rpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rpg.model.Objet;

public interface IObjetRepository extends JpaRepository<Objet, Long>{
	@Query("select o.id from Objet o where o.nom = :nom")
	Integer findIdObjetForNom(@Param("nom") String nom);

	
	@Query("SELECT o FROM Objet o ORDER BY o.PrixAchat ASC")
	Objet orderByBuyingPriceAsc();
	
	@Query("SELECT o FROM Objet o ORDER BY o.PrixAchat DESC")
	Objet orderByBuyingPriceDesc();
	
	@Query("SELECT o FROM Objet o ORDER BY o.PrixVente ASC")
	Objet orderBySellingPriceAsc();
	
	@Query("SELECT o FROM Objet o ORDER BY o.PrixVente DESC")
	Objet orderBySellingPriceDesc();
	
	// Pour trouver les classer en fonction de leur type
	@Query("SELECT o FROM Objet o ORDER BY o.TypeObjet ASC")
	Objet findAllByTypeObjetAsc();
	@Query("SELECT o FROM Objet o ORDER BY o.TypeObjet DESC")
	Objet findAllByTypeObjetDesc();
	
	//Pour choisir un type precis à afficher
	@Query("SELECT o FROM Objet o WHERE o.TypeObjet = :type")
	Objet findTypeObjet(@Param("type") Long TypeObjet);
	
	
	@Query("SELECT o.qte FROM Objet o WHERE o.nom = 'Gold'")
	Objet findQteGold();
	
	
	
	@Query("SELECT o.PrixAchat FROM Objet o where o.nom = :nom")
	Objet findObjetBuyingPriceFromName(@Param("nom") Long nom);
	
	
	
	
	
}
