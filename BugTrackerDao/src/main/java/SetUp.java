import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mindtree.coe.bugtracker.daoimpl.DaoImpl;
import com.mindtree.coe.bugtracker.entity.Employee;



public class SetUp {

	public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		/*SessionFactory factory =  new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		String userName = "pqr";
		String userPasssword = "pqr"; 
		MessageDigest digest = MessageDigest.getInstance("SHA-1");
		byte[] hashedBytes = digest.digest(userPasssword.getBytes("UTF-8"));
		StringBuffer hashedPassword = new StringBuffer();
        for (int i = 0; i < hashedBytes.length; i++) {
            hashedPassword.append(Integer.toString((hashedBytes[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
		
        session.save(new Employee(userName, "support", hashedPassword.toString()));
        
        userName = "xyz";
		userPasssword = "xyz"; 
		digest = MessageDigest.getInstance("SHA-1");
		hashedBytes = digest.digest(userPasssword.getBytes("UTF-8"));
		hashedPassword = new StringBuffer();
        for (int i = 0; i < hashedBytes.length; i++) {
            hashedPassword.append(Integer.toString((hashedBytes[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
        session.save(new Employee(userName, "support", hashedPassword.toString()));
        
		tx.commit();
		factory.close();*/
		
		DaoImpl daoImpl = new DaoImpl();
		System.out.println(daoImpl.login("ajit", "8a220a37a4a3f11ce03af22a81879ba01e62683c").getRole());

		

	}

}
