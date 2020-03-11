package com.reserva.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.reserva.dtos.Ars_reservasDto;
import com.reserva.dtos.Ars_reservas_dispDto;
import com.reserva.dtos.Ars_reservas_salDto;
import com.reserva.dtos.Ars_reservas_usuDto;
import com.reserva.services.impl.Ars_reservasServiceImpl;

//idsala

import com.reserva.services.impl.Ars_reservas_dispServiceImpl;
import com.reserva.services.impl.Ars_reservas_salServiceImpl;
import com.reserva.services.impl.Ars_reservas_usuServiceImpl;




@RestController
public class ReservasController {
	
	@Autowired
	private Ars_reservas_usuServiceImpl ars_reservas_usuService;
	@Autowired
	private Ars_reservas_salServiceImpl ars_reservas_salService;
	@Autowired
	private Ars_reservas_dispServiceImpl ars_reservas_dispService;
	@Autowired
	private Ars_reservasServiceImpl ars_reservasService;
	
	
	@RequestMapping(value={"/","/inicio"}, method = RequestMethod.GET)
	public ModelAndView viewListReservasInicio(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewInicio");
		
		modelAndView.addObject("listReservas",ars_reservasService.getReservasFecha());
		return modelAndView;
	}
	
	
	
	@ExceptionHandler(value = SQLException.class)
	    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
	        ModelAndView m = new ModelAndView("admin/viewListUser");
	        m.addObject("exception", e.toString());
	        m.addObject("url", req.getRequestURL());
	        return m;
	 }
	
	@RequestMapping(value="/usuarios", method = RequestMethod.GET)
	public ModelAndView viewListUsuarios(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewListUsuarios");
		modelAndView.addObject("listUsers",ars_reservas_usuService.getUsuarios());
		return modelAndView;
	}
	
	@RequestMapping(value="/usuarios/crearnuevousuario", method = RequestMethod.GET)
	public ModelAndView viewNuevoUsuario()throws SQLException{
		Ars_reservas_usuDto ars_reservas_usuDto = new Ars_reservas_usuDto();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewNuevoUsuario");
		modelAndView.addObject("ars_reservas_usuDto", ars_reservas_usuDto);
		return modelAndView;
	}
	
	@RequestMapping(value="/usuarios/crearnuevousuario", method = RequestMethod.POST)
	public ModelAndView saveNuevoUsuario(
	     @ModelAttribute Ars_reservas_usuDto usuarioDto,BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView();
		ars_reservas_usuService.saveUsuario(usuarioDto);
	
		modelAndView.setViewName("admin/viewNuevoUsuario");
		return new ModelAndView("redirect:/usuarios");
	}
	
	@RequestMapping(value="/salas", method = RequestMethod.GET)
	public ModelAndView viewListSalas(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewListSalas");
		
		modelAndView.addObject("listSalas",ars_reservas_salService.getSalas());
		return modelAndView;
	}
	@RequestMapping(value="/salas/crearnuevasala", method = RequestMethod.GET)
	public ModelAndView viewNuevaSala()throws SQLException{
		Ars_reservas_salDto ars_reservas_salDto = new Ars_reservas_salDto();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewNuevaSala");
		modelAndView.addObject("ars_reservas_salDto", ars_reservas_salDto);
		return modelAndView;
	}
	@RequestMapping(value="/salas/crearnuevasala", method = RequestMethod.POST)
	public ModelAndView saveNuevaSala(
	     @ModelAttribute Ars_reservas_salDto ars_reservas_salDto,BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView();
		ars_reservas_salService.saveSalas(ars_reservas_salDto);
	//	reservasService.updateFechasHoras(reservasDto);
		modelAndView.setViewName("admin/viewNuevaSala");
		return new ModelAndView("redirect:/salas");
	}
	@RequestMapping(value="/reservas", method = RequestMethod.GET)
	public ModelAndView viewListReservas(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewListReservas");
		
		modelAndView.addObject("listReservas",ars_reservasService.getReservas());
		return modelAndView;
	}

	
	@RequestMapping(value="/reservas/crearnuevareserva", method = RequestMethod.GET)
	public ModelAndView viewNuevaReserva() throws SQLException{
		Ars_reservasDto reservasDto = new Ars_reservasDto();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewNuevaReserva");
		modelAndView.addObject("reservasDto", reservasDto);
		modelAndView.addObject("listUsuarios",ars_reservas_usuService.getUsuarios());
		modelAndView.addObject("listReservas",ars_reservasService.getReservasDisponible());
		
		return modelAndView;
	}


	@RequestMapping(value="/reservas/crearnuevareserva", method = RequestMethod.POST)
	public ModelAndView saveNuevaReserva(
	     @RequestParam("reserva") String reserva, @RequestParam("usuario") String usuario){
		ModelAndView modelAndView = new ModelAndView();
		Long user=Long.parseLong(usuario);
		
		String[] st=reserva.split("-");
		Long room=Long.parseLong(st[1]);
		Long datehour=Long.parseLong(st[0]);
		modelAndView.setViewName("admin/viewListReservas");
		Ars_reservasDto reservasDto=new Ars_reservasDto();
		Ars_reservas_usuDto usuariosDto=new Ars_reservas_usuDto();
		usuariosDto.setPk_id_usuario(user);
		Ars_reservas_salDto ars_reservas_salDto=new Ars_reservas_salDto();
		ars_reservas_salDto.setPk_id_sala(room);
		Ars_reservas_dispDto ars_reservas_dispDto= new Ars_reservas_dispDto();
		ars_reservas_dispDto.setPk_id_disponibilidad(datehour);
		
		reservasDto.setArs_reservas_disp(ars_reservas_dispDto);
		reservasDto.setArs_reservas_sal(ars_reservas_salDto);
		reservasDto.setArs_reservas_usu(usuariosDto);
		ars_reservasService.saveReserva(reservasDto);
		ars_reservasService.updateFechasHoras(reservasDto);
		return new ModelAndView("redirect:/reservas");
	}
	
	@RequestMapping(value="/reservas/borrar", method = RequestMethod.GET)
	public ModelAndView deleteReserva( 
			 @RequestParam("id") String id){
		ModelAndView modelAndView = new ModelAndView();
		      String[] st=id.split("-");
		
		      Long idrl=Long.parseLong(st[0]);
		      Long idrd=Long.parseLong(st[1]);
		      ars_reservasService.borrarReserva(idrl,idrd);
			
		
		return new  ModelAndView("redirect:/reservas");
	}
	@RequestMapping(value="/reservas/modificar", method = RequestMethod.GET)
	public ModelAndView viewModficarReserva(
			@RequestParam("reservas") String reservas
			) throws SQLException{
		Ars_reservasDto reservasDto = new Ars_reservasDto();
		 Long idr=Long.parseLong(reservas);
		 
		 reservasDto.setPk_id_reserva(idr);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewModificarReserva");
		modelAndView.addObject("reservasDto", reservasDto);
		modelAndView.addObject("listReservasId",ars_reservasService.getReservasId(idr));
		modelAndView.addObject("listUsuarios",ars_reservas_usuService.getUsuarios());
		modelAndView.addObject("listReservas",ars_reservasService.getReservasDisponible());
		
		return modelAndView;
	}
	//FechasHorasEntity
	@RequestMapping(value="/reservas/modificar", method = RequestMethod.POST)
	public ModelAndView ModficarReserva(
			@RequestParam("reservas") String reservas,
			@RequestParam("usuario") String usuario,
			@RequestParam("reservaid") String reservaid
			) throws SQLException{
		String[] st=reservas.split("-");
		String[] st2=reservaid.split("-");
		Long newidroom=Long.parseLong(st[1]);
		Long newiddate=Long.parseLong(st[0]);
		Long idreserve=Long.parseLong(st2[0]);
		Long oldiddate=Long.parseLong(st2[1]);
		Long oldidroom=Long.parseLong(st2[2]);
		Long usuariol=Long.parseLong(usuario);
		ars_reservasService.modificarReserva(newidroom,newiddate,oldidroom,oldiddate,idreserve,usuariol);
		
		return new ModelAndView("redirect:/reservas");
	}
	
	@RequestMapping(value="/usuarios/borrar", method = RequestMethod.GET)
	public ModelAndView deleteUser( 
			 @RequestParam("id") String id){
		ModelAndView modelAndView = new ModelAndView();
		      Long idl=Long.parseLong(id);
		      ars_reservas_usuService.borrarUsuario(idl);
			
		//modelAndView.addObject("listUsers",usuarioService.getUsuarios(1L));
		//modelAndView.setViewName("admin/viewListUser");
		return new  ModelAndView("redirect:/usuarios");
	}
	@RequestMapping(value="/usuarios/modificar", method = RequestMethod.GET)
	public ModelAndView viewModficarUsuario(
			@RequestParam("id") String id)  {
		 Long idl=Long.parseLong(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewModificarUsuario");
		modelAndView.addObject("listUsuarios",ars_reservas_usuService.getUsuarioId(idl));
		
		return modelAndView;
	}
	@RequestMapping(value="/usuarios/modificar", method = RequestMethod.POST)
	public ModelAndView ModficarUsuario(
			@RequestParam("id") String id,
			@RequestParam("nombre") String usuario,
			@RequestParam("apellidos") String apellidos,
			@RequestParam("email") String email
			) throws SQLException{
		 Long idl=Long.parseLong(id);
		 ars_reservas_usuService.modificarUsuario(idl,usuario,apellidos,email);
		
		
		return new ModelAndView("redirect:/usuarios");
	}
	@RequestMapping(value="/salas/borrar", method = RequestMethod.GET)
	public ModelAndView deleteSala( 
			 @RequestParam("id") String id){
		ModelAndView modelAndView = new ModelAndView();
		      Long idl=Long.parseLong(id);
		      ars_reservas_salService.borrarSala(idl);
			
		//modelAndView.addObject("listUsers",usuarioService.getUsuarios(1L));
		//modelAndView.setViewName("admin/viewListUser");
		return new  ModelAndView("redirect:/salas");
	}
	
	@RequestMapping(value="/salas/modificar", method = RequestMethod.GET)
	public ModelAndView viewModficarSala(
			@RequestParam("id") String id)
			 throws SQLException{
		 Long idl=Long.parseLong(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewModificarSala");
		modelAndView.addObject("listSalas",ars_reservas_salService.getSalaId(idl));
		
		return modelAndView;
	}
	@RequestMapping(value="/salas/modificar", method = RequestMethod.POST)
	public ModelAndView ModficarSala(
			@RequestParam("id") String id,
			@RequestParam("nombre") String usuario,
			@RequestParam("descripcion") String descripcion
			) throws SQLException{
		 Long idl=Long.parseLong(id);
		 ars_reservas_salService.modificarSala(idl,usuario,descripcion);
		
		
		return new ModelAndView("redirect:/salas");
	}
	
}
