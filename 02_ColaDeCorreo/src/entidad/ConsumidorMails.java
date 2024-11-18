package entidad;

public class ConsumidorMails {
	private Email email;
	private String nombreConsumidor = "Consumidor: " + Thread.currentThread().getName();

	public ConsumidorMails() {
		super();
	}

	public ConsumidorMails(Email email) {
		super();
		this.email = email;
	}

	public Email getEmail() {
		return email;
	}

	public String getNombreConsumidor() {
		return nombreConsumidor;
	}
	
	public void setEmail(Email email) {
		this.email = email;
	}
}
