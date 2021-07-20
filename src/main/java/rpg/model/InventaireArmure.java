package rpg.model;

import java.util.ArrayList;
import java.util.List;

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
	private List<Armure> armures = new ArrayList<Armure>();
	
	@ManyToOne
	@JoinColumn(name="inventaire_id")
	private List<Inventaire> inventaires = new ArrayList<Inventaire>();
	
	
	public InventaireArmure() {
		super();
	}

	public InventaireArmure(Long id, double qte, List<Armure> armures, List<Inventaire> inventaires) {
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

	public List<Armure> getArmures() {
		return armures;
	}

	public void setArmures(List<Armure> armures) {
		this.armures = armures;
	}

	public List<Inventaire> getInventaires() {
		return inventaires;
	}

	public void setInventaires(List<Inventaire> inventaires) {
		this.inventaires = inventaires;
	}

	@Override
	public String toString() {
		return "InventaireArmure [id=" + id + ", qte=" + qte + ", armures=" + armures + ", inventaires=" + inventaires
				+ "]";
	}
	
	
	
}
