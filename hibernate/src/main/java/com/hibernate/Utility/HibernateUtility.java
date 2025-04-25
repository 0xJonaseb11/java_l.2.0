package com.hibernate.Utility;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            try {
                Configuration config = new Configuration().configure();
                sessionFactory=config.buildSessionFactory();
            }
            catch (Exception e)
            {
                e.getMessage();
            }

        }
        return sessionFactory;
    }
}
