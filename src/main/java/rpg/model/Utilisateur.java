package rpg.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("user")
public class Utilisateur extends Compte {
	
	@Transient
	//@OneToOne()
	//@JoinColumn()
	
	private Hero personnage;
	@Transient
	//@OneToOne()
	//@JoinColumn()
	private Inventaire inventaire;
	@Transient
	//@OneToOne()
	//@JoinColumn()
	private Arme arme;
	@Transient
	//@OneToOne()
	//@JoinColumn()
	
	private Armure armure;
	@Transient
	//@OneToOne()
	//@JoinColumn()
	
	private Histoire histoire;
	
	@Column()
	private double vie;
	@Column()
	private double attaque;
	@Column()
	private double defense;
	@Column()
	private double precision;
	@Column()
	private double vitesse;
	@Column()
	private double vieMax;
	@Column()
	private double attaqueMax;
	@Column()
	private double defenseMax;
	@Column()
	private double precisionMax;
	@Column()
	private double vitesseMax;
	@Column()
	private int cptEmpoisonnement;
	@Column()
	private int cptEtourdissement;
	@Column()
	private int cptSaignement;
	@Column()
	private int cptBrulure;
	@Column()
	private int cptCombat;
	@Column()
	private int cptCombatGagne;
	@Column()
	private int cptMonstreVaincu;
	@Column()
	private int exp;
	
	
	

}
