package rpg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import rpg.model.MarchandPotion;

public interface IMarchandPotionRepository extends JpaRepository<MarchandPotion, Long> {

	
	public default Optional<MarchandPotion> achatPotion(Long id) {
		
		
		Optional<MarchandPotion> query = findById(id);
		return query;
	
	}
		

		
}
