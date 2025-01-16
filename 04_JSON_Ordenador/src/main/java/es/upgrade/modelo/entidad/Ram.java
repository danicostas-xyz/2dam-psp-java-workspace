package es.upgrade.modelo.entidad;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Component
@AllArgsConstructor
@Scope("prototype")
public class Ram {
	public Ram() {
		super();
		// TODO Auto-generated constructor stub
	}
    @SerializedName("_id")
	private int id;
	private String marca;
	private String tipo;
	private int capacidad;
	private int hz;
	private int cl;
}
