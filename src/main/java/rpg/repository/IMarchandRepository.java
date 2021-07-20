package rpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rpg.model.Marchand;

public interface IMarchandRepository extends JpaRepository<Marchand, Long> {

}
