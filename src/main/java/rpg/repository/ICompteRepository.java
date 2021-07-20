package rpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rpg.model.Compte;

public interface ICompteRepository extends JpaRepository<Compte, Long> {

}
