package rpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rpg.model.Personnage;

public interface IPersonnageRepository extends JpaRepository<Personnage, Long> {

}
