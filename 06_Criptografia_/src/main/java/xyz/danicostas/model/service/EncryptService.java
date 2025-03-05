	package xyz.danicostas.model.service;
	
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
	
	import xyz.danicostas.model.persistence.EncryptRepository;
	
	@org.springframework.stereotype.Service
	public class EncryptService {
	
		@Autowired
		private EncryptRepository repository;
		
		// SYMMETRICAL KEY ENCRYPTION ->
		
		KeyGenerator keyGenerator;
		SecretKey secretKey;
		Cipher encrypter;
		Cipher decrypter;
		
		// ASYMMETRICAL KEY ENCRYPTION ->
		
		KeyPairGenerator keyPairGenerator;
		KeyPair keypair;
		PublicKey publicKey;
		PrivateKey privateKey;
		Cipher authorship;
		Cipher authorshipVerifier;
		Cipher encryptConfidential;
		Cipher decryptConfidential;
		
		public EncryptService() {
			try {
				// SYMMETRICAL KEY ENCRYPTION ->
				keyGenerator = KeyGenerator.getInstance("AES");
				secretKey = keyGenerator.generateKey();
				encrypter = Cipher.getInstance("AES");
				decrypter = Cipher.getInstance("AES");
				encrypter.init(Cipher.ENCRYPT_MODE, secretKey);
				decrypter.init(Cipher.DECRYPT_MODE, secretKey);
				// ASYMMETRICAL KEY ENCRYPTION ->
				keyPairGenerator = KeyPairGenerator.getInstance("RSA");
				keypair = keyPairGenerator.generateKeyPair();
				publicKey = keypair.getPublic();
				privateKey = keypair.getPrivate();
				authorship = Cipher.getInstance("RSA");
				authorshipVerifier = Cipher.getInstance("RSA");
				encryptConfidential = Cipher.getInstance("RSA");
				decryptConfidential = Cipher.getInstance("RSA");
				authorship.init(Cipher.ENCRYPT_MODE, privateKey);
				authorshipVerifier.init(Cipher.DECRYPT_MODE, publicKey);
				encryptConfidential.init(Cipher.ENCRYPT_MODE, publicKey);
				decryptConfidential.init(Cipher.DECRYPT_MODE, privateKey);
			} catch (GeneralSecurityException e) {
				e.printStackTrace();
			}
		}
		
		public void encryptWithSecretKey(String text) {
			byte[] encryptedData = null;
			try {
				encryptedData = encrypter.doFinal(text.getBytes());
			} catch (IllegalBlockSizeException e) {
				e.printStackTrace();
			} catch (BadPaddingException e) {
				e.printStackTrace();
			}
			repository.setEncryptedDataWithSecretKey(encryptedData);
		}
	
		public String getEncryptedText() {
			return Base64.getEncoder()
					.encodeToString(repository.getEncryptedDataWithSecretKey());
		}
	
		public String decryptText() {
			byte[] decryptedData = null;
			try {
				decryptedData = decrypter
						.doFinal(repository.getEncryptedDataWithSecretKey());
			} catch (IllegalBlockSizeException e) {
				e.printStackTrace();
			} catch (BadPaddingException e) {
				e.printStackTrace();
			}
			return new String(decryptedData);
		}
		
		public void doAuthorship(String text) {
			byte[] encryptedData = null;
			try {
				encryptedData = authorship.doFinal(text.getBytes());
			} catch (IllegalBlockSizeException e) {
				e.printStackTrace();
			} catch (BadPaddingException e) {
				e.printStackTrace();
			}
			
			repository.setDataWithAuthorship(encryptedData);
		}
		
		public String verifyAuthorship() {
			byte[] decryptedData = null;
			try {
				decryptedData = authorshipVerifier
						.doFinal(repository.getDataWithAuthorship());
			} catch (IllegalBlockSizeException e) {
				e.printStackTrace();
			} catch (BadPaddingException e) {
				e.printStackTrace();
			}
			return new String(decryptedData);
		}
		
		public void doConfidentiality(String text) {
			byte[] encryptedData = null;
			try {
				encryptedData = encryptConfidential.doFinal(text.getBytes());
			} catch (IllegalBlockSizeException e) {
				e.printStackTrace();
			} catch (BadPaddingException e) {
				e.printStackTrace();
			}
			
			repository.setDataWithConfidentiality(encryptedData);
		}
		
		public String verifyConfidentiality() {
			byte[] decryptedData = null;
			try {
				decryptedData = decryptConfidential
						.doFinal(repository.getDataWithConfidentiality());
			} catch (IllegalBlockSizeException e) {
				e.printStackTrace();
			} catch (BadPaddingException e) {
				e.printStackTrace();
			}
			return new String(decryptedData);
		}
		
		
	
	}
