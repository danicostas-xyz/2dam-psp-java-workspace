package entidad;

/*
 * Este programa simula una cadena de procesamiento de correos electrónicos (emails) 
 * utilizando hilos en Java. Los emails contendrán un id, un destinatario, un remitente, 
 * un asunto y un cuerpo del mensaje.
 *
 * En lugar de enviar directamente los emails a sus destinatarios, estos se depositarán 
 * en un buffer con una capacidad máxima de 5 emails. Este buffer permite registrar 
 * cuántos correos se procesan en diferentes franjas horarias y limita el espacio de memoria.
 *
 * El sistema incluye:
 * 
 * 1. Tres hilos productores:
 *    - Cada hilo producirá un total de 10 emails.
 *    - Los emails generados tendrán un destinatario, un remitente, un asunto y un cuerpo únicos.
 *    - Los productores añadirán los emails al buffer cada 0,5 segundos.
 *    - Cada vez que un productor añada un email al buffer, imprimirá por pantalla el nombre 
 *      del hilo y el id del email añadido.
 *
 * 2. Dos hilos consumidores:
 *    - Los consumidores procesarán los emails disponibles en el buffer.
 *    - Al consumir un email, simularán su envío imprimiendo por pantalla los datos del email 
 *      y el nombre del hilo consumidor que lo procesó.
 *
 * 3. Reglas de exclusión:
 *    - No se permite procesar emails cuyo destinatario sea "pikachu@gmail.com".
 *    - Cualquier email con este destinatario será descartado antes de añadirse al buffer.
 *    - Cada vez que se descarte un email, se imprimirá por pantalla un mensaje 
 *      indicando que el email fue rechazado.
 *
 * Nota importante:
 * - La lógica para descartar emails con destinatarios no permitidos debe implementarse 
 *   dentro del buffer de procesamiento, no en los productores ni en los consumidores.
 */
public class MailServer {

	public static void main(String[] args) {

	}

}
