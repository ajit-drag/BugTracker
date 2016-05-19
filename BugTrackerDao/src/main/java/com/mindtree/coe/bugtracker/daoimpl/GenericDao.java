package com.mindtree.coe.bugtracker.daoimpl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GenericDao {
	SessionFactory factory;
	public GenericDao() {
		factory = new Configuration().configure().buildSessionFactory();
	}
	SessionFactory getFactory(){
		return  factory;	
	}

}
