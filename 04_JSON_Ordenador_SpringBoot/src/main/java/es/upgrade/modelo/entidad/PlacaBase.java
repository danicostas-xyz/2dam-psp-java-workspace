package es.upgrade.modelo.entidad;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Scope("prototype")
public class PlacaBase {
	private String modelo;
	private String marca;
	private int slots_ram;
}
