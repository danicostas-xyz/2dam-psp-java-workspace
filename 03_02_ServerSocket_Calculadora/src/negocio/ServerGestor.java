package negocio;

public class ServerGestor {

	private int n1;
	private int n2;
	private String operando;
	private String mensajeEntrada; // 1_sum_8

	public ServerGestor(String mensajeEntrada) {
		super();
		this.mensajeEntrada = mensajeEntrada;
	}

	private void formatearString() {
		String[] arrayMensaje = mensajeEntrada.split("_");
		n1 = Integer.parseInt(arrayMensaje[0]);
		operando = arrayMensaje[1];
		n2 = Integer.parseInt(arrayMensaje[2]);
	}

	public int calcular() {

		formatearString();

		switch (operando) {
		case "sum":
			return n1 + n2;
		case "res":
			return n1 - n2;
		case "mul":
			return n1 * n2;
		case "div":
			return n1 / n2;
		default:
			return 0;
		}
	}

}
