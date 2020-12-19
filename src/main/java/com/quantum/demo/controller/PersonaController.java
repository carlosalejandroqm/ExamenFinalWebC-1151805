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


@Controller
public class PersonaController {

	@Autowired
	PersonaDAO pDAO;

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



}