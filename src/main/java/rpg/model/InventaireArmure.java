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
	private Armure armures;
	
	@ManyToOne
	@JoinColumn(name="inventaire_id")
	private Inventaire inventaires;
	
	
	public InventaireArmure() {
		super();
	}


	public InventaireArmure(Long id, double qte, Armure armures, Inventaire inventaires) {
		this.id = id;
		this.qte = qte;
		this.armures = armures;
		this.inventaires = inventaires;
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


	public Armure getArmures() {
		return armures;
	}


	public void setArmures(Armure armures) {
		this.armures = armures;
	}


	public Inventaire getInventaires() {
		return inventaires;
	}


	public void setInventaires(Inventaire inventaires) {
		this.inventaires = inventaires;
	}


	@Override
	public String toString() {
		return "InventaireArmure [id=" + id + ", qte=" + qte + ", armures=" + armures + ", inventaires=" + inventaires
				+ "]";
	}

	
	
	
}
