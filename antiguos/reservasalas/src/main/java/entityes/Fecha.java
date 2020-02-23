package entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the fechas database table.
 * 
 */
@Entity
@Table(name="fechas")
@NamedQuery(name="Fecha.findAll", query="SELECT f FROM Fecha f")
public class Fecha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Temporal(TemporalType.DATE)
	private Date fecha;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="fechaBean")
	private List<Reserva> reservas;

	public Fecha() {
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setFechaBean(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setFechaBean(null);

		return reserva;
	}

}