package rpg.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import rpg.configuration.ApplicationConfig;
import rpg.model.Arme;
import rpg.model.TypeArme;
import rpg.repository.IArmeRepository;



public class TestSpringConfJava {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		IArmeRepository armeRepo = context.getBean(IArmeRepository.class);
		//
//				Matiere html = new Matiere("HTML", 2);
		//
//				html = matiereRepo.save(html);

				Arme arme1 = new Arme( "arme",TypeArme.epee, "c est une arme test",10,1,50,40);
				System.out.println(arme1);
				arme1 = armeRepo.save(arme1);
				
	
		context.close();
	}

}
