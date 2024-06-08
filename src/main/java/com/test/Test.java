package com.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {

    public static void main(String[] args) {
        Session session = HibernateUtilsWithXML.getSessionFactory().openSession();
        
//        Transaction transaction = session.beginTransaction();
        
//        Laptop l1 = new Laptop();
//        l1.setCompany("Microsoft");
//        l1.setImei(1001);
        
//        Student s1 = new Student();
//        s1.setId(102);
//        s1.setName("Pranjali");
//        s1.setCity("Pune");
//        s1.setLaptop(l1);
//        l1.setStudent(s1);
        
        Laptop laptop = session.get(Laptop.class, 2);
		if (laptop != null) {
			System.out.println("Student: " + laptop.getImei() + ", " + laptop.getStudent().getName() + ", " + laptop.getCompany());
		} else {
			System.out.println("Student not found.");
		}
		session.close();
        
        
//        Student st1 = session.get(Student.class, 101);
//        Laptop l2 = st1.getLaptop();
//        System.out.println(l2);
//        session.close();
//        session.save(l1);  // Save laptop first to avoid foreign key constraint violation
//        session.save(s1);
        
//        Laptop laptop = session.get(Laptop.class, 1001); // Assuming 10001 is the laptop's imei
//        Student student = laptop.getStudent();
        
//        transaction.commit();
        session.close();
    }
}
