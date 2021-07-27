package rpg.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import rpg.configuration.ApplicationConfig;
import rpg.model.Inventaire;
import rpg.model.InventairePotion;
import rpg.model.Potion;
import rpg.model.TypePotion;
import rpg.model.Utilisateur;
import rpg.repository.IArmeRepository;
import rpg.repository.IInventairePotionRepository;
import rpg.repository.IInventaireRepository;
import rpg.repository.IPotionRepository;
import rpg.repository.IUtilisateurRepository;



public class TestSpringConfJava {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		IArmeRepository armeRepo = context.getBean(IArmeRepository.class);
		IUtilisateurRepository utilRepo = context.getBean(IUtilisateurRepository.class);
		IPotionRepository potionRepo = context.getBean(IPotionRepository.class);
		IInventairePotionRepository ipRepo = context.getBean(IInventairePotionRepository.class);
		IInventaireRepository iRepo = context.getBean(IInventaireRepository.class);
		
		//
//				Matiere html = new Matiere("HTML", 2);
		//
//				html = matiereRepo.save(html);
		
//		Potion p = new Potion();
//		p.setType(TypePotion.Soigner);
//		p.setNom("test1");
//		//p = potionRepo.save(p);
//		
//		Potion p2 = new Potion();
//		p2.setType(TypePotion.Soigner);
//		p2.setNom("test2");
//		//p2 = potionRepo.save(p2);		
//		
//		//Potion pFind = potionRepo.findById(p2.getId()).get();
//		InventairePotion ip = new InventairePotion();
//		ip.setPotion(pFind);
//		//ipRepo.save(ip);
//		
//		Utilisateur u = new Utilisateur();
//		u.setPseudo("toto");
//		//utilRepo.save(u);
//		
//		Inventaire i = new Inventaire();
//		Utilisateur uF = utilRepo.findById(u.getId()).get();
//		i.setUtilisateur(uF);
//		//iRepo.save(i);
//		
//		uF = utilRepo.findById(u.getId()).get();
//		Inventaire iF = iRepo.findById(i.getId()).get();
//		uF.setInventaire(iF);
//		//utilRepo.save(uF);
//		
//		InventairePotion ipF = ipRepo.findById(ip.getId()).get();
//		iF = iRepo.findById(i.getId()).get();
//		ipF.setInventaire(iF);
//		//ipRepo.save(ipF);
		
		Utilisateur uTest = utilRepo.findByPseudo("toto");
		System.out.println(uTest.getId());
		Inventaire iTest = iRepo.findById(uTest.getInventaire().getId()).get();
		System.out.println(iTest.getId());
		
//		List<Potion> lP = ipRepo.findAllPotionByInventaireId(iTest.getId());
//		for(Potion p : lP) {
//			System.out.println(p.getNom());
//		}
		
		List<Potion> lPS = ipRepo.findAllPotionByType(TypePotion.Soigner);
		for(Potion p : lPS) {
			System.out.println(p.getNom());
		}
		
		lPS = ipRepo.findAllPotionByTypeAndInventaireId(TypePotion.Soigner,iTest.getId());
		for(Potion p : lPS) {
			System.out.println(p.getNom());
		}
		
		
		
		
				
	
		context.close();
	}

}
