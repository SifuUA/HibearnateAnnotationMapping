package bl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Created by Alex on 30.06.2017.
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            return configuration.buildSessionFactory();
        }catch (Throwable e){
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }


    public static void shutdown() {
        sessionFactory.close();
    }
}
