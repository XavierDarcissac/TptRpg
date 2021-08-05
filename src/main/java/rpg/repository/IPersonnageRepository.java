package rpg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rpg.model.Hero;
import rpg.model.Monstre;
import rpg.model.Personnage;
import rpg.model.TypeMonstre;
import rpg.model.TypePersonnage;

public interface IPersonnageRepository extends JpaRepository<Personnage, Long> {
	@Query("select h from Hero h ")
	List<Hero> findAllHero();
	
	@Query("select h from Hero h where h.typePersonnage = :type")
	List<Hero> findAllHeroWithSpecificType(@Param("type") TypePersonnage type);
	
	@Query("select m from Monstre m ")
	List<Monstre> findAllMonstre();
	
	@Query("select m from Monstre m where m.typeMonstre = :type")
	List<Monstre> findAllMonstreWithSpecificType(@Param("type") TypeMonstre type);	 
}
