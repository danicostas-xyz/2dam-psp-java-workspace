package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import negocio.ServerGestor;

import java.net.ServerSocket;

public class Server {

	public static final int PUERTO = 2017;

	public static void main(String[] args) {

		InetSocketAddress address = new InetSocketAddress(PUERTO);
		InputStreamReader entrada = null;
		PrintStream salida = null;
		Socket socketAlCliente = null;

		try (ServerSocket serverSocket = new ServerSocket()) {

			serverSocket.bind(address);

			int peticion = 0;

			while (true) {
				System.out.println("SERVIDOR: Esperando peticion por el puerto " + PUERTO + "...");

				socketAlCliente = serverSocket.accept();
				System.out.println("SERVIDOR: peticion numero " + ++peticion + " recibida");

				entrada = new InputStreamReader(socketAlCliente.getInputStream());
				BufferedReader br = new BufferedReader(entrada);

				String mensajeEntrada = br.readLine();
				System.out.println("SERVIDOR: Mensaje de entrada recibido: " + mensajeEntrada);

				// Procesamos el mensaje en el gestor del Server
				ServerGestor sg = new ServerGestor(mensajeEntrada);
				String resultadoProcesado = String.valueOf(sg.calcular());
				System.out.println("SERVIDOR: Mensaje a enviar: " + resultadoProcesado);

				salida = new PrintStream(socketAlCliente.getOutputStream());
				salida.println(resultadoProcesado);
				System.out.println("SERVIDOR: Mensaje enviado correctamente al cliente");
				System.out.println("");
				socketAlCliente.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("SERVIDOR: Error -> " + e);
			e.printStackTrace();
		}

	}

}
