package entidad;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class GeneradorMails {
	
	public int contador;
	
	public Email generarMail() {
		
		Email email = new Email(); // El id se genera automáticamente al crear un email
		
		email.setDestinatario(generarDestinatario());
		email.setRemitente(generarRemitente());
		email.setAsunto(generarAsunto());
		email.setCuerpoMensaje(generarCuerpoMensaje());
		email.setId(generarId());
		
		return email;
	}

	private String generarDestinatario() {

		String[] listaDestinatarios = new String[] { "fdepablo@gmail.com", "dcr@gmail.com", "manolo@gmail.com",
				"antonio@yahoo.es", "pikachu@gmail.com", "pedrosanchez@gob.es", "upgradehub.escuela@gmail.com",
				"jesuschrist@god.es", "messi_10@gmail.ar" };

		int p = ThreadLocalRandom.current().nextInt(0, listaDestinatarios.length);
		return listaDestinatarios[p];
	}

	private String generarRemitente() {

		String[] listaRemitentes = new String[] { "cristianoronaldo@gmail.com", "iagoaspas@gmail.com",
				"diegoarmando@gmail.com", "viniciusjr@yahoo.es", "mewtwo@gmail.com", "elonmusk@gob.es",
				"m.rajoy@gmail.com", "kanyewest@god.es", "kendricklamar@gmail.ar" };

		int p = ThreadLocalRandom.current().nextInt(0, listaRemitentes.length);
		return listaRemitentes[p];
	}

	private String generarAsunto() {

		String[] listaAsuntos = new String[] { "Solicitud de reunión urgente", "Actualización del proyecto trimestral",
				"Invitación a la conferencia tecnológica", "Confirmación de asistencia al evento",
				"Propuesta de colaboración", "Problemas con el servidor principal", "Notificación de entrega pendiente",
				"Recordatorio de vencimiento de contrato", "Nueva oferta para clientes premium" };

		int p = ThreadLocalRandom.current().nextInt(0, listaAsuntos.length);
		return listaAsuntos[p];
	}

	private String generarCuerpoMensaje() {

		String[] listaCuerpos = new String[] {
				"Espero que este mensaje te encuentre bien. Por favor, confirma si has recibido la documentación solicitada.",
				"Te escribo para informarte sobre algunos cambios importantes en el proyecto. Hablemos pronto.",
				"Adjunto encontrarás el informe solicitado. Avísame si necesitas alguna aclaración adicional.",
				"Solo quería recordarte que el plazo para completar la tarea es el próximo viernes.",
				"Por favor, revisa la propuesta que envié y comparte tus comentarios cuando tengas un momento.",
				"Quería agradecerte por el tiempo dedicado a nuestra última reunión. Fue muy productiva.",
				"Espero que podamos coordinar una reunión para discutir los próximos pasos del proyecto.",
				"No olvides revisar los archivos adjuntos y avisarme si necesitas algo más.",
				"Estoy a tu disposición para aclarar cualquier duda. Quedo a la espera de tu respuesta." };

		int p = ThreadLocalRandom.current().nextInt(0, listaCuerpos.length);
		return listaCuerpos[p];
	}
	
	private synchronized int generarId() {
		return contador++;
	}

}
