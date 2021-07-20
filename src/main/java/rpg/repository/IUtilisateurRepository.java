package rpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rpg.model.Utilisateur;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Long> {

}
