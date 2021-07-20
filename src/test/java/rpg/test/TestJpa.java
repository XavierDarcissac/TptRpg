package rpg.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import rpg.config.ApplicationConfig;

public class TestJpa {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		context.close();
	}
}
