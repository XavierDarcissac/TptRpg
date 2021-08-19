package rpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rpg.model.Arme;

public interface IArmeRepository extends JpaRepository<Arme, Long> {

	@Query("select a from Arme a where a.nom = :nom")
	Arme findByName(@Param("nom") String nom);

}
