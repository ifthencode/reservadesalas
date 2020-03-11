package controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entityes.Sala;
import repository.SalaRepository;

public class reservascontroller {
	private final SalaRepository salarepository;
	 @Autowired
	    public reservascontroller(SalaRepository salaRepository) {
	        this.salarepository = salaRepository;
	    }
	
	@RequestMapping(value="/Salas", method = RequestMethod.GET)
	public ModelAndView viewListAdmin(){
		
		ModelAndView modelAndView = new ModelAndView();
	
			 
		modelAndView.setViewName("viewListSalas");
	
		modelAndView.addObject("listsalas",salarepository.findAll());
		return modelAndView;
	}
	
	  
}
