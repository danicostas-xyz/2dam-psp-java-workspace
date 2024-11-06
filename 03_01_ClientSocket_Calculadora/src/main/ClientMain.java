package main;

import java.io.IOException;
import java.util.Scanner;

import negocio.ClientGestor;

public class ClientMain {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		seleccionarOpcion();
	}

	private static void seleccionarOpcion() throws IOException {
		int opcion = printMenu();
		while (opcion != 5) {

			System.out.print("Primer número: ");
			String n1 = sc.nextLine();
			System.out.print("Segundo número: ");
			String n2 = sc.nextLine();

			switch (opcion) {
			case 1:
				sumar(n1, n2);
				opcion = printMenu();
				break;
			case 2:
				restar(n1, n2);
				opcion = printMenu();
				break;
			case 3:
				multiplicar(n1, n2);
				opcion = printMenu();
				break;
			case 4:
				dividir(n1, n2);
				opcion = printMenu();
				break;
			}
		}
		salir();
	}

	private static int printMenu() {
		System.out.println("");
		System.out.println("QUÉ OPERACIÓN DESEAS REALIZAR?");
		System.out.println("1. Sumar");
		System.out.println("2. Restar");
		System.out.println("3. Multiplicar");
		System.out.println("4. Dividir");
		System.out.println("5. Salir");

		int opcion = Integer.parseInt(sc.nextLine());

		return opcion;

	}

	private static void sumar(String n1, String n2) throws IOException {
		ClientGestor cg = new ClientGestor("_sum_", n1, n2);
		cg.crearSocket();
	}

	private static void restar(String n1, String n2) throws IOException {
		ClientGestor cg = new ClientGestor("_res_", n1, n2);
		cg.crearSocket();
	}

	private static void multiplicar(String n1, String n2) throws IOException {
		ClientGestor cg = new ClientGestor("_mul_", n1, n2);
		cg.crearSocket();
	}

	private static void dividir(String n1, String n2) throws IOException {
		ClientGestor cg = new ClientGestor("_div_", n1, n2);
		cg.crearSocket();
	}

	private static void salir() {
		System.out.println("Programa finalizado");
	}

}
