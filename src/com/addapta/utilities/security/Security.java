package com.addapta.utilities.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import com.addapta.calendar.persistence.UserBO.UserBO;
import com.addapta.calendar.persistence.entity.User;

public class Security {
	
	
	
//esta funcion encripta la contraseña	

	public static String encrypt(String pass) {
		MessageDigest md = null;
		
		byte[] passByte = null;
		
		
		try {
			passByte = pass.getBytes("UTF-8");
			md = MessageDigest.getInstance("MD5");
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		byte[] converPass = md.digest(passByte);
				
		StringBuffer sb = new StringBuffer();
		for (final byte b : converPass) {
		    sb.append(String.format("%02x", b));
		}
		String passCifrado = sb.toString().toUpperCase();
		
		//String passCifrado = Arrays.toString(md.digest(passByte));
		
//		byte[] converPass = md.digest(passByte);  
//		
//		String passCifrado = converPass.toString();
		
		return passCifrado;
	}
	
	//funcion para comprobar que el mail tenga un formato valido. 

	public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
 }

	
	
	public static boolean userExist(String nombre) {
		boolean bOk;
		User user = new User();
		UserBO uBO = new UserBO();	
		
		user.setUsuario(nombre);
		bOk= uBO.recoveryUser(user);
		
		
		return bOk;
	}
	
	public static boolean mailExist(String mail) {
		boolean bOk;
		User user = new User();
		UserBO uBO = new UserBO();	
		
		user.setMail(mail);
		bOk= uBO.recoveryMail(user);
		
		
		return bOk;
	}
	
	
	public static boolean passComprovation(String pass, String passRepetido) {
		
		boolean bOk = false;
		
		if(!pass.trim().equals(passRepetido.trim())) {
			bOk = true;
		}
		
		
		return bOk;
	}
	
	public static boolean userValidation(String nombre,String pass) {
		boolean bOk;
		User user = new User();
		UserBO uBO = new UserBO();	
		
		user.setUsuario(nombre);
		user.setPass(pass);
		bOk= uBO.validation(user);
		
		
		return bOk;
	}
	
}
