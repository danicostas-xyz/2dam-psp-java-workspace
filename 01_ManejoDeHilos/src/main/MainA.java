package main;

import java.util.Scanner;

public class MainA {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Primer número: ");
		long n1 = sc.nextLong();
		System.out.println("Segundo número: ");
		long n2 = sc.nextLong();
		System.out.println("Tercer número: ");
		long n3 = sc.nextLong();
		sc.close();

		CalculaNumerosPrimos hilo1 = new CalculaNumerosPrimos(n1);
		CalculaNumerosPrimos hilo2 = new CalculaNumerosPrimos(n2);
		CalculaNumerosPrimos hilo3 = new CalculaNumerosPrimos(n3);

		hilo1.start();
		hilo2.start();
		hilo3.start();

		System.out.println("Hilo main terminado");

	}

}
