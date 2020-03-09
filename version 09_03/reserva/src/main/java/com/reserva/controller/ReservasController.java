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

import com.reserva.dtos.FechasHorasDto;
import com.reserva.dtos.ReservasDto;
import com.reserva.dtos.SalasDto;
import com.reserva.dtos.UsuarioDto;
import com.reserva.entities.ReservasEntity;
import com.reserva.services.impl.FechasHorasServiceImpl;
import com.reserva.services.impl.ReservasServiceImpl;
import com.reserva.services.impl.SalasServiceImpl;
import com.reserva.services.impl.UsuarioServiceImpl;

@RestController
public class ReservasController {
	
	@Autowired
	private UsuarioServiceImpl usuarioService;
	@Autowired
	private SalasServiceImpl salasService;
	@Autowired
	private FechasHorasServiceImpl fechasHorasService;
	@Autowired
	private ReservasServiceImpl reservasService;
	/*
	 * @RequestMapping(value={"/"}, method = RequestMethod.GET) public ModelAndView
	 * login(){ ModelAndView modelAndView = new ModelAndView(); //
	 * modelAndView.setViewName("login"); return modelAndView; }
	 */
	
	@RequestMapping(value={"/","/inicio"}, method = RequestMethod.GET)
	public ModelAndView viewListReservasInicio(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewInicio");
		
		modelAndView.addObject("listReservas",reservasService.getReservasFecha());
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
		modelAndView.addObject("listUsers",usuarioService.getUsuarios());
		return modelAndView;
	}
	
	@RequestMapping(value="/usuarios/crearnuevousuario", method = RequestMethod.GET)
	public ModelAndView viewNuevoUsuario()throws SQLException{
       UsuarioDto usuarioDto = new UsuarioDto();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewNuevoUsuario");
		modelAndView.addObject("usuarioDto", usuarioDto);
		return modelAndView;
	}
	
	@RequestMapping(value="/usuarios/crearnuevousuario", method = RequestMethod.POST)
	public ModelAndView saveNuevoUsuario(
	     @ModelAttribute UsuarioDto usuarioDto,BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView();
		usuarioService.saveUsuario(usuarioDto);
	//	reservasService.updateFechasHoras(reservasDto);
		modelAndView.setViewName("admin/viewNuevoUsuario");
		return new ModelAndView("redirect:/usuarios");
	}
	
	@RequestMapping(value="/salas", method = RequestMethod.GET)
	public ModelAndView viewListSalas(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewListSalas");
		
		modelAndView.addObject("listSalas",salasService.getSalas());
		return modelAndView;
	}
	@RequestMapping(value="/salas/crearnuevasala", method = RequestMethod.GET)
	public ModelAndView viewNuevaSala()throws SQLException{
       SalasDto salasDto = new SalasDto();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewNuevaSala");
		modelAndView.addObject("salasDto", salasDto);
		return modelAndView;
	}
	@RequestMapping(value="/salas/crearnuevasala", method = RequestMethod.POST)
	public ModelAndView saveNuevaSala(
	     @ModelAttribute SalasDto salasDto,BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView();
		salasService.saveSalas(salasDto);
	//	reservasService.updateFechasHoras(reservasDto);
		modelAndView.setViewName("admin/viewNuevaSala");
		return new ModelAndView("redirect:/salas");
	}
	@RequestMapping(value="/reservas", method = RequestMethod.GET)
	public ModelAndView viewListReservas(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewListReservas");
		
		modelAndView.addObject("listReservas",reservasService.getReservas());
		return modelAndView;
	}

	/*
	 * @RequestMapping(value="/reservas/modificar", method = RequestMethod.GET)
	 * public ModelAndView viewModificarReservas(){ ModelAndView modelAndView = new
	 * ModelAndView(); modelAndView.setViewName("admin/viewModificarReserva");
	 * 
	 * modelAndView.addObject("listReservas",reservasService.getReservas()); return
	 * modelAndView; }
	 */
	@RequestMapping(value="/reservas/crearnuevareserva", method = RequestMethod.GET)
	public ModelAndView viewNuevaReserva() throws SQLException{
		ReservasDto reservasDto = new ReservasDto();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewNuevaReserva");
		modelAndView.addObject("reservasDto", reservasDto);
		modelAndView.addObject("listUsuarios",usuarioService.getUsuarios());
		modelAndView.addObject("listReservas",reservasService.getReservasDisponible());
		/*
		 * modelAndView.addObject("listSalas",salasService.getSalas());
		 * modelAndView.addObject("listFechasHoras",fechasHorasService.getFechasHoras())
		 * ;
		 */
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
		ReservasDto reservasDto=new ReservasDto();
		UsuarioDto usuariosDto=new UsuarioDto();
		usuariosDto.setIdusuario(user);
		SalasDto salasDto=new SalasDto();
		salasDto.setIdsala(room);
		FechasHorasDto fechasHoraDto= new FechasHorasDto();
		fechasHoraDto.setIdfechahora(datehour);
		
		reservasDto.setFechashoras(fechasHoraDto);
		reservasDto.setSalas(salasDto);
		reservasDto.setUsuarios(usuariosDto);
		reservasService.saveReserva(reservasDto);
	   reservasService.updateFechasHoras(reservasDto);
		return new ModelAndView("redirect:/reservas");
	}
	
	@RequestMapping(value="/reservas/borrar", method = RequestMethod.GET)
	public ModelAndView deleteReserva( 
			 @RequestParam("id") String id){
		ModelAndView modelAndView = new ModelAndView();
		      Long idl=Long.parseLong(id);
				reservasService.borrarReserva(idl);
			
		//modelAndView.addObject("listUsers",usuarioService.getUsuarios(1L));
		//modelAndView.setViewName("admin/viewListUser");
		return new  ModelAndView("redirect:/reservas");
	}
	@RequestMapping(value="/reservas/modificar", method = RequestMethod.GET)
	public ModelAndView viewModficarReserva(
			@RequestParam("reservas") String reservas
			) throws SQLException{
		ReservasDto reservasDto = new ReservasDto();
		 Long idr=Long.parseLong(reservas);
		 
		 reservasDto.setIdreserva(idr);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewModificarReserva");
		modelAndView.addObject("reservasDto", reservasDto);
		modelAndView.addObject("listReservasId",reservasService.getReservasId(idr));
		modelAndView.addObject("listUsuarios",usuarioService.getUsuarios());
		modelAndView.addObject("listReservas",reservasService.getReservasDisponible());
		/*
		 * modelAndView.addObject("listSalas",salasService.getSalas());
		 * modelAndView.addObject("listFechasHoras",fechasHorasService.getFechasHoras())
		 * ;
		 */
		return modelAndView;
	}
	
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
		reservasService.modificarReserva(newidroom,newiddate,oldidroom,oldiddate,idreserve,usuariol);
		/*
		 * modelAndView.addObject("listSalas",salasService.getSalas());
		 * modelAndView.addObject("listFechasHoras",fechasHorasService.getFechasHoras())
		 * ;
		 */
		return new ModelAndView("redirect:/reservas");
	}
	
	@RequestMapping(value="/usuarios/borrar", method = RequestMethod.GET)
	public ModelAndView deleteUser( 
			 @RequestParam("id") String id){
		ModelAndView modelAndView = new ModelAndView();
		      Long idl=Long.parseLong(id);
				usuarioService.borrarUsuario(idl);
			
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
		modelAndView.addObject("listUsuarios",usuarioService.getUsuarioId(idl));
		
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
		 usuarioService.modificarUsuario(idl,usuario,apellidos,email);
		
		//reservasService.modificarReserva(newidroom,newiddate,oldidroom,oldiddate,idreserve,usuariol);
		/*
		 * modelAndView.addObject("listSalas",salasService.getSalas());
		 * modelAndView.addObject("listFechasHoras",fechasHorasService.getFechasHoras())
		 * ;
		 */
		return new ModelAndView("redirect:/usuarios");
	}
	@RequestMapping(value="/salas/borrar", method = RequestMethod.GET)
	public ModelAndView deleteSala( 
			 @RequestParam("id") String id){
		ModelAndView modelAndView = new ModelAndView();
		      Long idl=Long.parseLong(id);
				salasService.borrarSala(idl);
			
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
		modelAndView.addObject("listSalas",salasService.getSalaId(idl));
		
		return modelAndView;
	}
	@RequestMapping(value="/salas/modificar", method = RequestMethod.POST)
	public ModelAndView ModficarSala(
			@RequestParam("id") String id,
			@RequestParam("nombre") String usuario,
			@RequestParam("descripcion") String descripcion
			) throws SQLException{
		 Long idl=Long.parseLong(id);
		 salasService.modificarSala(idl,usuario,descripcion);
		
		//reservasService.modificarReserva(newidroom,newiddate,oldidroom,oldiddate,idreserve,usuariol);
		/*
		 * modelAndView.addObject("listSalas",salasService.getSalas());
		 * modelAndView.addObject("listFechasHoras",fechasHorasService.getFechasHoras())
		 * ;
		 */
		return new ModelAndView("redirect:/salas");
	}
	
}
