package rpg.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@Table(name="Marchand")
public class Marchand {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	@Column(name="nom")
	private String nom;
	@OneToMany(mappedBy = "marchand")
	private List<MarchandArme> armes = new ArrayList<MarchandArme>();
	@OneToMany(mappedBy = "marchand")
	private List<MarchandArmure> armures = new ArrayList<MarchandArmure>();
	@OneToMany(mappedBy = "marchand")
	private List<MarchandPotion> potions = new ArrayList<MarchandPotion>();
	
	public Marchand(Long id, int version, String nom, List<MarchandArme> armes, List<MarchandArmure> armure,
			List<MarchandPotion> potion) {
		super();
		this.id = id;
		this.version = version;
		this.nom = nom;
		this.armes = armes;
		this.armures = armure;
		this.potions = potion;
	}

	public Marchand() {
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

	public List<MarchandArme> getArmes() {
		return armes;
	}

	public void setArmes(List<MarchandArme> armes) {
		this.armes = armes;
	}

	public List<MarchandArmure> getArmure() {
		return armures;
	}

	public void setArmure(List<MarchandArmure> armure) {
		this.armures = armure;
	}

	public List<MarchandPotion> getPotion() {
		return potions;
	}

	public void setPotion(List<MarchandPotion> potion) {
		this.potions = potion;
	}

	@Override
	public String toString() {
		return "Marchand [id=" + id + ", version=" + version + ", nom=" + nom + ", armes=" + armes + ", armure="
				+ armures + ", potion=" + potions + "]";
	}

	
	
	
}
