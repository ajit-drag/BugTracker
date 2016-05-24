package com.mindtree.coe.bugtracker.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.mindtree.coe.bugtracker.entity.Employee;
import com.mindtree.coe.bugtracker.service.Service;
import com.mindtree.coe.bugtracker.serviceimpl.ServiceImpl;


public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	Service service = new ServiceImpl();
	Employee employee= null;
	
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		final String name = authentication.getName();
		final String password = authentication.getCredentials().toString();
		String userRole = authenticateUser(name, password);
		if(userRole!=null){
			final List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
			grantedAuthorityList.add(new SimpleGrantedAuthority(userRole));
			final UserDetails principal = new User(String.valueOf(employee.getId()), password, grantedAuthorityList);
			final Authentication authentication2 = new UsernamePasswordAuthenticationToken(employee, password,grantedAuthorityList);
			return authentication2;
		}
		else{
			return null;
		}
	}

	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	public String giveHash(String string,String strategy){
		MessageDigest digest;
		byte[] hashedBytes = null;
		try {
			digest = MessageDigest.getInstance(strategy/*"SHA-1"*/);
			hashedBytes = digest.digest(string.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		StringBuffer hashedPassword = new StringBuffer();
		for (int i = 0; i < hashedBytes.length; i++) {
			hashedPassword.append(Integer.toString((hashedBytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		return hashedPassword.toString();
	}
	
	public String authenticateUser(String userName,String userPassword){
		employee = service.login(userName, userPassword);
		return employee.getRole();
		
		/*if(userName.equalsIgnoreCase("ajit")&& giveHash(userPassword, "SHA-1").equals("8a220a37a4a3f11ce03af22a81879ba01e62683c")){
			return "ROLE_USER";
		}else{		
		return null;
		}*/
	}
}
