package integration.wcc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by u6030486 on 14/09/2017.
 */
public class PesistenceManager {
    private static EntityManagerFactory emf = null;

    public static EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("FilaTrello");
            return emf;
        } else
            return emf;
    }
}
