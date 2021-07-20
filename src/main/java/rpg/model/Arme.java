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
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@Table(name="Arme")
public class Arme {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	@Column(name="nom")
	private String nom;
	@Column(name="typeArmure")
	@Enumerated(EnumType.STRING)
	private TypeArme typearme;
	@Column(name="description",length = 100)
	private String description;
	@Column(name="attaque")
	private double attaque;
	@Column(name="precision")
	private double precision;
	@Column(name="prixVente")
	private double prixVente;
	@Column(name="prixAchat")
	private double prixAchat;
	
	@OneToMany(mappedBy = "arme")
	private List<MarchandArme> marchandArmes = new ArrayList<MarchandArme>();
	@Transient
	private List<InventaireArme> inventaireArmes = new ArrayList<InventaireArme>();
	
	public Arme(Long id, int version, String nom, TypeArme typearme, String description, double attaque,
			double precision, double prixVente, double prixAchat, List<MarchandArme> marchandArmes,
			List<InventaireArme> inventaireArmes) {
		super();
		this.id = id;
		this.version = version;
		this.nom = nom;
		this.typearme = typearme;
		this.description = description;
		this.attaque = attaque;
		this.precision = precision;
		this.prixVente = prixVente;
		this.prixAchat = prixAchat;
		this.marchandArmes = marchandArmes;
		this.inventaireArmes = inventaireArmes;
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

	public TypeArme getTypearme() {
		return typearme;
	}

	public void setTypearme(TypeArme typearme) {
		this.typearme = typearme;
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

	public double getPrecision() {
		return precision;
	}

	public void setPrecision(double precision) {
		this.precision = precision;
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

	public List<MarchandArme> getMarchandArmes() {
		return marchandArmes;
	}

	public void setMarchandArmes(List<MarchandArme> marchandArmes) {
		this.marchandArmes = marchandArmes;
	}

	public List<InventaireArme> getInventaireArmes() {
		return inventaireArmes;
	}

	public void setInventaireArmes(List<InventaireArme> inventaireArmes) {
		this.inventaireArmes = inventaireArmes;
	}

	@Override
	public String toString() {
		return "Arme [id=" + id + ", version=" + version + ", nom=" + nom + ", typearme=" + typearme + ", description="
				+ description + ", attaque=" + attaque + ", precision=" + precision + ", prixVente=" + prixVente
				+ ", prixAchat=" + prixAchat + ", marchandArmes=" + marchandArmes + ", inventaireArmes="
				+ inventaireArmes + "]";
	}
	
	
	
	
	
	
	
	
}
