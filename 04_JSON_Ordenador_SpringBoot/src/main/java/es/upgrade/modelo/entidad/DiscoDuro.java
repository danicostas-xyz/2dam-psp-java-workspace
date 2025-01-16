package es.upgrade.modelo.entidad;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Scope("prototype")
public class DiscoDuro {
	private String modelo;
	private String tipo;
	private int capacidad;
}
