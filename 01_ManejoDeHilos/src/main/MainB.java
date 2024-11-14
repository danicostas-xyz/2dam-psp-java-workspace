package main;

import java.util.Scanner;

public class MainB {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Primer número: ");
		long n1 = sc.nextLong();
		System.out.println("Segundo número: ");
		long n2 = sc.nextLong();
		System.out.println("String: ");
		sc.nextLine();
		String cadena = sc.nextLine();
		sc.close();

		/*
		 * 1. PODEMOS IMPLEMENTAR LA INTERFAZ RUNNABLE DIRECTAMENTE EN UNA CLASE
		 * ABSTRACTA Runnable r = new Runnable() {
		 * 
		 * @Override public void run() { // TODO Auto-generated method stub
		 * 
		 * }
		 * 
		 * };
		 */

		/*
		 * 2. PODEMOS IMPLEMENTAR LA INTERFAZ EN UNA CLASE (PRIMOS RUNNABLE) Y LUEGO
		 * CREAR EL OBJETO
		 */
		PrimosRunnable r1 = new PrimosRunnable(n1);
		UnoAMilMillones hilo2 = new UnoAMilMillones(n2);

		/*
		 * 3. PODEMOS IMPLEMENTAR DIRECTAMENTE LA INTERFAZ RUNNABLE CON UNA FUNCIÓN
		 * LAMBDA
		 */
//		Runnable r2 = () -> {
//
//			String nombreHilo = Thread.currentThread().getName();
//			System.out.println("---------------------------------------------------------");
//			System.out.println("Inicio hilo " + nombreHilo);
//
//			long inicio = System.currentTimeMillis();
//
//			long repeticiones = n1 - n2;
//			if (repeticiones < 0)
//				repeticiones *= -1; // Si el número es negativo, se convierta en positivo
//
//			for (long i = 0; i < repeticiones; i++) {
//				System.out.println(cadena);
//			}
//
//			long fin = (System.currentTimeMillis() - inicio);
//
//			System.out.println("Tiempo procesamiento " + nombreHilo + ": " + fin + " milisegundos.");
//			System.out.println("---------------------------------------------------------");
//		};

		Thread hilo1 = new Thread(r1);

		/*
		 * 4. Podemos implementar la interfaz runnable directamente dentro de los
		 * paréntesis del new Thread(). En este caso estamos haciendo lo mismo que en el
		 * punto 3, pero en lugar de crearnos una referencia para implementar Runnable,
		 * creamos la lambda directamente como parámetro, de manera "anónima"
		 */
		Thread hilo3 = new Thread(() -> {
			String nombreHilo = Thread.currentThread().getName();
			System.out.println("---------------------------------------------------------");
			System.out.println("Inicio hilo " + nombreHilo);

			long inicio = System.currentTimeMillis();

			long repeticiones = n1 - n2;
			if (repeticiones < 0)
				repeticiones *= -1; // Si el número es negativo, se convierta en positivo

			for (long i = 0; i < repeticiones; i++) {
				System.out.println(cadena);
			}

			long fin = (System.currentTimeMillis() - inicio);

			System.out.println("Tiempo procesamiento " + nombreHilo + ": " + fin + " milisegundos.");
			System.out.println("---------------------------------------------------------");
		});

		hilo1.start();
		hilo2.start();
		hilo3.start();

		System.out.println("Hilo main terminado");

	}

}
