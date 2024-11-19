package entidad;

public class ProductorMails extends Thread {

	private String nombreProductor;
	private Buffer buffer;
	private Email email;
	private GeneradorMails gm;

	public ProductorMails(String nombreProductor, Buffer buffer) {
		super();
		this.buffer = buffer;
		this.nombreProductor = nombreProductor;
		gm = new GeneradorMails();
	}

	public Buffer getBuffer() {
		return buffer;
	}

	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}

	public String getNombreProductor() {
		return nombreProductor;
	}

	public void setNombreProductor(String nombreProductor) {
		this.nombreProductor = nombreProductor;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public GeneradorMails getGm() {
		return gm;
	}

	public void setGm(GeneradorMails gm) {
		this.gm = gm;
	}

	@Override
	public void run() {

		email = gm.generarMail();

		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);
				System.out.println(nombreProductor + " entrando al buffer\n");
				buffer.addMail(email);
				System.out.println(nombreProductor + " ha dejado el correo de " + email.getRemitente() + " con destino "
						+ email.getDestinatario() + " y asunto " + email.getAsunto()
						+ " en el Buffer satisfactoriamente.\n");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		super.run();
	}
}
