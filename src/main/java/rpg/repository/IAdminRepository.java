package rpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rpg.model.Admin;

public interface IAdminRepository extends JpaRepository<Admin, Long>{

}
