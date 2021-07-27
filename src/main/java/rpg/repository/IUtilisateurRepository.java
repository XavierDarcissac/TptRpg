package rpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rpg.model.Utilisateur;


public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	@Query("select u from Utilisateur u where u.pseudo = :pseudo")
	Utilisateur findByPseudo(@Param("pseudo") String pseudo); // @Query
	

}
