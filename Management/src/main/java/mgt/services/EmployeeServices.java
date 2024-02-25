package mgt.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import mgt.models.Employee;
import mgt.services.EmployeeServices;
import mgt.utils.HibernateUtil;

public class EmployeeServices {
	protected static SessionFactory sf = HibernateUtil.getSessionFactory();
	protected static Session session;
	public static EmployeeServices studentServices;
	public static EmployeeServices getInstance() {

		if (studentServices == null)
			return new EmployeeServices();

		return null;
	}
	private EmployeeServices() {
	}
	public void addEmployee(Employee emp) {
	    session = sf.openSession();
		//session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();

	}
	
	public List<Employee> getAllEmployee(){
		session = sf.openSession();
		Query q = session.createQuery("from Employee");
		List<Employee> employees = q.list();
		return employees;
	}
	
	
}
