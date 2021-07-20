package rpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rpg.model.Histoire;

public interface IHistoireRepository extends JpaRepository<Histoire, Long>{

}
