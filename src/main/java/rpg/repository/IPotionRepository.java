package rpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rpg.model.Potion;

public interface IPotionRepository  extends JpaRepository<Potion, Long>{

}
