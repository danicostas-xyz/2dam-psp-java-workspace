package entidad;

import java.util.concurrent.atomic.AtomicInteger;

public class Email {

    private static AtomicInteger contadorId = new AtomicInteger(0);

    private int id;
    private String destinatario;
    private String remitente;
    private String asunto;
    private String cuerpoMensaje;

    public Email() {
    	this.id = contadorId.getAndIncrement();
    }

	public int getId() {
        return id;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getCuerpoMensaje() {
        return cuerpoMensaje;
    }

    public void setCuerpoMensaje(String cuerpoMensaje) {
        this.cuerpoMensaje = cuerpoMensaje;
    }
}
