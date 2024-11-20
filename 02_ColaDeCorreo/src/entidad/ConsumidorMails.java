package entidad;

public class ConsumidorMails extends Thread {

	private String nombreConsumidor = "Consumidor: " + Thread.currentThread().getName();
	private Buffer buffer;
	private Email email;

	public ConsumidorMails(String nombreConsumidor, Buffer buffer) {
		super();
		this.buffer = buffer;
		this.nombreConsumidor = nombreConsumidor;
	}

	public String getNombreConsumidor() {
		return nombreConsumidor;
	}

	public void setNombreConsumidor(String nombreConsumidor) {
		this.nombreConsumidor = nombreConsumidor;
	}

	public Buffer getBuffer() {
		return buffer;
	}

	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println(nombreConsumidor + " entrando al buffer\n");
			email = buffer.getMail();
			System.out.println(nombreConsumidor + " ha enviado el siguiente correo electrónico:\n"
					+ email.toString());
		}
	}

}
