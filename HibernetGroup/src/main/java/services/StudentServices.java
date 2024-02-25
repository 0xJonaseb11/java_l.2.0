package services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import models.Student;
import util.HibernateUtil;


public class StudentServices {
	protected static SessionFactory sf = HibernateUtil.getSessionFactory();
	protected static Session session;
	public static StudentServices studentServices;
	public static StudentServices getInstance() {

		if (studentServices == null)
			return new StudentServices();

		return null;
	}
	private StudentServices() {
	}
	public void addStudent(Student student) {
	    session = sf.openSession();
		//session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();

	}
}
