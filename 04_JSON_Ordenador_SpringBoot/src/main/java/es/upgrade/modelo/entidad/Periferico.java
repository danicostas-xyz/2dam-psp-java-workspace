package es.upgrade.modelo.entidad;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Component
@AllArgsConstructor
@Scope("prototype")
public class Periferico {
	private String tipo;
	private String nombre;
	private String marca;
	public Periferico() {
		super();
	}
}
