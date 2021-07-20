package rpg.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("monstre")
public class Monstre extends Personnage {
	@Enumerated(EnumType.STRING)
	@Column(name="TypeMonstre")
	private TypeMonstre typeMonstre;
	@Column()
	private double attaque;
	@Column()
	private double defense;
	@Column()
	private double vie;
	@Column()
	private double precision;
	@Column()
	private double vitesse;
	@Column()
	private int gold;
	@Column()
	private int exp;
	@ManyToOne
	@JoinColumn(name="arme_id")
	private Arme arme;
	@ManyToOne
	@JoinColumn(name="armure_id")
	private Armure armure;
	public Monstre() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Monstre(Long id, int version, String nom, List<Equipe> equipes) {
		super(id, version, nom, equipes);
		// TODO Auto-generated constructor stub
	}
	public Monstre(String nom, List<Equipe> equipes) {
		super(nom, equipes);
		// TODO Auto-generated constructor stub
	}
	
	public Monstre(TypeMonstre typeMonstre, double attaque, double defense, double vie, double precision,
			double vitesse, int gold, int exp, Arme arme, Armure armure) {
		this.typeMonstre = typeMonstre;
		this.attaque = attaque;
		this.defense = defense;
		this.vie = vie;
		this.precision = precision;
		this.vitesse = vitesse;
		this.gold = gold;
		this.exp = exp;
		this.arme = arme;
		this.armure = armure;
	}
	
	public Monstre(Long id, int version, String nom, List<Equipe> equipes, TypeMonstre typeMonstre, double attaque, double defense, double vie, double precision,
			double vitesse, int gold, int exp, Arme arme, Armure armure) {
		super(id, version, nom, equipes);
		this.typeMonstre = typeMonstre;
		this.attaque = attaque;
		this.defense = defense;
		this.vie = vie;
		this.precision = precision;
		this.vitesse = vitesse;
		this.gold = gold;
		this.exp = exp;
		this.arme = arme;
		this.armure = armure;
	}


	public TypeMonstre getTypeMonstre() {
		return typeMonstre;
	}


	public void setTypeMonstre(TypeMonstre typeMonstre) {
		this.typeMonstre = typeMonstre;
	}


	public double getAttaque() {
		return attaque;
	}


	public void setAttaque(double attaque) {
		this.attaque = attaque;
	}


	public double getDefense() {
		return defense;
	}


	public void setDefense(double defense) {
		this.defense = defense;
	}


	public double getVie() {
		return vie;
	}


	public void setVie(double vie) {
		this.vie = vie;
	}


	public double getPrecision() {
		return precision;
	}


	public void setPrecision(double precision) {
		this.precision = precision;
	}


	public double getVitesse() {
		return vitesse;
	}


	public void setVitesse(double vitesse) {
		this.vitesse = vitesse;
	}


	public int getGold() {
		return gold;
	}


	public void setGold(int gold) {
		this.gold = gold;
	}


	public int getExp() {
		return exp;
	}


	public void setExp(int exp) {
		this.exp = exp;
	}


	public Arme getArme() {
		return arme;
	}


	public void setArme(Arme arme) {
		this.arme = arme;
	}


	public Armure getArmure() {
		return armure;
	}


	public void setArmure(Armure armure) {
		this.armure = armure;
	}


	@Override
	public String toString() {
		return "Monstre [typeMonstre=" + typeMonstre + ", attaque=" + attaque + ", defense=" + defense + ", vie=" + vie
				+ ", precision=" + precision + ", vitesse=" + vitesse + ", gold=" + gold + ", exp=" + exp + ", arme="
				+ arme + ", armure=" + armure + "]";
	}
	
	
	
}
