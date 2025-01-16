package es.upgrade.modelo.entidad;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Scope("prototype")
public class Ordenador {
	private String nombre;
	private double precio;
	@Autowired
	private Procesador procesador;
	@Autowired
	private PlacaBase placaBase;
	private List<Ram> listaRams = new ArrayList<Ram>();
	@Autowired
	private DiscoDuro discoDuro;
	@Autowired
	private FuenteAlimentacion fuenteAlimentacion;
	@Autowired
	private TarjetaGrafica tarjetaGrafica;
	private List<Periferico> listaPerifericos = new ArrayList<Periferico>();
	

}
