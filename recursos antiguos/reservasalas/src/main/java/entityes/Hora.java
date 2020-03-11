package entityes;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the horas database table.
 * 
 */
@Entity
@Table(name="horas")
@NamedQuery(name="Hora.findAll", query="SELECT h FROM Hora h")
public class Hora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Temporal(TemporalType.TIMESTAMP)
	private Date hora;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="horaBean")
	private List<Reserva> reservas;

	public Hora() {
	}

	public Date getHora() {
		return this.hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setHoraBean(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setHoraBean(null);

		return reserva;
	}

}