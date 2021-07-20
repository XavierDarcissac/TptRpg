package rpg.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Inventaire")
public class Inventaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "objet_id")
	private Objet objet;	
	
	@OneToOne
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateur;
	
	@OneToMany(mappedBy = "inventaire")
	private List<InventairePotion> inventairePotion = new ArrayList<InventairePotion>();
	
	@OneToMany(mappedBy = "inventaire")
	private List<InventaireArme> inventaireArme = new ArrayList<InventaireArme>();
	
	@OneToMany(mappedBy = "inventaire")
	private List<InventaireArmure> inventaireArmure = new ArrayList<InventaireArmure>();

	
	public Inventaire() {
		super();
	}

	public Inventaire(Objet objet, Utilisateur utilisateur, List<InventairePotion> inventairePotion,
			List<InventaireArme> inventaireArme, List<InventaireArmure> inventaireArmure) {
		this.objet = objet;
		this.utilisateur = utilisateur;
		this.inventairePotion = inventairePotion;
		this.inventaireArme = inventaireArme;
		this.inventaireArmure = inventaireArmure;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Objet getObjet() {
		return objet;
	}

	public void setObjet(Objet objet) {
		this.objet = objet;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public List<InventairePotion> getInventairePotions() {
		return inventairePotions;
	}


	public void setInventairePotions(List<InventairePotion> inventairePotions) {
		this.inventairePotions = inventairePotions;
	}


	public List<InventaireArme> getInventaireArmes() {
		return inventaireArmes;
	}


	public void setInventaireArmes(List<InventaireArme> inventaireArmes) {
		this.inventaireArmes = inventaireArmes;
	}


	public List<InventaireArmure> getInventaireArmures() {
		return inventaireArmures;
	}


	public void setInventaireArmures(List<InventaireArmure> inventaireArmures) {
		this.inventaireArmures = inventaireArmures;
	}


	@Override
	public String toString() {
		return "Inventaire [id=" + id + ", objet=" + objet + ", utilisateur=" + utilisateur + ", inventairePotions="
				+ inventairePotions + ", inventaireArmes=" + inventaireArmes + ", inventaireArmures="
				+ inventaireArmures + "]";
	}

	
	
	
	
	
}
