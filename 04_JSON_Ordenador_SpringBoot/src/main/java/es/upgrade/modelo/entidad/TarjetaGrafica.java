package es.upgrade.modelo.entidad;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Scope("prototype")
public class TarjetaGrafica {
	private String marca;
	private String modelo;
	private int cudas;
}
