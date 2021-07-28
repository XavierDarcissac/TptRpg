package rpg.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import rpg.configuration.ApplicationConfig;
import rpg.model.Arme;
import rpg.model.Hero;
import rpg.model.Monstre;
import rpg.model.TypeMonstre;
import rpg.model.TypePersonnage;
import rpg.model.Utilisateur;
import rpg.repository.IArmeRepository;
import rpg.repository.IInventairePotionRepository;
import rpg.repository.IInventaireRepository;
import rpg.repository.IPersonnageRepository;
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
		IPersonnageRepository personneRepository = context.getBean(IPersonnageRepository.class);
		
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
//		Arme a = new Arme("epee toto",TypeArme.lance,"",10,5,0,0);
//		armeRepo.save(a);
//		Arme aF = armeRepo.findById(a.getId()).get();
//		
		Utilisateur uTest = utilRepo.findByPseudo("toto");
		System.out.println(uTest.getId());
		Arme a = uTest.getArme();
		System.out.println(a.getAttaque());
		
		Monstre m = new Monstre(TypeMonstre.Dragon,10,10,10000,1,1,45,0,null,null);
		//personneRepository.save(m);
		Hero h = new Hero(TypePersonnage.guerrier, 1, 1, 1, 1, 1, 10, 8, 100, 2, 5);
		//personneRepository.save(h);
		//Hero hF = (Hero) personneRepository.findById(h.getId()).get();
		//uTest.setHero(hF);
		//utilRepo.save(uTest);
		double att = uTest.attaquer();
		System.out.println(att);
		
		
		
		//uTest.attaquer(m);
		//System.out.println(m.getVie());
		
//		Inventaire iTest = iRepo.findById(uTest.getInventaire().getId()).get();
//		System.out.println(iTest.getId());
//		
////		List<Potion> lP = ipRepo.findAllPotionByInventaireId(iTest.getId());
////		for(Potion p : lP) {
////			System.out.println(p.getNom());
////		}
//		
//		List<Potion> lPS = ipRepo.findAllPotionByType(TypePotion.Soigner);
//		for(Potion p : lPS) {
//			System.out.println(p.getNom());
//		}
//		
//		lPS = ipRepo.findAllPotionByTypeAndInventaireId(TypePotion.Soigner,iTest.getId());
//		for(Potion p : lPS) {
//			System.out.println(p.getNom());
//		}
		
		
		
		
				
	
		context.close();
	}

}
