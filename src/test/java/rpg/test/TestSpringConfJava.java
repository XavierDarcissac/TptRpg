package rpg.test;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import rpg.configuration.ApplicationConfig;
import rpg.model.Arme;
import rpg.model.Armure;
import rpg.model.Hero;
import rpg.model.Inventaire;
import rpg.model.InventaireArme;
import rpg.model.InventaireArmure;
import rpg.model.InventairePotion;
import rpg.model.Monstre;
import rpg.model.Objet;
import rpg.model.Potion;
import rpg.model.TypeArme;
import rpg.model.TypeArmure;
import rpg.model.TypeMonstre;
import rpg.model.TypePersonnage;
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
	
	public static double saisieDouble(String msg) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println(msg);
		return sc.nextDouble();
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
	
	public static void changerEquipement(Utilisateur user) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		IInventaireArmeRepository inventaireArmeRepository = context.getBean(IInventaireArmeRepository.class);
		IInventaireArmureRepository inventaireArmureRepository = context.getBean(IInventaireArmureRepository.class);

		IUtilisateurRepository utilRepo = context.getBean(IUtilisateurRepository.class);

		System.out.println("Que voulez vous changer ?");
		System.out.println("1 - Arme");
		System.out.println("2 - Armure");
		System.out.println("3 - Arme et Armure");
		Armure armureActive = user.getArmure();
		Arme armeActive = user.getArme();
		List<Arme> listeArme = inventaireArmeRepository.findAllArmeByInventaireId(user.getInventaire().getId());
		List<Armure> listeArmure = inventaireArmureRepository.findAllArmureByInventaireId(user.getInventaire().getId());

		int choix = saisieInt("");
		switch (choix) {
		case 1:
			if(armeActive==null) {
				System.out.println("Vous n'avez pas d'arme");
				System.out.println();
			}else {
				System.out.println("Votre arme actuelle est : ");
				System.out.println(armeActive.toString());
				System.out.println();
			}
			
			if(listeArme.isEmpty()) {
				System.out.println("Vous n'avez aucune arme en votre possession ! il faut aller voir un marchand");
				//lien marchand
			}else {
				int i=0;
				for(Arme a : listeArme) {
					System.out.println("Numéro Arme "+i);
					System.out.println(a.toString());
					System.out.println();
					i=i+1;
				}
				int choixEquipement=saisieInt("Quelle Arme voulez vous ? saisir le numéro de l'arme");
				System.out.println("Votre choix est : " + listeArme.get(choixEquipement));
				user.setArme(listeArme.get(choixEquipement));
				utilRepo.save(user);
			}
			

			break;
		case 2:
			if(armureActive==null) {
				System.out.println("Vous n'avez pas d'armure");
				System.out.println();
			}else {
				System.out.println("Votre armure actuelle est : ");
				System.out.println(armureActive.toString());
				System.out.println();
			}
			
			if(listeArmure.isEmpty()) {
				System.out.println("Vous n'avez aucune armure en votre possession ! il faut aller voir un marchand");
				//lien marchand
			}else {
				int i=0;
				for(Armure a : listeArmure) {
					System.out.println("Numéro Armure "+i);
					System.out.println(a.toString());
					System.out.println();
					i=i+1;
				}
				int choixEquipement=saisieInt("Quelle Arme voulez vous ? saisir le numéro de l'arme");
				System.out.println("Votre choix est : " + listeArmure.get(choixEquipement));
				user.setArmure(listeArmure.get(choixEquipement));
				utilRepo.save(user);
			}
			break;
		case 3:
			if(armeActive==null) {
				System.out.println("Vous n'avez pas d'arme");
				System.out.println();
			}else {
				System.out.println("Votre arme actuelle est : ");
				System.out.println(armeActive.toString());
				System.out.println();
			}
			
			if(listeArme.isEmpty()) {
				System.out.println("Vous n'avez aucune arme en votre possession ! il faut aller voir un marchand");
				//lien marchand
			}else {
				int i=0;
				for(Arme a : listeArme) {
					System.out.println("Numéro Arme "+i);
					System.out.println(a.toString());
					System.out.println();
					i=i+1;
				}
				int choixEquipement=saisieInt("Quelle Arme voulez vous ? saisir le numéro de l'arme");
				System.out.println("Votre choix est : " + listeArme.get(choixEquipement));
				user.setArme(listeArme.get(choixEquipement));
			}
			if(armureActive==null) {
				System.out.println("Vous n'avez pas d'armure");
				System.out.println();
			}else {
				System.out.println("Votre armure actuelle est : ");
				System.out.println(armureActive.toString());
				System.out.println();
			}
			
			if(listeArmure.isEmpty()) {
				System.out.println("Vous n'avez aucune armure en votre possession ! il faut aller voir un marchand");
				//lien marchand
			}else {
				int i=0;
				for(Armure a : listeArmure) {
					System.out.println("Numéro Armure "+i);
					System.out.println(a.toString());
					System.out.println();
					i=i+1;
				}
				int choixEquipement=saisieInt("Quelle Arme voulez vous ? saisir le numéro de l'arme");
				System.out.println("Votre choix est : " + listeArmure.get(choixEquipement));
				user.setArmure(listeArmure.get(choixEquipement));
				utilRepo.save(user);
			}
			break;
		}
		
		
		context.close();
	}
	
	public static String saisieString(String msg) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println(msg);
		return sc.nextLine();
	}
	
	public static void createUser() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		IUtilisateurRepository utilRepo = context.getBean(IUtilisateurRepository.class);
		IInventaireRepository inventaireRepo = context.getBean(IInventaireRepository.class);
		
		String mail = saisieString("Saisir votre mail  ");
		String mdp = saisieString("Saisir votre mot de passe");
		String pseudo = saisieString("Saisir votre pseudo");
		Utilisateur u = new Utilisateur(pseudo,mail,mdp);
		utilRepo.save(u);
		context.close();
	}
	
	public static void modifUserInfo(String mail,String mdp) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		IUtilisateurRepository utilRepo = context.getBean(IUtilisateurRepository.class);
		
		Utilisateur u = utilRepo.findUserByMailAndMdp(mail,mdp);
		String newPseudo;
		String newMdp;
		String newMail;
		
		System.out.println("Quelle modification faire ?");
		System.out.println("1 - Changer pseudo");
		System.out.println("2 - Changer de mot de passe");
		System.out.println("3 - Changer de mail");
		System.out.println("4 - Changer toutes les infos");
		int choix = saisieInt("");
		switch (choix) {
		case 1:
			 newPseudo = saisieString("Saisir le nouveau pseudo");
			u.setPseudo(newPseudo);
			break;
		case 2:
			newMdp = saisieString("Saisir nouveau mot de passe");
			u.setMdp(newMdp);
			break;
		case 3:
			 newMail = saisieString("Saisir nouveau mail");
			u.setMail(newMail);
			break;
		case 4:
			newPseudo = saisieString("Saisir le nouveau pseudo");
			u.setPseudo(newPseudo);
			newMdp = saisieString("Saisir nouveau mot de passe");
			u.setMdp(newMdp);
			newMail = saisieString("Saisir nouveau mail");
			u.setMail(newMail);
			break;

		default:
			break;
		}
		utilRepo.save(u);
		context.close();
	}

	public static void addHeroForUser(Utilisateur user) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		IPersonnageRepository heroRepo = context.getBean(IPersonnageRepository.class);
		IUtilisateurRepository utilRepo = context.getBean(IUtilisateurRepository.class);
		IArmeRepository armeRepo = context.getBean(IArmeRepository.class);
		IArmureRepository armureRepo = context.getBean(IArmureRepository.class);
		IInventaireRepository inventaireRepo = context.getBean(IInventaireRepository.class);
		IInventaireArmeRepository inventaireArmeRepo = context.getBean(IInventaireArmeRepository.class);
		IInventaireArmureRepository inventaireArmureRepo = context.getBean(IInventaireArmureRepository.class);

		
		List<Hero> listeHero =  heroRepo.findAllHero();
		int i=0;
		for(Hero h : listeHero) {
			System.out.println("Hero numero " + i);
			System.out.println(h.toString());
			i = i+1;
		}
		int choix = saisieInt("Votre choix de hero (numero hero)");
		Hero h = listeHero.get(choix);
		user.setHero(h);
		user.setVie(h.getVie());
		user.setVieMax(h.getVie());
		user.setAttaque(h.getAttaque());
		user.setAttaqueMax(h.getAttaque());
		user.setDefense(h.getDefense());
		user.setDefenseMax(h.getDefense());
		user.setVitesse(h.getVitesse());
		user.setVitesseMax(h.getVitesse());
		user.setPrecision(h.getPrecision());
		user.setPrecisionMax(h.getPrecision());
		
		Arme arme = armeRepo.findByName("Arme default");
		Armure armure = armureRepo.findByName("Armure default");
		
		user.setArme(arme);
		user.setArmure(armure);
		
		Inventaire inventaire = new Inventaire();
		inventaireRepo.save(inventaire);
		
		inventaire= inventaireRepo.findById(inventaire.getId()).get();
		
		user.setInventaire(inventaire);
		inventaire.setUtilisateur(user);
		inventaireRepo.save(inventaire);
		
		InventaireArme invArme = new InventaireArme();
		invArme.setArme(arme);
		invArme.setQuantite(1);
		invArme.setInventaire(inventaire);
		
		inventaireArmeRepo.save(invArme);
		
		InventaireArmure invArmure = new InventaireArmure();
		invArmure.setArmure(armure);
		invArmure.setInventaire(inventaire);
		invArmure.setQte(1);
		
		inventaireArmureRepo.save(invArmure);
		
		utilRepo.save(user);
		context.close();
	}

	public static void addHero() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		IPersonnageRepository persoRepo = context.getBean(IPersonnageRepository.class);

		Hero h = new Hero();
		
		String nom = saisieString("nom hero");
		h.setNom(nom);
		for (TypePersonnage myVar : TypePersonnage.values()) {
			  System.out.println("type Hero : "+myVar); 
			}
		String type = saisieString("Saisir le type de l'hero");
		TypePersonnage typePerso = TypePersonnage.valueOf(type);
		h.setTypePersonnage(typePerso);
		
		double info = saisieDouble("Attaque");
		h.setAttaque(info);
		info = saisieDouble("Defense");
		h.setDefense(info);
		info = saisieDouble("Vie");
		h.setVie(info);
		info = saisieDouble("agilite/precision");
		h.setPrecision(info);
		info = saisieDouble("Vitesse");
		h.setVitesse(info);
		
		info = saisieDouble("Coef attaque");
		h.setCoefAttaque(info);
		info = saisieDouble("Coef defense");
		h.setCoefDefense(info);
		info = saisieDouble("Coef vie");
		h.setCoefVie(info);
		info = saisieDouble("Coef presision/agilite");
		h.setCoefPrecision(info);
		info = saisieDouble("Coef vitesse");
		h.setCoefVitesse(info);
	
		persoRepo.save(h);
		context.close();
	}
	
	public static void addMonstre() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		IPersonnageRepository persoRepo = context.getBean(IPersonnageRepository.class);
		IArmeRepository armeRepo = context.getBean(IArmeRepository.class);
		IArmureRepository armureRepo = context.getBean(IArmureRepository.class);
		
		Monstre m = new Monstre();
		
		String nom = saisieString("nom Monstre");
		m.setNom(nom);
		for (TypePersonnage myVar : TypePersonnage.values()) {
			  System.out.println("type Hero : "+myVar); 
			}
		String type = saisieString("Saisir le type de l'hero");
		TypeMonstre typePerso = TypeMonstre.valueOf(type);
		m.setTypeMonstre(typePerso);
		
		double info = saisieDouble("Attaque");
		m.setAttaque(info);
		info = saisieDouble("Defense");
		m.setDefense(info);
		info = saisieDouble("Vie");
		m.setVie(info);
		info = saisieDouble("agilite/precision");
		m.setPrecision(info);
		info = saisieDouble("Vitesse");
		m.setVitesse(info);
		
		int infoInt = saisieInt("Gold");
		m.setGold(infoInt);
		infoInt=saisieInt("exp monstre");
		m.setExp(infoInt);
		
		List<Arme> listeArme = armeRepo.findAll();
		List<Armure> listeArmure = armureRepo.findAll();

		int i=0;
		for(Arme a : listeArme) {
			System.out.println("Numéro Arme "+i);
			System.out.println(a.toString());
			System.out.println();
			i=i+1;
		}
		int choixEquipement=saisieInt("Quelle Arme voulez vous ? saisir le numéro de l'arme");
		m.setArme(listeArme.get(choixEquipement));
		
		i=0;
		for(Armure a : listeArmure) {
			System.out.println("Numéro Armure "+i);
			System.out.println(a.toString());
			System.out.println();
			i=i+1;
		}
		choixEquipement=saisieInt("Quelle Arme voulez vous ? saisir le numéro de l'arme");
		m.setArmure(listeArmure.get(choixEquipement));
		
		persoRepo.save(m);
		context.close();
	}
	
	public static void ajoutArmure() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		IArmureRepository armureRepo = context.getBean(IArmureRepository.class);

		Armure a = new Armure();

		String nom = saisieString("nom armure");
		a.setNom(nom);
		String description = saisieString("Description armure");
		a.setDescription(description);
	
		for (TypeArmure myVar : TypeArmure.values()) {
			  System.out.println("type armure : "+myVar); 
			}
		String typeArmure = saisieString("Saisir le type de l'armure");
		TypeArmure type = TypeArmure.valueOf(typeArmure);
		
		a.setTypearmure(type);
		
		double def = saisieDouble("Puissance defense");
		a.setDefense(def);
		double vitesse = saisieDouble("vitesse armure");
		a.setVitesse(vitesse);
		double prixAchat = saisieDouble("Prix achat");
		a.setPrixAchat(prixAchat);
		double prixVente = saisieDouble("Prix vente");
		a.setPrixVente(prixVente);
		
		armureRepo.save(a);
		context.close();
	}
	
	public static void ajoutArme() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		IArmeRepository armeRepo = context.getBean(IArmeRepository.class);
		Arme a = new Arme();
		
		String nom = saisieString("nom arme");
		a.setNom(nom);
		String description = saisieString("Description arme");
		a.setDescription(description);
	
		for (TypeArme myVar : TypeArme.values()) {
			  System.out.println("type arme : "+myVar); 
			}
		String typeArme = saisieString("Saisir le type de l'arme");
		TypeArme type = TypeArme.valueOf(typeArme);
		
		a.setTypeArme(type);
		
		double att = saisieDouble("Puissance attaque");
		a.setAttaque(att);
		double precision = saisieDouble("Agilite/Presision arme");
		a.setAgilite(precision);
		double prixAchat = saisieDouble("Prix achat");
		a.setPrixAchat(prixAchat);
		double prixVente = saisieDouble("Prix vente");
		a.setPrixVente(prixVente);
		
		armeRepo.save(a);
		context.close();
	}
	
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		IUtilisateurRepository utilRepo = context.getBean(IUtilisateurRepository.class);
		IPersonnageRepository monstreRepo = context.getBean(IPersonnageRepository.class);
		
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
		
	
	
	
/////////////////////////////////////////////////////////	
/////////////////////// TEST ALGO ///////////////////////
/////////////////////////////////////////////////////////
	
		//createUser();	
		Utilisateur uTest = utilRepo.findByPseudo("pseudo1");
		//addHeroForUser(uTest);
		//ajoutArme();
		ajoutArmure();
		Monstre mTest = (Monstre) monstreRepo.findById((long) 1).get();
		//fouiller(uTest);
		//combat(uTest,mTest);
		//changerEquipement(uTest);
		
		
/////////////////////////////////////////////////////////	
/////////////////////////////////////////////////////////
		

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
