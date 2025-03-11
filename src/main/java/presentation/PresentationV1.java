package presentation;

import dao.DaoImpl;
import metier.MetierImpl;

public class PresentationV1 {
    public static void main(String[] args) {
        /**
         * L'injection des dépendences par instantiation statique
         */
        DaoImpl d = new DaoImpl();
        MetierImpl metier = new MetierImpl();
        metier.setDao(d); // Injection via le setter
        System.out.println("RESULTAT = " + metier.calcul());
    }
}