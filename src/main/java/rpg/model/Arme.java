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
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@Table(name="Arme")
public class Arme{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	@Column(name="nom")
	private String nom;
	@Column(name="typeArme")
	@Enumerated(EnumType.STRING)
	private TypeArme typeArme;
	@Column(name="description")
	@Lob
	private String description;
	@Column(name="attaque")
	private double attaque;
	@Column(name="agilite")
	private double agilite;
	@Column(name="prixAchat")
	private double prixAchat;
	@Column(name="prixVente")
	private double prixVente;
	
	@OneToMany(mappedBy = "arme")
	private List<MarchandArme> marchandArmes = new ArrayList<MarchandArme>();
	@OneToMany(mappedBy = "arme")
	private List<InventaireArme> inventaireArme = new ArrayList<InventaireArme>();
	
	

	public Arme(Long id, int version, String nom, TypeArme typeArme, String description, double attaque, double agilite,
			double prixAchat, double prixVente, List<MarchandArme> marchandArmes, List<InventaireArme> inventaireArme) {
		super();
		this.id = id;
		this.version = version;
		this.nom = nom;
		this.typeArme = typeArme;
		this.description = description;
		this.attaque = attaque;
		this.agilite = agilite;
		this.prixAchat = prixAchat;
		this.prixVente = prixVente;
		this.marchandArmes = marchandArmes;
		this.inventaireArme = inventaireArme;
	}


	

	public Arme(String nom, TypeArme typeArme, String description, double attaque, double agilite, double prixAchat,
			double prixVente) {
		super();
		this.nom = nom;
		this.typeArme = typeArme;
		this.description = description;
		this.attaque = attaque;
		this.agilite = agilite;
		this.prixAchat = prixAchat;
		this.prixVente = prixVente;
	}




	public Arme() {
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

	public TypeArme getTypeArme() {
		return typeArme;
	}

	public void setTypeArme(TypeArme typeArme) {
		this.typeArme = typeArme;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAttaque() {
		return attaque;
	}

	public void setAttaque(double attaque) {
		this.attaque = attaque;
	}

	public double getAgilite() {
		return agilite;
	}

	public void setAgilite(double agilite) {
		this.agilite = agilite;
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

	public List<MarchandArme> getMarchandArmes() {
		return marchandArmes;
	}

	public void setMarchandArmes(List<MarchandArme> marchandArmes) {
		this.marchandArmes = marchandArmes;
	}

	public List<InventaireArme> getInventaireArme() {
		return inventaireArme;
	}

	public void setInventaireArme(List<InventaireArme> inventaireArme) {
		this.inventaireArme = inventaireArme;
	}

	@Override
	public String toString() {
		return "Arme [id=" + id + ", version=" + version + ", nom=" + nom + ", typeArme=" + typeArme + ", description="
				+ description + ", attaque=" + attaque + ", agilite=" + agilite + ", prixAchat=" + prixAchat
				+ ", prixVente=" + prixVente+"]";
	}

	


	
	
	
}