package presentation;

import dao.DaoImpl;
import metier.MetierImpl;

public class PresentationV1 {
    public static void main(String[] args) {
        DaoImpl d = new DaoImpl();
        MetierImpl metier = new MetierImpl();
        metier.setDao(d); // Ensure the dao is set before calling calcul
        System.out.println("RESULTAT = " + metier.calcul());
    }
}