package vn.iotstar.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAConfig {
	private static final EntityManagerFactory FACTORY;

    static {
        try {
            FACTORY = Persistence.createEntityManagerFactory("JPA");
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }

}
