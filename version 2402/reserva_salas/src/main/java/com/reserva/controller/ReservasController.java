package com.reserva.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.reserva.dtos.ReservasDto;
import com.reserva.dtos.UsuarioDto;
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
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("home");
		return modelAndView;
	}
	
	/*
	 * @RequestMapping(value="/b", method = RequestMethod.GET) public ModelAndView
	 * viewNewUser() throws SQLException{ UsuarioDto usuarioDto = new UsuarioDto();
	 * 
	 * ModelAndView modelAndView = new ModelAndView();
	 * modelAndView.setViewName("admin/viewNewUser");
	 * modelAndView.addObject("usuarioDto", usuarioDto);
	 * modelAndView.addObject("listRoles",salaService.getSalas()); return
	 * modelAndView; }
	 */
	
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
	@RequestMapping(value="/salas", method = RequestMethod.GET)
	public ModelAndView viewListSalas(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/viewListSalas");
		
		modelAndView.addObject("listSalas",salasService.getSalas());
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
		modelAndView.setViewName("admin/viewNuevaReserva");
		return modelAndView;
	}
	

	
	
	
	
}
