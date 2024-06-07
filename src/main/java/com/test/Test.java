package com.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {

    public static void main(String[] args) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        
        Transaction transaction = session.beginTransaction();
        
        Laptop l1 = new Laptop();
        l1.setCompany("Apple");
        l1.setImei(10001);
        
        Student s1 = new Student();
        s1.setId(101);
        s1.setName("Pranjali");
        s1.setCity("Pune");
//        s1.setLaptop(l1);
        l1.setStudent(s1);
        
        session.save(s1);
        session.save(l1);  // Save laptop first to avoid foreign key constraint violation
        
        transaction.commit();
        session.close();
    }
}
