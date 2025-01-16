package es.upgrade.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.google.gson.Gson;

import es.upgrade.configuracion.ConfiguracionSpring;
import es.upgrade.modelo.entidad.Ordenador;
import es.upgrade.modelo.entidad.Periferico;
import es.upgrade.modelo.entidad.Ram;

public class Main {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfiguracionSpring.class);
		Gson gson = new Gson();
		String json = "";

		try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/computer.json"))) {
			String line = br.readLine();
			while (line != null) {
				json += line;
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

//		System.out.println(json);

		Ordenador ordenador1 = createOrdenador(context);

//		System.out.println(ordenador1);

		System.out.println("");
		System.out.println("SERIALIZACIÓN DE OBJETO ORDENADOR A JSON:");
		System.out.println("");
		String ordenador1ToJson = gson.toJson(ordenador1);
		System.out.println(ordenador1ToJson);

		System.out.println("");
		System.out.println("DESERIALIZACIÓN DE JSON A OBJETO ORDENADOR:");
		System.out.println("");

		Ordenador ordenador2 = gson.fromJson(json, Ordenador.class);

		System.out.println(ordenador2);

	}

	private static Ordenador createOrdenador(ApplicationContext context) {
		Ordenador ordenador1 = context.getBean("ordenador", Ordenador.class);
		ordenador1.setNombre("Flameador 2025");
		ordenador1.setPrecio(2000);
		ordenador1.getProcesador().setHz(6000);
		ordenador1.getProcesador().setMarca("Intel");
		ordenador1.getProcesador().setModelo("i7");
		ordenador1.getProcesador().setHz(7000);
		ordenador1.getPlacaBase().setModelo("Z690");
		ordenador1.getPlacaBase().setMarca("MSI");
		ordenador1.getPlacaBase().setSlots_ram(4);
		ordenador1.getListaRams().add(new Ram(0, "Corsair", "DDR5", 16, 6000, 30));
		ordenador1.getListaRams().add(new Ram(1, "Corsair", "DDR5", 16, 6000, 30));
		ordenador1.getDiscoDuro().setCapacidad(1);
		ordenador1.getDiscoDuro().setModelo("Barracuda");
		ordenador1.getDiscoDuro().setTipo("HDD");
		ordenador1.getFuenteAlimentacion().setMarca("Manker");
		ordenador1.getFuenteAlimentacion().setModelo("ATX");
		ordenador1.getFuenteAlimentacion().setPotencia(750);
		ordenador1.getTarjetaGrafica().setCudas(9830);
		ordenador1.getTarjetaGrafica().setMarca("Nvidia");
		ordenador1.getTarjetaGrafica().setModelo("RTX4080");
		ordenador1.getListaPerifericos().add(new Periferico("Ratón", "Basilisk", "Razer"));
		ordenador1.getListaPerifericos().add(new Periferico("Teclado", "Hunstman V3 Pro", "Razer"));
		ordenador1.getListaPerifericos().add(new Periferico("Monitor", "Ultragear", "LG"));
		return ordenador1;
	}

}