package rpg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rpg.model.Potion;
import rpg.model.Utilisateur;

public interface IPotionRepository  extends JpaRepository<Potion, Long>{
	

}
