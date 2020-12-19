package com.quantum.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quantum.demo.dao.PersonaDAO;
import com.quantum.demo.model.Persona;
import com.quantum.demo.services.PersonaServicioImp;

@Controller
public class PersonaController {

	@Autowired
	PersonaServicioImp pDAO;

	@GetMapping({ "/", "/index" })
	public String list(Model model) {
		model.addAttribute("list", pDAO.findAll());
		return "index";
	}

	@RequestMapping(value = "/formulario", method = RequestMethod.POST)
	public String guardar(@Validated Persona Persona, BindingResult result, Model model) {

		pDAO.save(Persona);

		return "redirect:index";

	}

	@RequestMapping(value = "/formulario/")
	public String crear(Model model) {
		Persona Persona = new Persona();
		model.addAttribute("Persona", Persona);

		return "formulario";

	}

	@RequestMapping(value = "/formulario/{id}")
	public String editar(@PathVariable(value = "id") String codigo, Model model) {
		Persona Persona = pDAO.findById(codigo);
		model.addAttribute("Persona", Persona);

		return "formulario";

	}

	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") String codigo, Model model) {
		Persona Persona = pDAO.findById(codigo);
		pDAO.deleteById(codigo);

		return "redirect:/index";

	}

}