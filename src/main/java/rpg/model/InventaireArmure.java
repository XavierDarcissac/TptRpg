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
@Table(name="InventaireArmure")
public class InventaireArmure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private double qte;
	
	@ManyToOne
	@JoinColumn(name="armure_id")
	private Armure armure;
	
	@ManyToOne
	@JoinColumn(name="inventaire_id")
	private Inventaire inventaire;
	
	
	public InventaireArmure() {
		super();
	}


	public InventaireArmure(Long id, double qte, Armure armures, Inventaire inventaires) {
		this.id = id;
		this.qte = qte;
		this.armure = armures;
		this.inventaire = inventaires;
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


	public Armure getArmure() {
		return armure;
	}


	public void setArmure(Armure armures) {
		this.armure = armures;
	}


	public Inventaire getInventaire() {
		return inventaire;
	}


	public void setInventaire(Inventaire inventaires) {
		this.inventaire = inventaires;
	}


	@Override
	public String toString() {
		return "InventaireArmure [id=" + id + ", qte=" + qte + ", armures=" + armure + ", inventaires=" + inventaire
				+ "]";
	}

	
	
	
}
