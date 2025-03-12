package presentation;

import dao.DaoImpl;
import ext.DaoImplV2;
import metier.MetierImpl;

public class PresentationV1 {
    public static void main(String[] args) {
        /**
         * L'injection des dépendences par instantiation statique
         */
        DaoImplV2 dao = new DaoImplV2();
        MetierImpl metier = new MetierImpl(dao); // Injection des dépendances via le constructeur
        System.out.println("RESULTAT = " + metier.calcul());
    }
}