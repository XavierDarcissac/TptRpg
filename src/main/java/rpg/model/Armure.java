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
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="Armure")
public class Armure {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	@Column(name="nom")
	private String nom;
	
	@Column(name="typeArmure")
	@Enumerated(EnumType.STRING)
	private TypeArmure typearmure;
	
	@Column(name="description")
	@Lob
	private String description;
	
	@Column(name="defense")
	private double defense;
	
	@Column(name="vitesse")
	private double vitesse;
	@Column(name="prixVente")
	private double prixVente;
	@Column(name="prixAchat")
	private double prixAchat;
	
	//@Transient
	@OneToMany(mappedBy = "armure")
	private List<MarchandArmure> marchandArmures = new ArrayList<MarchandArmure>();
	@OneToMany(mappedBy = "armure")
	private List<InventaireArmure> inventaireArmures = new ArrayList<InventaireArmure>();
	
	public Armure(Long id, int version, String nom, TypeArmure typearmure, String description, double defense,
			double vitesse, double prixVente, double prixAchat, List<MarchandArmure> marchandArmures,
			List<InventaireArmure> inventaireArmures) {
		super();
		this.id = id;
		this.version = version;
		this.nom = nom;
		this.typearmure = typearmure;
		this.description = description;
		this.defense = defense;
		this.vitesse = vitesse;
		this.prixVente = prixVente;
		this.prixAchat = prixAchat;
		this.marchandArmures = marchandArmures;
		this.inventaireArmures = inventaireArmures;
	}
	
	

	public Armure(String nom, TypeArmure typearmure, String description, double defense, double vitesse,
			double prixVente, double prixAchat) {
		super();
		this.nom = nom;
		this.typearmure = typearmure;
		this.description = description;
		this.defense = defense;
		this.vitesse = vitesse;
		this.prixVente = prixVente;
		this.prixAchat = prixAchat;
	}



	public Armure() {
		super();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public TypeArmure getTypearmure() {
		return typearmure;
	}

	public void setTypearmure(TypeArmure typearmure) {
		this.typearmure = typearmure;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getDefense() {
		return defense;
	}

	public void setDefense(double defense) {
		this.defense = defense;
	}

	public double getVitesse() {
		return vitesse;
	}

	public void setVitesse(double vitesse) {
		this.vitesse = vitesse;
	}

	public double getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(double prixVente) {
		this.prixVente = prixVente;
	}

	public double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}

	public List<MarchandArmure> getMarchandArmures() {
		return marchandArmures;
	}

	public void setMarchandArmures(List<MarchandArmure> marchandArmures) {
		this.marchandArmures = marchandArmures;
	}

	public List<InventaireArmure> getInventaireArmures() {
		return inventaireArmures;
	}

	public void setInventaireArmures(List<InventaireArmure> inventaireArmures) {
		this.inventaireArmures = inventaireArmures;
	}

	@Override
	public String toString() {
		return "Armure [id=" + id + ", version=" + version + ", nom=" + nom + ", typearmure=" + typearmure
				+ ", description=" + description + ", defense=" + defense + ", vitesse=" + vitesse + ", prixVente="
				+ prixVente + ", prixAchat=" + prixAchat + ", marchandArmures=" + marchandArmures
				+ ", inventaireArmures=" + inventaireArmures + "]";
	}

	
	
	

	
	


	




}
