package com.mindtree.coe.bugtracker.serviceimpl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import com.mindtree.coe.bugtracker.dao.Dao;
import com.mindtree.coe.bugtracker.daoimpl.DaoImpl;
import com.mindtree.coe.bugtracker.entity.Bug;
import com.mindtree.coe.bugtracker.entity.Employee;
import com.mindtree.coe.bugtracker.entity.Status;
import com.mindtree.coe.bugtracker.service.Service;

import dto.NewBug;

public class ServiceImpl implements Service {

	Dao daoImpl;

	public ServiceImpl() {
		daoImpl = new DaoImpl();
	}

	public Employee login(String userName, String userPassword) {

		MessageDigest digest;
		byte[] hashedBytes = null;
		try {
			digest = MessageDigest.getInstance("SHA-1");
			hashedBytes = digest.digest(userPassword.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		StringBuffer hashedPassword = new StringBuffer();
		for (int i = 0; i < hashedBytes.length; i++) {
			hashedPassword.append(Integer.toString((hashedBytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		return daoImpl.login(userName, hashedPassword.toString());
	}

	@Override
	public Bug submitBug(NewBug newBug) {
		Bug bug = new Bug();
		bug.setTitle(newBug.getTitle());
		bug.setDesciption(newBug.getDescription());
		bug.setSubmittedDate(new Date());
		bug.setSubmittedBy(newBug.getSubmittedBy());
		bug.setStatus(Status.pending);
		Bug submittedBug = daoImpl.submitBug(bug);
		return submittedBug;
	}

}
