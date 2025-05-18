package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier{
    //Couplage faible
    private IDao dao;

    public MetierImpl() {}

    @Autowired
    public MetierImpl(@Qualifier("daoV2") IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double t = dao.getData();
        double res = t * 23;
        return res;
    }

    @Autowired
    @Qualifier("dao")
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
