package com.test;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
    private static SessionFactory sessionFactory;

    private HibernateUtils() {
        // Prevent instantiation from outside the class
    }

    // Method to return the SessionFactory object
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = createSessionFactory();
        }
        return sessionFactory;
    }

    private static SessionFactory createSessionFactory() {
        StandardServiceRegistry serviceRegistry = null;
        try {
            // Create StandardServiceRegistry
            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
            serviceRegistryBuilder.loadProperties("hibernate.properties");
            serviceRegistry = serviceRegistryBuilder.build();

            // Create MetadataSources
            MetadataSources metadataSources = new MetadataSources(serviceRegistry);
            metadataSources.addAnnotatedClass(Student.class);
            metadataSources.addAnnotatedClass(Laptop.class);

            // Create Metadata
            Metadata metadata = metadataSources.getMetadataBuilder().build();

            // Create SessionFactory
            return metadata.getSessionFactoryBuilder().build();

        } catch (Exception e) {
            e.printStackTrace();
            if (serviceRegistry != null) {
                StandardServiceRegistryBuilder.destroy(serviceRegistry);
            }
            throw new RuntimeException("There was an error building the sessionFactory", e);
        }
    }
}
