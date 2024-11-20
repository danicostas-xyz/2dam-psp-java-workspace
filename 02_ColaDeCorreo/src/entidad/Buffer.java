package entidad;

import java.util.ArrayList;
import java.util.List;

public class Buffer {

	private final int MAX_ELEM = 5;
	private List<Email> listaMails;

	public Buffer() {
		listaMails = new ArrayList<Email>();
	}

	public List<Email> getListaMails() {
		return listaMails;
	}

	public void setListaMails(List<Email> listaMails) {
		this.listaMails = listaMails;
	}

	public synchronized void addMail(Email em) {

		if (!validarDestinatario(em)) {
			System.out.println("No se admiten correos cuyo destinatario sea " + em.getDestinatario());
			return;
		}
		
		while (listaMails.size() == MAX_ELEM) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		listaMails.add(em);
		notify();

	}

	public synchronized Email getMail() {

		while (listaMails.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		Email email = listaMails.get(0);
		listaMails.remove(0);
		notify();

		return email;
	}

	private boolean validarDestinatario(Email e) {

		if (e.getDestinatario().equals("pikachu@gmail.com")) {
			return false;
		}

		return true;
	}
}
