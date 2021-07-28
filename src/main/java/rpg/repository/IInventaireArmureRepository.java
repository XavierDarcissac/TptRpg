package rpg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rpg.model.Armure;
import rpg.model.InventaireArmure;
import rpg.model.TypeArmure;

public interface IInventaireArmureRepository  extends JpaRepository<InventaireArmure, Long>{
//	@Query("select ip.armure from InventaireArmure ip  where ip.inventaire.id = :id")
//	List<Armure> findAllArmeByInventaireId(@Param("id") Long id); // @Query
//	
//	@Query("select ip.armure from InventaireArmure ip  where ip.armure.typearmure = :type")
//	List<Armure> findAllArmureByType( @Param("type") TypeArmure type); // @Query
//	
//	@Query("select ip.armure from InventaireArmure ip  where ip.armure.typearmure = :type and ip.inventaire.id = :id")
//	List<Armure> findAllPotionByTypeAndInventaireId( @Param("type") TypeArmure type,@Param("id") Long id); // @Query

}
