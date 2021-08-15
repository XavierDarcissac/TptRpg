package rpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rpg.model.InventairePotion;
import rpg.model.Potion;

public interface IInventairePotionRepository  extends JpaRepository<InventairePotion, Long>{

	
	@Query("DELETE i FROM Inventaire i where p.nom = :nom")
	Potion SuppressionPotionInventaire(@Param("nom") Long nom);
	
}
