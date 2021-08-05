package rpg.test;

import java.util.Random;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import rpg.configuration.ApplicationConfig;
import rpg.model.Inventaire;
import rpg.model.InventairePotion;
import rpg.model.Objet;
import rpg.model.Potion;
import rpg.model.Utilisateur;
import rpg.repository.IArmeRepository;
import rpg.repository.IInventairePotionRepository;
import rpg.repository.IInventaireRepository;
import rpg.repository.IObjetRepository;
import rpg.repository.IPersonnageRepository;
import rpg.repository.IPotionRepository;
import rpg.repository.IUtilisateurRepository;



public class TestSpringConfJava {
	
	public static void insertPotionInInventaire(Potion p, Utilisateur u) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		IInventairePotionRepository inventairePotionpRepo = context.getBean(IInventairePotionRepository.class);
		
		Potion pInInventaire = inventairePotionpRepo.findPotionNameInInveantaire(p.getNom(), u.getInventaire().getId());

		if(pInInventaire==null) {
			InventairePotion ip = new InventairePotion(1,u.getInventaire(),p);
			inventairePotionpRepo.save(ip);
		}else {
			InventairePotion ip = inventairePotionpRepo.findInventairePotionByIdPotionAndIdInv(pInInventaire.getId(),u.getInventaire().getId());
			ip.setQte(ip.getQte()+1);
			inventairePotionpRepo.save(ip);
		}
		context.close();
	}
	
	public static void fouiller(Utilisateur u) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		IUtilisateurRepository utilRepo = context.getBean(IUtilisateurRepository.class);
		IInventaireRepository inventaireRepo = context.getBean(IInventaireRepository.class);
		IObjetRepository objetRepo = context.getBean(IObjetRepository.class);
		IPotionRepository potionRepo = context.getBean(IPotionRepository.class);
		
		System.out.println("Vous allez fouiller l'environnement");
		System.out.println("Vous avez cinq possibilitées : Trouver une Arme/Armure ou Trouver une Potion ou Rien Trouver ou Trouver un objet ou Etre empoisonné");
		Random rand = new Random();
		int jetDe = rand.nextInt(5); // jet de dé entre 0 et 6-1
		jetDe=3;
		switch(jetDe) {
		case 0:
			System.out.println("Vous avez rien eu ! Dommage");
			break;
		case 1 : 
			
			System.out.println("Vous recuperer un objet ici de l'or");
			Objet or = new Objet("or",100);
			Objet orInInventaire = inventaireRepo.findQteObjetForUserPseudo("toto", "or");
			double qte = or.getQte()+orInInventaire.getQte();
			orInInventaire.setQte(qte);
			objetRepo.save(orInInventaire);

			break;
		case 2:
			System.out.println("Vous recuperer une arme ou une armure");
			break;
		case 3 : 
			System.out.println("Vous recuperer une potion");
			Potion potionFouille = potionRepo.findPotionByName("Potion de fouille");
			insertPotionInInventaire(potionFouille,u);
			break;
			
		case 4:
			System.out.println("Vous etes empoisonné");
			int nbEmposonnement = 3;
			u.setCptEmpoisonnement(nbEmposonnement);
			utilRepo.save(u);
			break;
		}

		

		
		context.close();

	}


	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		IArmeRepository armeRepo = context.getBean(IArmeRepository.class);
		IUtilisateurRepository utilRepo = context.getBean(IUtilisateurRepository.class);
		IPotionRepository potionRepo = context.getBean(IPotionRepository.class);
		IInventairePotionRepository ipRepo = context.getBean(IInventairePotionRepository.class);
		IInventaireRepository iRepo = context.getBean(IInventaireRepository.class);
		IPersonnageRepository personneRepository = context.getBean(IPersonnageRepository.class);
		IObjetRepository objetRepo = context.getBean(IObjetRepository.class);
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
		fouiller(uTest);
		
//		System.out.println(uTest.getId());
//		Arme a = uTest.getArme();
//		System.out.println(a.getAttaque());
//		System.out.println(uTest.getId());
//
//		Objet qte = iRepo.findQteObjetForUserPseudo("toto", "or");
//		System.out.println(qte.getNom());
//		System.out.println(qte.getId());
//		System.out.println(qte.getDescription());
//		System.out.println(qte.getQte());

		
		
		//Monstre m = new Monstre(TypeMonstre.Dragon,10,10,10000,1,1,45,0,null,null);
		//personneRepository.save(m);
		//Hero h = new Hero(TypePersonnage.guerrier, 1, 1, 1, 1, 1, 10, 8, 100, 2, 5);
		//personneRepository.save(h);
		//Hero hF = (Hero) personneRepository.findById(h.getId()).get();
		//uTest.setHero(hF);
		//utilRepo.save(uTest);
		
		
		
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
