package rpg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rpg.model.Arme;
import rpg.model.InventaireArme;
import rpg.model.TypeArme;

public interface IInventaireArmeRepository  extends JpaRepository<InventaireArme, Long>{
	@Query("select ip.armure from InventaireArme ip  where ip.inventaire.id = :id")
	List<Arme> findAllArmeByInventaireId(@Param("id") Long id); // @Query
	
	@Query("select ip.arme from InventaireArme ip  where ip.arme.typeArme = :type")
	List<Arme> findAllArmureByType( @Param("type") TypeArme type); // @Query
	
	@Query("select ip.arme from InventaireArme ip  where ip.arme.typeArme = :type and ip.inventaire.id = :id")
	List<Arme> findAllPotionByTypeAndInventaireId( @Param("type") TypeArme type,@Param("id") Long id); // @Query

}
