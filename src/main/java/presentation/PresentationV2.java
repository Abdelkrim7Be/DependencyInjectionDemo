package presentation;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PresentationV2 {
    public static void main(String[] args) {
        //L'instantiation dynamique
        try {
            Scanner scanner = new Scanner(new File("config.txt"));
            //DaoImplV2 d = new DaoImplV2();        DaoImplV2 d = new DaoImplV2();
            String daoClassName = scanner.nextLine();
            Class cDao = Class.forName(daoClassName);
            IDao dao  = (IDao) cDao.getConstructor().newInstance();

            //MetierImpl metier = new MetierImpl(d);
            String metierClassName = scanner.nextLine();
            Class cMetier = Class.forName(metierClassName);
            IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);

            System.out.println("RESULTAT = " + metier.calcul());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
