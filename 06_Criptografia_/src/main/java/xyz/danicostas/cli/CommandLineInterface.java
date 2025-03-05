package xyz.danicostas.cli;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xyz.danicostas.model.service.EncryptService;

@Component
public class CommandLineInterface {
	
	@Autowired
	private EncryptService service;
	private Scanner scInt = new Scanner(System.in);
	private Scanner scStr = new Scanner(System.in);
	
	public void runApp() {

		printSlowly("CARGANDO", 5);
		print3Points(5, 5);

		System.out.println("\n================================");
		System.out.println("            CRYPTOVAINA         ");
		System.out.println("================================");

		printMainMenu();
		int opcion = validarOpcion(0, 7);

		while (opcion != 0) {

			switch (opcion) {
			case 1:
				encryptText();
				printMainMenu();
				opcion = validarOpcion(0, 7);
				break;
			case 2:
				showEncryptedText();
				printMainMenu();
				opcion = validarOpcion(0, 7);
				break;
			case 3:
				decryptText();
				printMainMenu();
				opcion = validarOpcion(0, 7);
				break;
			case 4:
				authorship();
				printMainMenu();
				opcion = validarOpcion(0, 7);
				break;
			case 5:
				verifyAuthorship();
				printMainMenu();
				opcion = validarOpcion(0, 7);
				break;
			case 6:
				confidentiality();
				printMainMenu();
				opcion = validarOpcion(0, 7);
				break;
			case 7:
				verifyConfidentiality();
				printMainMenu();
				opcion = validarOpcion(0, 7);
				break;
			default:
				break;
			}

		}

		System.out.println("\n============================");
		System.out.println("       FIN DEL PROGRAMA      ");
		System.out.println("=============================");
	}
	
	private void verifyConfidentiality() {
		printlnSlowly("LEER MENSAJE CONFIDENCIAL", 5);
		System.out.println();
		printSlowly("Leyendo", 20);
		print3Points(20, 20);
		String text = service.verifyConfidentiality();
		printSlowly("Pulsa enter para mostrar el texto confidencial", 20);
		scStr.nextLine();
		printlnSlowly("Texto: " + text, 10);
		
	}

	private void confidentiality() {
		printlnSlowly("GENERADOR DE CONFIDENCIALIDAD", 5);
		System.out.println();
		printlnSlowly("Texto a encriptar: ", 5);
		String text = scStr.nextLine();
		service.doConfidentiality(text);
		printSlowly("Encriptando", 20);
		print3Points(20, 20);
		printlnSlowly("Texto encriptado.", 10);
		printlnSlowly("Solo tu destinatario puede desencriptar el mensaje.", 10);
		
	}

	private void verifyAuthorship() {
		printlnSlowly("VERIFICADOR DE AUTENTICIDAD", 5);
		System.out.println();
		printSlowly("Verificando", 20);
		print3Points(20, 20);
		String text = service.verifyAuthorship();
		printSlowly("Pulsa enter para mostrar el texto verificado", 20);
		scStr.nextLine();
		printlnSlowly("Texto verificado: " + text, 10);
		
	}

	private void authorship() {
		printlnSlowly("AUTENTICADOR DE MENSAJE", 5);
		System.out.println();
		printlnSlowly("Texto a autenticar: ", 5);
		String text = scStr.nextLine();
		service.doAuthorship(text);
		printSlowly("Autenticando", 20);
		print3Points(20, 20);
		printlnSlowly("Texto autenticado.", 10);
		
	}

	private void decryptText() {
		printlnSlowly("DESENCRIPTADOR", 5);
		System.out.println();
		printSlowly("Desencriptando", 20);
		print3Points(20, 20);
		String text = service.decryptText();
		printSlowly("Pulsa enter para mostrar el texto desencriptado", 20);
		scStr.nextLine();
		printlnSlowly("Texto desencriptado: " + text, 10);
	}


	private void showEncryptedText() {
		printlnSlowly("REPOSITORIO", 5);
		System.out.println();
		printSlowly("Recuperando texto", 20);
		print3Points(20, 20);
		String text = service.getEncryptedText();
		printlnSlowly("Texto encriptado:", 10);
		printlnSlowly(text, 5);
	}


	private void encryptText() {
		printlnSlowly("ENCRIPTADOR", 5);
		System.out.println();
		printlnSlowly("Texto a encriptar: ", 5);
		String text = scStr.nextLine();
		service.encryptWithSecretKey(text);
		printSlowly("Encriptando", 20);
		print3Points(20, 20);
		printlnSlowly("Texto encriptado.", 10);
	}


	private void printMainMenu() {
		System.out.println("\n================================");
		printlnSlowly("- 0. Salir de la aplicación", 5);
		printlnSlowly("- 1. Encriptar frase (simétrica)", 5);
		printlnSlowly("- 2. Mostrar frase encriptada (simétrica)", 5);
		printlnSlowly("- 3. Desencriptar frase (simétrica)", 5);
		printlnSlowly("- 4. Garantizar autoría de mensaje (asimétrica)", 5);
		printlnSlowly("- 5. Comprobar autoría de mensaje (asimétrica)", 5);
		printlnSlowly("- 6. Garantizar confidencialidad de mensaje (asimétrica)", 5);
		printlnSlowly("- 7. Desencriptar mensaje confidencial (asimétrica)", 5);

		System.out.println("================================\n");
		printSlowly("- Seleccione una opción: ", 5);
	}
	
	
	private int validarIntNoVacio(String atributo) {
		int i = scInt.nextInt();

		while (i == 0) {
			printlnSlowly("Campo vacío no válido.", 25);
			printlnSlowly("- Introduce un valor para " + atributo, 25);
			i = scInt.nextInt();
		}
		return i;
	}

	private String validarStringNoVacio(String atributo) {

		String s = scStr.nextLine();

		while (s.isBlank()) {
			printlnSlowly("Campo vacío no válido.", 25);
			printlnSlowly("- Introduce un valor para " + atributo, 25);
			s = scStr.nextLine();
		}
		return s;
	}

	private int validarOpcion(int i, int j) {
		int opcion = scInt.nextInt();
		System.out.println("");
		while (opcion < i || opcion > j) {
			printlnSlowly("  [ERROR] Introduce una opción correcta", 25);
			System.out.println();
			printSlowly("- Introduce un número entre " + i + " y " + j + ": ", 25);
			opcion = scInt.nextInt();
		}
		return opcion;
	}

	public static void print3Points(int time, int time2) {
		for (int i = 0; i < 3; i++) {
			try {
				Thread.sleep(time);
				System.out.print(".");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(time2);
			System.out.print(" ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void printSlowly(String s, int time) {
		for (int i = 0; i < s.length(); i++) {
			try {
				Thread.sleep(time);
				System.out.print(s.charAt(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void printlnSlowly(String s, int time) {
		for (int i = 0; i < s.length(); i++) {
			try {
				Thread.sleep(time);
				System.out.print(s.charAt(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("");
	}

	
	
}
