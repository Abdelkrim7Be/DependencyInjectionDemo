package presentation;

import config.AppConfig;
import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresAvecSpringAnnotations {
    public static void main(String[] args) {
        // Create Spring context using annotation configuration
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        // Retrieve metier bean from the context
        IMetier metier = context.getBean(IMetier.class);
        
        // Execute business logic and display the result
        System.out.println("RESULT (Annotations) : " + metier.calcul());
    }
}
