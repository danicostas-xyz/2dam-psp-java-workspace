package main;

public class PrimosRunnable implements Runnable {

	private long num;

	public PrimosRunnable(Long n) {
		this.num = n;
	}

	@Override
	public void run() {
		String nombreHilo = Thread.currentThread().getName();
		System.out.println("Inicio hilo " + nombreHilo);
		long inicio = System.currentTimeMillis();

		String resultado = "";

		if (isPrime(num)) {
			resultado = num + " es primo.";
		} else {
			resultado = num + " no es primo.";
		}

		long tiempoProcesamiento = ((System.currentTimeMillis() - inicio));

		System.out.println("- Número procesado: " + num + "\n" + "- Hilo: " + Thread.currentThread().getName() + "\n"
				+ "- Resultado: " + resultado + "\n" + "- Tiempo de procesamiento: " + tiempoProcesamiento
				+ " milisegundos");

		System.out.println("Fin hilo" + Thread.currentThread().getName());
		System.out.println("");
	}

	private boolean isPrime(long num2) {

		long cont = 0;

		for (long i = 1; i <= num2; i++) {
			if (num2 % i == 0) {
				cont++;
			}
		}

		if (cont == 2) {
			return true;
		} else if (cont == 1) {
			return false;
		} else {
			return false;
		}
	}

}
