package entidad;

public class ProductorMails {

	private Email email;
	private String nombreProductor = "Productor: " + Thread.currentThread().getName();

	public ProductorMails() {
		super();
	}

	public ProductorMails(Email email) {
		super();
		this.email = email;
	}

	public Email getEmail() {
		return email;
	}

	public String getNombreProductor() {
		return nombreProductor;
	}
	
	public void setEmail(Email email) {
		this.email = email;
	}

}
