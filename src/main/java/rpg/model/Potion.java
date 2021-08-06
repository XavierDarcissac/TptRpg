package rpg.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Potion")
public class Potion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nom;
	@Column
	@Enumerated(EnumType.STRING)
	private TypePotion type;
	@Column
	private double valeur;
	@Column
	private double prixAchat;
	@Column
	private double prixVente;
	@OneToMany(mappedBy = "potion")
	private List<InventairePotion> inventairePotions = new ArrayList<InventairePotion>();
	@OneToMany(mappedBy = "potion")
	private List<MarchandPotion> marchandPotions = new ArrayList<MarchandPotion>();
	
	public Potion() {
		super();
	}

	
	public Potion(Long id, String nom, TypePotion type, double valeur, double prixAchat, double prixVente,
			List<InventairePotion> inventairePotions, List<MarchandPotion> marchandPotions) {
		this.id = id;
		this.nom = nom;
		this.type = type;
		this.valeur = valeur;
		this.prixAchat = prixAchat;
		this.prixVente = prixVente;
		this.inventairePotions = inventairePotions;
		this.marchandPotions = marchandPotions;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public TypePotion getType() {
		return type;
	}

	public void setType(TypePotion type) {
		this.type = type;
	}

	public double getValeur() {
		return valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}

	public double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}

	public double getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(double prixVente) {
		this.prixVente = prixVente;
	}


	public List<InventairePotion> getInventairePotions() {
		return inventairePotions;
	}


	public void setInventairePotions(List<InventairePotion> inventairePotions) {
		this.inventairePotions = inventairePotions;
	}


	public List<MarchandPotion> getMarchandPotions() {
		return marchandPotions;
	}


	public void setMarchandPotions(List<MarchandPotion> marchandPotions) {
		this.marchandPotions = marchandPotions;
	}


	@Override
	public String toString() {
		return "Potion [id=" + id + ", nom=" + nom + ", type=" + type + ", valeur=" + valeur + ", prixAchat="
				+ prixAchat + ", prixVente=" + prixVente + "]";
	}

	
	
	
	
	
}
