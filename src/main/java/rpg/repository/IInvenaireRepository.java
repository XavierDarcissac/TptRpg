package rpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rpg.model.Inventaire;

public interface IInvenaireRepository extends JpaRepository<Inventaire, Long>{

}