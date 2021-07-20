package rpg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "InventairePotion")
public class InventairePotion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private double qte;
	@ManyToOne
	@JoinColumn(name = "inventaire_id")
	private Inventaire inventaire;
	@ManyToOne
	@JoinColumn(name = "potion_id")
	private Potion potion;
	
	
	public InventairePotion() {
		super();
	}

	public InventairePotion(Long id, double qte, Inventaire inventaire, Potion potion) {
		this.id = id;
		this.qte = qte;
		this.inventaire = inventaire;
		this.potion = potion;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getQte() {
		return qte;
	}

	public void setQte(double qte) {
		this.qte = qte;
	}

	public Inventaire getInventaire() {
		return inventaire;
	}

	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}

	public Potion getPotion() {
		return potion;
	}

	public void setPotion(Potion potion) {
		this.potion = potion;
	}
	
	
	
}
