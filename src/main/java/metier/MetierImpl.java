package metier;

import dao.DaoImpl;
import dao.IDao;

public class MetierImpl implements IMetier{
    //Couplage faible
    //private IDao dao = new DaoImpl();
    private IDao dao;

    /**
     * (1èere solution) Pour injecter dans la vqriqble dao un objet d'une classe
     * qui implémente l'interface IDao
     */
    public void setDao(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double t = dao.getData();
        double res = t * 23;
        return res;
    }


}
