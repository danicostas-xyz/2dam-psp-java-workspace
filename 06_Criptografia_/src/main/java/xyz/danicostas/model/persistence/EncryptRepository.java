package xyz.danicostas.model.persistence;

@org.springframework.stereotype.Repository
public class EncryptRepository {

	// SYMMETRIC
	private byte[] encryptedDataWithSecretKey;
	private String decryptedDataWithSecretKey;
	private byte[] encryptedDataWithPublicKey;
	private byte[] encryptedDataWithPrivateKey;
	// ASYMMETRIC
	private byte[] dataWithAuthorship;
	private byte[] dataWithConfidentiality;
	// HASHING
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEncryptedDataWithSecretKey(byte[] encryptedText) {
		this.encryptedDataWithSecretKey = encryptedText;
	}

	public byte[] getEncryptedDataWithSecretKey() {
		return encryptedDataWithSecretKey;
	}

	public String getDecryptedDataWithSecretKey() {
		return decryptedDataWithSecretKey;
	}

	public void setDecryptedDataWithSecretKey(String decryptedText) {
		this.decryptedDataWithSecretKey = decryptedText;
	}

	public void setDataWithAuthorship(byte[] encryptedData) {
		this.dataWithAuthorship = encryptedData;
	}
	
	public void setDataWithConfidentiality(byte[] encryptedData) {
		this.dataWithConfidentiality = encryptedData;
	}

	public byte[] getDataWithConfidentiality() {
		return dataWithConfidentiality;
	}

	public byte[] getDataWithAuthorship() {
		return dataWithAuthorship;
	}
}