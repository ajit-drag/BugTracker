package com.mindtree.coe.bugtracker.daoimpl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GenericDao {
	
	SessionFactory getFactory(){
		return  new Configuration().configure().buildSessionFactory();	
	}

}
