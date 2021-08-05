package rpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rpg.model.Inventaire;
import rpg.model.Utilisateur;


public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	
	///////////////////////////////////////////////////
	/////////////////// Find //////////////////////////
	//////////////////////////////////////////////////
	@Query("select u from Utilisateur u where u.pseudo = :pseudo")
	Utilisateur findByPseudo(@Param("pseudo") String pseudo); // @Query
	
	@Query("select u from Utilisateur u where u.mail = :mail")
	Utilisateur findUserByMail(@Param("mail") String mail); // @Query
	
	@Query("select u.inventaire from Utilisateur u where u.pseudo = :pseudo")
	Inventaire findInventaireByPseudoUser(@Param("pseudo") String pseudo);
	
	
	///////////////////////////////////////////////////
	/////////////////// Delete ////////////////////////
	//////////////////////////////////////////////////
	@Modifying
	@Query("delete Utilisateur u where u.mail = :mail")
	void deleteUserByMail(@Param("mail") String mail);
	
	@Modifying
	@Query("delete Utilisateur u where u.pseudo = :pseudo")
	void deleteUserByPseudo(@Param("pseudo") String pseudo);
	
	///////////////////////////////////////////////////
	/////////////////// Update ////////////////////////
	//////////////////////////////////////////////////
	
	@Modifying
	@Query("update Utilisateur u set u.pseudo = ?1 where u.pseudo = ?2")	
	void updateUserPseudo(String newPseudo,String pseudo);
	
	@Modifying
	@Query("update Utilisateur u set u.mdp = ?1 where u.mail = ?2")
	void updateUserMdpByUserMail(String newMdp, String mail);
	
	@Modifying
	@Query("update Utilisateur u set u.mdp = ?1, u.mail = ?2 where u.mail = ?3")
	void updateUserMdpAndMailByUserMail(String newMdp, String newMail, String mail);
	

}
