package com.reserva.dtos;

public class Ars_reservasDto {

	private Long pk_id_reserva;
	private Ars_reservas_salDto ars_reservas_sal;
	private Ars_reservas_usuDto ars_reservas_usu;
	private Ars_reservas_dispDto ars_reservas_disp;
	private String var_comentarios;
	
	
	public Long getPk_id_reserva() {
		return pk_id_reserva;
	}
	public void setPk_id_reserva(Long pk_id_reserva) {
		this.pk_id_reserva = pk_id_reserva;
	}
	public Ars_reservas_salDto getArs_reservas_sal() {
		return ars_reservas_sal;
	}
	public void setArs_reservas_sal(Ars_reservas_salDto ars_reservas_sal) {
		this.ars_reservas_sal = ars_reservas_sal;
	}
	public Ars_reservas_usuDto getArs_reservas_usu() {
		return ars_reservas_usu;
	}
	public void setArs_reservas_usu(Ars_reservas_usuDto ars_reservas_usu) {
		this.ars_reservas_usu = ars_reservas_usu;
	}
	public Ars_reservas_dispDto getArs_reservas_disp() {
		return ars_reservas_disp;
	}
	public void setArs_reservas_disp(Ars_reservas_dispDto ars_reservas_disp) {
		this.ars_reservas_disp = ars_reservas_disp;
	}
	public String getVar_comentarios() {
		return var_comentarios;
	}
	public void setVar_comentarios(String var_comentarios) {
		this.var_comentarios = var_comentarios;
	}
	
	
}
