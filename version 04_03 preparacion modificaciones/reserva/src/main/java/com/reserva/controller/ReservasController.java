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
		return new ModelAndView("redirect:http://localhost:8080/reserva/usuarios");
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
		return new ModelAndView("redirect:http://localhost:8080/reserva/salas");
	}
	@RequestMapping(value="/reservas", method = RequestMethod.GET)
	public ModelAndView viewListReservas(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewListReservas");
		
		modelAndView.addObject("listReservas",reservasService.getReservas());
		return modelAndView;
	}
	@RequestMapping(value="/reservas/modificar", method = RequestMethod.GET)
	public ModelAndView viewModificarReservas(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewModificarReserva");
		
		modelAndView.addObject("listReservas",reservasService.getReservas());
		return modelAndView;
	}
	@RequestMapping(value="/reservas/crearnuevareserva", method = RequestMethod.GET)
	public ModelAndView viewNuevaReserva() throws SQLException{
		ReservasDto reservasDto = new ReservasDto();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewNuevaReserva");
		modelAndView.addObject("reservasDto", reservasDto);
		modelAndView.addObject("listUsuarios",usuarioService.getUsuarios());
		modelAndView.addObject("listSalas",salasService.getSalas());
		modelAndView.addObject("listFechasHoras",fechasHorasService.getFechasHoras());
		return modelAndView;
	}


	@RequestMapping(value="/reservas/crearnuevareserva", method = RequestMethod.POST)
	public ModelAndView saveNuevaReserva(
	     @ModelAttribute ReservasDto reservasDto,BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView();
		reservasService.saveReserva(reservasDto);
		reservasService.updateFechasHoras(reservasDto);
		modelAndView.setViewName("admin/viewListReservas");
		return new ModelAndView("redirect:http://localhost:8080/reservas");
	}
	
	@RequestMapping(value="/reservas/borrar", method = RequestMethod.GET)
	public ModelAndView deleteReserva( 
			 @RequestParam("id") String id){
		ModelAndView modelAndView = new ModelAndView();
		      Long idl=Long.parseLong(id);
				reservasService.borrarReserva(idl);
			
		//modelAndView.addObject("listUsers",usuarioService.getUsuarios(1L));
		//modelAndView.setViewName("admin/viewListUser");
		return new  ModelAndView("redirect:http://localhost:8080/reservas");
	}
	
	@RequestMapping(value="/usuarios/borrar", method = RequestMethod.GET)
	public ModelAndView deleteUser( 
			 @RequestParam("id") String id){
		ModelAndView modelAndView = new ModelAndView();
		      Long idl=Long.parseLong(id);
				usuarioService.borrarUsuario(idl);
			
		//modelAndView.addObject("listUsers",usuarioService.getUsuarios(1L));
		//modelAndView.setViewName("admin/viewListUser");
		return new  ModelAndView("redirect:http://localhost:8080/usuarios");
	}
	@RequestMapping(value="/salas/borrar", method = RequestMethod.GET)
	public ModelAndView deleteSala( 
			 @RequestParam("id") String id){
		ModelAndView modelAndView = new ModelAndView();
		      Long idl=Long.parseLong(id);
				salasService.borrarSala(idl);
			
		//modelAndView.addObject("listUsers",usuarioService.getUsuarios(1L));
		//modelAndView.setViewName("admin/viewListUser");
		return new  ModelAndView("redirect:http://localhost:8080/salas");
	}
	
}
