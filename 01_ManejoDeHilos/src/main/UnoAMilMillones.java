package main;

public class UnoAMilMillones extends Thread {

	private long num;

	public UnoAMilMillones(long num) {
		super();
		this.num = num;
	}

	@Override
	public void run() {
		String nombreHilo = Thread.currentThread().getName();
		long inicio = System.currentTimeMillis();
		System.out.println("----------------------------------------------------");
		System.out.println("INICIO HILO " + nombreHilo);
		unoAMilMillones(num);
		long fin = (System.currentTimeMillis() - inicio);

		System.out.println("- Tiempo ejecución hilo 2: " + fin + " milisegundos.");
		System.out.println("FIN HILO " + nombreHilo);
		System.out.println("----------------------------------------------------");
	}

	public void unoAMilMillones(long n1) {

		for (long i = n1; i <= 1_000; i++) {
			System.out.println("Número: " + i);
		}

	}
}
