package com.ty.crud;

public class TEstAES {

	public static void main(String[] args) {
		final String secretKey = "demokey";

		String originalString = "howtodoinjava.com";
		String encryptedString = AES.encrypt(originalString, secretKey) ;
		String decryptedString = AES.decrypt(encryptedString, secretKey) ;

		System.out.println(originalString);
		System.out.println(encryptedString);
		System.out.println(decryptedString);
	}

}
