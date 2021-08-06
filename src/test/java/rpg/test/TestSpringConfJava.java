package rpg.test;

import java.util.Random;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import rpg.configuration.ApplicationConfig;
import rpg.model.Arme;
import rpg.model.Armure;
import rpg.model.InventaireArme;
import rpg.model.InventaireArmure;
import rpg.model.InventairePotion;
import rpg.model.Monstre;
import rpg.model.Objet;
import rpg.model.Potion;
import rpg.model.Utilisateur;
import rpg.repository.IArmeRepository;
import rpg.repository.IArmureRepository;
import rpg.repository.IInventaireArmeRepository;
import rpg.repository.IInventaireArmureRepository;
import rpg.repository.IInventairePotionRepository;
import rpg.repository.IInventaireRepository;
import rpg.repository.IObjetRepository;
import rpg.repository.IPersonnageRepository;
import rpg.repository.IPotionRepository;
import rpg.repository.IUtilisateurRepository;



public class TestSpringConfJava {
	public static int saisieInt(String msg) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println(msg);
		return sc.nextInt();
	}
	
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
	
	public static void insertionArmeInInventaire(Arme a, Utilisateur u) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		IInventaireArmeRepository inventaireArmeRepo = context.getBean(IInventaireArmeRepository.class);
		
		Arme armeInInventaire = inventaireArmeRepo.findArmeNameInInveantaire(a.getNom(), u.getInventaire().getId());
		if(armeInInventaire==null) {
			InventaireArme ia = new InventaireArme(1,a,u.getInventaire());
			inventaireArmeRepo.save(ia);
		}else {
			InventaireArme ia = inventaireArmeRepo.findInventaireArmeByIdArmeAndIdInv(armeInInventaire.getId(), u.getInventaire().getId());
			ia.setQuantite(ia.getQuantite()+1);
			inventaireArmeRepo.save(ia);
		}
		context.close();

	}
	
	public static void insertionArmureInInventaire(Armure a, Utilisateur u) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		IInventaireArmureRepository inventaireArmureRepo = context.getBean(IInventaireArmureRepository.class);
		
		Armure armeInInventaire = inventaireArmureRepo.findArmureNameInInveantaire(a.getNom(), u.getInventaire().getId());
		if(armeInInventaire==null) {
			InventaireArmure ia = new InventaireArmure(1,a,u.getInventaire());
			inventaireArmureRepo.save(ia);
		}else {
			InventaireArmure ia = inventaireArmureRepo.findInventaireArmureByIdArmureAndIdInv(armeInInventaire.getId(), u.getInventaire().getId());
			ia.setQte(ia.getQte()+1);
			inventaireArmureRepo.save(ia);
		}
		context.close();

	}
	
	public static void fouiller(Utilisateur user) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		IUtilisateurRepository utilRepo = context.getBean(IUtilisateurRepository.class);
		IInventaireRepository inventaireRepo = context.getBean(IInventaireRepository.class);
		IObjetRepository objetRepo = context.getBean(IObjetRepository.class);
		IPotionRepository potionRepo = context.getBean(IPotionRepository.class);
		IArmeRepository armeRepo = context.getBean(IArmeRepository.class);
		IArmureRepository armureRepo = context.getBean(IArmureRepository.class);

		
		System.out.println("Vous allez fouiller l'environnement");
		System.out.println("Vous avez six possibilitées : Trouver une Arme ou une Armure ou une Potion ou Rien ou de l'or ou Etre empoisonné");
		Random rand = new Random();
		int jetDe = rand.nextInt(6); // jet de dé entre 0 et 6-1
		jetDe=5;
		switch(jetDe) {
		case 0:
			System.out.println("Vous avez rien eu ! Dommage");
			break;
		case 1 : 
			
			System.out.println("Vous recuperer un objet ici de l'or");
			Objet or = new Objet("or",100);
			Objet orInInventaire = inventaireRepo.findQteObjetForUserPseudo(user.getPseudo(), "or");
			double qte = or.getQte()+orInInventaire.getQte();
			orInInventaire.setQte(qte);
			objetRepo.save(orInInventaire);

			break;
			
		case 2:
			System.out.println("Vous recuperer une arme");
			
			Arme armeFouille = armeRepo.findByName("Arme de fouille");
			insertionArmeInInventaire(armeFouille,user);
			
			break;
		case 3:
			System.out.println("Vous recuperer une armure");
			
			Armure armureFouille = armureRepo.findByName("Armure de fouille");
			insertionArmureInInventaire(armureFouille,user);
			
			break;
		case 4 : 
			System.out.println("Vous recuperer une potion");
			Potion potionFouille = potionRepo.findPotionByName("Potion de fouille");
			insertPotionInInventaire(potionFouille,user);
			break;
			
		case 5:
			System.out.println("Vous etes empoisonné");
			int nbEmposonnement = 3;
			user.setCptEmpoisonnement(nbEmposonnement);
			utilRepo.save(user);
			break;
		}
		context.close();
	}

	public static void combatUserVSMonstre(Utilisateur user,Monstre m) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		IUtilisateurRepository utilRepo = context.getBean(IUtilisateurRepository.class);
		IInventaireRepository inventaireRepo = context.getBean(IInventaireRepository.class);
		IObjetRepository objetRepo = context.getBean(IObjetRepository.class);
		boolean stop = true;

		while(user.getVie()>=0 && m.getVie()>=0 && stop) {
			System.out.println("Votre choix pour le combat");
			System.out.println("1 - Attaquer");
			System.out.println("2 - Utiliser une potion");
			System.out.println("3 - fuir");
			int choix = saisieInt("");
			switch (choix) {
			case 1:
				System.out.println("C'est l'heure de l'attaque");
				System.out.println("Votre vie avant l'attaque est de  "+user.getVie());
				System.out.println("La vie du monstre est de "+m.getVie());
				user.attaquer(m);
				System.out.println("La vie du monstre aprés l'attaque est  de "+m.getVie());
				m.attaquer(user);
				System.out.println("Votre vie aprés son attaque est de  "+user.getVie());


				if(user.getVie()<=0 || m.getVie()<=0) {
					utilRepo.save(user);
					stop=false;
				}
				
				break;
			case 2:
				System.out.println("C'est l'heure de la potion");
				
				break;
			case 3:
				System.out.println("Cours "+user.getPseudo()+" cours !");
				user.fuir();
				Objet orInInventaire = inventaireRepo.findQteObjetForUserPseudo(user.getPseudo(), "or");
				double qteOr = 1000;
				double qte = orInInventaire.getQte()-qteOr;
				orInInventaire.setQte(qte);
				if(orInInventaire.getQte()<0) {
					orInInventaire.setQte(0);
				}
				objetRepo.save(orInInventaire);
				utilRepo.save(user);
				stop = false;
				break;
			}
		}
		
		context.close();
	}
	public static void combatMonstreVSUser(Utilisateur user,Monstre m) {
AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		IUtilisateurRepository utilRepo = context.getBean(IUtilisateurRepository.class);
		IInventaireRepository inventaireRepo = context.getBean(IInventaireRepository.class);
		IObjetRepository objetRepo = context.getBean(IObjetRepository.class);
		
		boolean stop = true;

		while(user.getVie()>=0 && m.getVie()>=0 && stop) {
			m.attaquer(user);
			System.out.println("Votre vie aprés son attaque est de  "+user.getVie());

			System.out.println("Votre choix pour le combat");
			System.out.println("1 - Attaquer");
			System.out.println("2 - Utiliser une potion");
			System.out.println("3 - fuir");
			int choix = saisieInt("");
			switch (choix) {
			case 1:
				System.out.println("C'est l'heure de l'attaque");
				System.out.println("Votre vie avant l'attaque est de  "+user.getVie());
				System.out.println("La vie du monstre est de "+m.getVie());
				user.attaquer(m);
				System.out.println("La vie du monstre aprés l'attaque est  de "+m.getVie());

				if(user.getVie()<=0 || m.getVie()<=0) {
					utilRepo.save(user);
					stop=false;
				}
				
				break;
			case 2:
				System.out.println("C'est l'heure de la potion");
				
				break;
			case 3:
				System.out.println("Cours "+user.getPseudo()+" cours !");
				user.fuir();
				Objet orInInventaire = inventaireRepo.findQteObjetForUserPseudo(user.getPseudo(), "or");
				double qteOr = 1000;
				double qte = orInInventaire.getQte()-qteOr;
				orInInventaire.setQte(qte);
				if(orInInventaire.getQte()<0) {
					orInInventaire.setQte(0);
				}
				objetRepo.save(orInInventaire);
				utilRepo.save(user);
				stop = false;
				break;
			}
		}
		
		context.close();
		
	}
	public static void combat(Utilisateur user,Monstre m) {
		System.out.println("C'est l'heure du combat");
		System.out.println("Grâce à un lancer de pièces on determinera si c'est vous ou votre enemie qui attaque en premier");
		Random rand = new Random();
		int lancer = rand.nextInt(2);
		System.out.println(lancer);
		lancer=0;
		switch (lancer) {
		case 0:
			System.out.println("C'est à vous !");
			combatUserVSMonstre(user,m);
			break;

		case 1:
			System.out.println("Le monstre commence");
			combatMonstreVSUser(user,m);
			break;
		}
		

		
		
	}


	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		IUtilisateurRepository utilRepo = context.getBean(IUtilisateurRepository.class);
		IPersonnageRepository monstreRepo = context.getBean(IPersonnageRepository.class);

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
		Monstre mTest = (Monstre) monstreRepo.findById((long) 1).get();
		System.out.println(mTest.getNom());
		//fouiller(uTest);
		combat(uTest,mTest);
		
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
