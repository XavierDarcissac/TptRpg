package rpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rpg.model.MarchandArme;

public interface IMarchandArmeRepository extends JpaRepository<MarchandArme, Long> {
	
	// check si l'article est présent chez le marchand lors de l'achat par exemple, a mettre directement dans la classe metier. 
	// l'interface est là pour les appels de base ?
	

}
