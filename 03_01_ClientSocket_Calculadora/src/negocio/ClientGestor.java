package negocio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientGestor {

	public static final int PUERTO = 2017;
	public static final String DIR_IP = "localhost";

	public String operador;
	public String operando1;
	public String operando2;

	public ClientGestor(String operador, String operando1, String operando2) {
		this.operador = operador;
		this.operando1 = operando1;
		this.operando2 = operando2;
	}

	public void crearSocket() throws IOException {

		InetSocketAddress address = new InetSocketAddress(DIR_IP, PUERTO);

		try (Socket clientSocket = new Socket()) {

			String mensajePeticion = operando1 + operador + operando2;
			
			System.out.println("- MENSAJE A ENVIAR: " + mensajePeticion);

			System.out.println("1. Creando conexión");
			clientSocket.connect(address);
			System.out.println("2. Conexión establecida");

			PrintStream salida = new PrintStream(clientSocket.getOutputStream());
			salida.println(mensajePeticion);
			System.out.println("3. Enviando Datos");

			System.out.println("4. Procesando petición");

			// --

			System.out.println("5. Obteniendo resultados");
			InputStreamReader entrada = new InputStreamReader(clientSocket.getInputStream());
			BufferedReader bf = new BufferedReader(entrada);
			String resultadoEntrada = bf.readLine();

			System.out.println("6. Resultado de la petición: " +  "(" + mensajePeticion +")" + " ->");
			System.out.println(resultadoEntrada);

		} catch (UnknownHostException e) {
			System.err.println("CLIENTE: No encuentro el servidor en la dirección" + DIR_IP);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("CLIENTE: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("CLIENTE: Error -> " + e);
			e.printStackTrace();
		}
	}

}
