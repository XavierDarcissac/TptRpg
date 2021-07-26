package rpg.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@DiscriminatorValue("user")
public class Utilisateur extends Compte {
	

	@ManyToOne
	@JoinColumn(name="hero_id")
	private Hero hero;
	

	@OneToOne
	@JoinColumn(name="inventaire")
	private Inventaire inventaire;
	
	
	@ManyToOne
	@JoinColumn(name="Arme")
	private Arme arme;
	
	@ManyToOne
	@JoinColumn(name="Armure")
	private Armure armure;
	
	@OneToOne
	@JoinColumn(name="histoire")
	private Histoire histoire;

	
	@Column()
	private double vie;
	@Column()
	private double attaque;
	@Column()
	private double defense;
	@Column()
	private double agilite;
	@Column()
	private double vitesse;
	@Column()
	private double vieMax;
	@Column()
	private double attaqueMax;
	@Column()
	private double defenseMax;
	@Column()
	private double agiliteMax;
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
	
	
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Utilisateur(Long id, int version, String pseudo, String mail, String mdp) {
		super(id, version, pseudo, mail, mdp);
		// TODO Auto-generated constructor stub
	}
	public Utilisateur(String pseudo, String mail, String mdp) {
		super(pseudo, mail, mdp);
		// TODO Auto-generated constructor stub
	}
	public Utilisateur(Long id, int version, String pseudo, String mail, String mdp, Hero hero, Inventaire inventaire, Arme arme, Armure armure, Histoire histoire, double vie,
			double attaque, double defense, double agilite, double vitesse, double vieMax, double attaqueMax,
			double defenseMax, double agiliteMax, double vitesseMax, int cptEmpoisonnement, int cptEtourdissement,
			int cptSaignement, int cptBrulure, int cptCombat, int cptCombatGagne, int cptMonstreVaincu, int exp) {
		super(id, version, pseudo, mail, mdp);
		this.hero = hero;
		this.inventaire = inventaire;
		this.arme = arme;
		this.armure = armure;
		this.histoire = histoire;
		this.vie = vie;
		this.attaque = attaque;
		this.defense = defense;
		this.agilite = agilite;
		this.vitesse = vitesse;
		this.vieMax = vieMax;
		this.attaqueMax = attaqueMax;
		this.defenseMax = defenseMax;
		this.agiliteMax = agiliteMax;
		this.vitesseMax = vitesseMax;
		this.cptEmpoisonnement = cptEmpoisonnement;
		this.cptEtourdissement = cptEtourdissement;
		this.cptSaignement = cptSaignement;
		this.cptBrulure = cptBrulure;
		this.cptCombat = cptCombat;
		this.cptCombatGagne = cptCombatGagne;
		this.cptMonstreVaincu = cptMonstreVaincu;
		this.exp = exp;
	}
	
	
	public Utilisateur(Hero hero, Inventaire inventaire, Arme arme, Armure armure, Histoire histoire, double vie,
			double attaque, double defense, double agilite, double vitesse, double vieMax, double attaqueMax,
			double defenseMax, double agiliteMax, double vitesseMax, int cptEmpoisonnement, int cptEtourdissement,
			int cptSaignement, int cptBrulure, int cptCombat, int cptCombatGagne, int cptMonstreVaincu, int exp) {
		this.hero = hero;
		this.inventaire = inventaire;
		this.arme = arme;
		this.armure = armure;
		this.histoire = histoire;
		this.vie = vie;
		this.attaque = attaque;
		this.defense = defense;
		this.agilite = agilite;
		this.vitesse = vitesse;
		this.vieMax = vieMax;
		this.attaqueMax = attaqueMax;
		this.defenseMax = defenseMax;
		this.agiliteMax = agiliteMax;
		this.vitesseMax = vitesseMax;
		this.cptEmpoisonnement = cptEmpoisonnement;
		this.cptEtourdissement = cptEtourdissement;
		this.cptSaignement = cptSaignement;
		this.cptBrulure = cptBrulure;
		this.cptCombat = cptCombat;
		this.cptCombatGagne = cptCombatGagne;
		this.cptMonstreVaincu = cptMonstreVaincu;
		this.exp = exp;
	}
	public Hero getHero() {
		return hero;
	}
	public void setHero(Hero hero) {
		this.hero = hero;
	}
	public Inventaire getInventaire() {
		return inventaire;
	}
	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
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
	public Histoire getHistoire() {
		return histoire;
	}
	public void setHistoire(Histoire histoire) {
		this.histoire = histoire;
	}
	public double getVie() {
		return vie;
	}
	public void setVie(double vie) {
		this.vie = vie;
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
	public double getPrecision() {
		return agilite;
	}
	public void setPrecision(double agilite) {
		this.agilite = agilite;
	}
	public double getVitesse() {
		return vitesse;
	}
	public void setVitesse(double vitesse) {
		this.vitesse = vitesse;
	}
	public double getVieMax() {
		return vieMax;
	}
	public void setVieMax(double vieMax) {
		this.vieMax = vieMax;
	}
	public double getAttaqueMax() {
		return attaqueMax;
	}
	public void setAttaqueMax(double attaqueMax) {
		this.attaqueMax = attaqueMax;
	}
	public double getDefenseMax() {
		return defenseMax;
	}
	public void setDefenseMax(double defenseMax) {
		this.defenseMax = defenseMax;
	}
	public double getPrecisionMax() {
		return agiliteMax;
	}
	public void setPrecisionMax(double agiliteMax) {
		this.agiliteMax = agiliteMax;
	}
	public double getVitesseMax() {
		return vitesseMax;
	}
	public void setVitesseMax(double vitesseMax) {
		this.vitesseMax = vitesseMax;
	}
	public int getCptEmpoisonnement() {
		return cptEmpoisonnement;
	}
	public void setCptEmpoisonnement(int cptEmpoisonnement) {
		this.cptEmpoisonnement = cptEmpoisonnement;
	}
	public int getCptEtourdissement() {
		return cptEtourdissement;
	}
	public void setCptEtourdissement(int cptEtourdissement) {
		this.cptEtourdissement = cptEtourdissement;
	}
	public int getCptSaignement() {
		return cptSaignement;
	}
	public void setCptSaignement(int cptSaignement) {
		this.cptSaignement = cptSaignement;
	}
	public int getCptBrulure() {
		return cptBrulure;
	}
	public void setCptBrulure(int cptBrulure) {
		this.cptBrulure = cptBrulure;
	}
	public int getCptCombat() {
		return cptCombat;
	}
	public void setCptCombat(int cptCombat) {
		this.cptCombat = cptCombat;
	}
	public int getCptCombatGagne() {
		return cptCombatGagne;
	}
	public void setCptCombatGagne(int cptCombatGagne) {
		this.cptCombatGagne = cptCombatGagne;
	}
	public int getCptMonstreVaincu() {
		return cptMonstreVaincu;
	}
	public void setCptMonstreVaincu(int cptMonstreVaincu) {
		this.cptMonstreVaincu = cptMonstreVaincu;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	@Override
	public String toString() {
		return "Utilisateur [hero=" + hero + ", inventaire=" + inventaire + ", arme=" + arme + ", armure=" + armure
				+ ", histoire=" + histoire + ", vie=" + vie + ", attaque=" + attaque + ", defense=" + defense
				+ ", agilite=" + agilite + ", vitesse=" + vitesse + ", vieMax=" + vieMax + ", attaqueMax="
				+ attaqueMax + ", defenseMax=" + defenseMax + ", agiliteMax=" + agiliteMax + ", vitesseMax="
				+ vitesseMax + ", cptEmpoisonnement=" + cptEmpoisonnement + ", cptEtourdissement=" + cptEtourdissement
				+ ", cptSaignement=" + cptSaignement + ", cptBrulure=" + cptBrulure + ", cptCombat=" + cptCombat
				+ ", cptCombatGagne=" + cptCombatGagne + ", cptMonstreVaincu=" + cptMonstreVaincu + ", exp=" + exp
				+ "]";
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////// METHOD Pour le jeu ////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static int saisieInt(String msg) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println(msg);
		return sc.nextInt();
	}
	
	
	/*
	 * Objectif : Retablir l'ensemble des attributs aux valeurs maximums
	 * Parametre : 
	 * 
	 */
	
	public void reposTotal()
	{
		if(this.vie != this.vieMax) {
			this.vie = this.vieMax;
		}
		
		if(this.attaque != this.attaqueMax) {
			this.attaque = this.attaqueMax;
		}
		
		if(this.defense != this.defenseMax) {
			this.defense = this.defenseMax;
		}
		
		if(this.agilite != this.agiliteMax) {
			this.agilite = this.agiliteMax;
		}
		
		if(this.vitesse != this.vitesseMax) {
			this.vitesse = this.vitesseMax;
		}
		
		if(this.cptEmpoisonnement != 0) {
			this.cptEmpoisonnement = 0;
		}
		
		if(this.cptEtourdissement != 0) {
			this.cptEtourdissement = 0;
		}
		
		if(this.cptSaignement != 0) {
			this.cptSaignement = 0;
		}
		
		if(this.cptBrulure != 0) {
			this.cptBrulure = 0;
		}

	}
	
	/*
	 * Objectif : Menu permettand de choisir quels attributs restaurer
	 * Parametre : 
	 * 
	 */
	public void seReposer() {
		System.out.println("Vous comptez vous reposer!");
		System.out.println("1 - Se reposer totalement (retablir tous ses attributs aux maximums)");
		System.out.println("2 - Se reposer partiellement (uniquement la vie)");
		int choix = saisieInt("");
		switch(choix) {
		case 1:	reposTotal();
			break;
		case 2 : 
			if(this.vie != this.vieMax) {
				this.vie=this.vieMax;
			}else {
				System.out.println("Votre vie est déjà aux maximum.");
			}
			break;
		}
	}
	
	public void utiliserPotion(){
		List<InventairePotion> potionInInventaire = new ArrayList<InventairePotion>();
		potionInInventaire = this.inventaire.getInventairePotion();

		List<Potion> soin = new ArrayList<Potion>();
		
		int index;
		double dif=0;
		
		System.out.println("Vous voulez utiliser quel type de potion");
		System.out.println("1 - Soigner");
		System.out.println("2 - AttaquePlus");
		System.out.println("3 - VitessePlus");
		System.out.println("4 - DefensePlus");
		System.out.println("5 - AgilitePlus");
		System.out.println("6 - PoisonMoins");
		System.out.println("7 - BrulureMoins");
		System.out.println("8 - SaignerMoins");
		System.out.println("9 - EtourdissementMoins");
		
		int choix = saisieInt("");
		switch(choix) {
		case 1:
			
			for(InventairePotion invP :potionInInventaire) {
				if(invP.getPotion().getType().equals("Soigner")) {
					soin.add(invP.getPotion());
				}	
				if(soin.size()==0) {
					System.out.println("Vous n'avez pas de potion disponible");
				}else{
					index =0;
					for(Potion p : soin) {
						index = index+1;
						System.out.println("La potion "+index + " est " + p.toString());
					}
					choix=saisieInt("Vous voulez utiliser quel potion de cette liste ?");
					if(this.vie != this.vieMax) {
						this.vie = this.vie + soin.get(choix).getValeur();
						//remove de l'inventaire potion la potion choisie
						dif = this.vieMax-this.vie;
						if(dif>0) {
							this.vie=this.vieMax;
						}
					}
				}
			}
			
			break;
		case 2 : 
			System.out.println(""); 
			break;
		case 3:
			System.out.println("");	;
			break;
		case 4 : 
			System.out.println(""); 
			break;
		case 5:
			System.out.println("");	;
			break;
		case 6 : 
			System.out.println(""); 
			break;
		case 7:
			System.out.println("");	;
			break;
		case 8 : 
			System.out.println(""); 
			break;
		case 9 : 
			System.out.println(""); 
			break;
		}
		
		

		
	}
	

	
	
	

}
