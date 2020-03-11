package entityes;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reservas database table.
 * 
 */
@Entity
@Table(name="reservas")
@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idreserva;

	private String comentarios;

	//bi-directional many-to-one association to Sala
	@ManyToOne
	@JoinColumn(name="sala_id")
	private Sala sala;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	//bi-directional many-to-one association to Hora
	@ManyToOne
	@JoinColumn(name="hora")
	private Hora horaBean;

	//bi-directional many-to-one association to Fecha
	@ManyToOne
	@JoinColumn(name="fecha")
	private Fecha fechaBean;

	public Reserva() {
	}

	public int getIdreserva() {
		return this.idreserva;
	}

	public void setIdreserva(int idreserva) {
		this.idreserva = idreserva;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Sala getSala() {
		return this.sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Hora getHoraBean() {
		return this.horaBean;
	}

	public void setHoraBean(Hora horaBean) {
		this.horaBean = horaBean;
	}

	public Fecha getFechaBean() {
		return this.fechaBean;
	}

	public void setFechaBean(Fecha fechaBean) {
		this.fechaBean = fechaBean;
	}

}