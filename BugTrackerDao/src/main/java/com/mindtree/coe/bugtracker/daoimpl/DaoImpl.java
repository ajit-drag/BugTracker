package com.mindtree.coe.bugtracker.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mindtree.coe.bugtracker.dao.Dao;
import com.mindtree.coe.bugtracker.entity.Bug;
import com.mindtree.coe.bugtracker.entity.Employee;

public class DaoImpl extends GenericDao implements Dao {

	public Employee login(String userName, String userPassword) {
		Session session = getFactory().openSession();
		Query query = session.createQuery("from Employee e where e.name=:name and e.password=:password");
		query.setParameter("name", userName);
		query.setParameter("password", userPassword);
		List<Employee> employeeList = query.list();
		session.close();
		if (employeeList.size() != 1) {
			return null;
		} else {
			return employeeList.get(0);
		}
	}

	public Bug submitBug(Bug bug) {
		Session session = getFactory().openSession();
		Transaction tx = session.beginTransaction();
		long bugId =(Long) session.save(bug);
		tx.commit();
		tx = session.beginTransaction() ;
		Bug submittedBug = session.get(Bug.class, bugId);
		tx.commit();
		session.close();
		return submittedBug;
	}

	public List<Bug> getAllBugs() {
		Session session = getFactory().openSession();
		Query query = session.createQuery("from Bug");
		List<Bug> allBugList = query.list();
		session.close();
		return allBugList;
	}

	public List<Employee> getAllSupportList() {
		Session session = getFactory().openSession();
		Query query = session.createQuery("from Employee e where e.role='support'");
		List<Employee> employeeList = query.list();
		session.close();
		return employeeList;
	}

	public Bug getBug(long bugId) {
		Session session = getFactory().openSession();
		Bug submittedBug = session.get(Bug.class, bugId);
		session.close();
		return submittedBug;
	}

	public Employee getSupportEmployee(long supportEmployeeId) {
		Session session = getFactory().openSession();
		Employee employee = session.get(Employee.class, supportEmployeeId);
		session.close();
		return employee;
	}

	public int assignBugs(List<Bug> assignedBugList) {
		int bugsAssigned=0;
		for(Bug bug : assignedBugList){
			Session session = getFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.update(bug);
			++bugsAssigned;
			tx.commit();
			session.close();
		}
		return bugsAssigned;
	}
	

}
