package main;

import java.util.Scanner;

public class MainC {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Primer número: ");
		long n1 = sc.nextLong();
		System.out.println("Segundo número: ");
		long n2 = sc.nextLong();
		System.out.println("Tercer número: ");
		long n3 = sc.nextLong();

		CalculaNumerosPrimos hilo1 = new CalculaNumerosPrimos(n1);
		CalculaNumerosPrimos hilo2 = new CalculaNumerosPrimos(n2);
		CalculaNumerosPrimos hilo3 = new CalculaNumerosPrimos(n3);

		hilo1.run();
		hilo2.run();
		hilo3.run();

		System.out.println("Hilo main terminado");

		sc.close();

	}

}
