package rpg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rpg.model.Inventaire;
import rpg.model.InventairePotion;
import rpg.model.Potion;
import rpg.model.TypePotion;

public interface IInventairePotionRepository  extends JpaRepository<InventairePotion, Long>{
	@Query("select ip.potion from InventairePotion ip  where ip.inventaire.id = :id")
	List<Potion> findAllPotionByInventaireId(@Param("id") Long id); // @Query
	
	@Query("select ip.potion from InventairePotion ip  where ip.potion.type = :type")
	List<Potion> findAllPotionByType( @Param("type") TypePotion type); // @Query
	
	@Query("select ip.potion from InventairePotion ip  where ip.potion.type = :type and ip.inventaire.id = :id")
	List<Potion> findAllPotionByTypeAndInventaireId( @Param("type") TypePotion type,@Param("id") Long id); // @Query

	@Query("select ip.potion from InventairePotion ip where ip.potion.nom = :nom and ip.inventaire.id = :id")
	Potion findPotionNameInInveantaire(@Param("nom") String nom, @Param("id") Long id);
	
	@Query("select ip from InventairePotion ip where ip.potion.id = :idP and ip.inventaire.id = :idInv")
	InventairePotion findInventairePotionByIdPotionAndIdInv(@Param("idP") Long idP, @Param("idInv") Long idInv);
	
	
}
