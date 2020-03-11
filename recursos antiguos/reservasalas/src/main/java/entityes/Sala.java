package entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the salas database table.
 * 
 */
@Entity
@Table(name="salas")

public class Sala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int idsala;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="sala")
	private List<Reserva> reservas;

	public Sala() {
	}

	public int getIdsala() {
		return this.idsala;
	}

	public void setIdsala(int idsala) {
		this.idsala = idsala;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setSala(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setSala(null);

		return reserva;
	}

}