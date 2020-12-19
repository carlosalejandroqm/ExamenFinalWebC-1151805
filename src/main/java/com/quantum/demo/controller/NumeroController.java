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

import com.quantum.demo.dao.NumeroDAO;
import com.quantum.demo.model.Numero;
import com.quantum.demo.services.NumeroServicioImp;

@Controller
public class NumeroController {

	@Autowired
	NumeroServicioImp nDAO;

	@GetMapping({ "/", "/index" })
	public String list(Model model) {
		model.addAttribute("list", nDAO.findAll());
		return "index";
	}

	@RequestMapping(value = "/formulario", method = RequestMethod.POST)
	public String guardar(@Validated Numero Numero, BindingResult result, Model model) {

		nDAO.save(Numero);

		return "redirect:index";

	}

	@RequestMapping(value = "/formulario/")
	public String crear(Model model) {
		Numero Numero = new Numero();
		model.addAttribute("Numero", Numero);

		return "formulario";

	}

	@RequestMapping(value = "/formulario/{id}")
	public String editar(@PathVariable(value = "id") String codigo, Model model) {
		Numero Numero = nDAO.findById(codigo);
		model.addAttribute("Numero", Numero);

		return "formulario";

	}

	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") String codigo, Model model) {
		Numero Numero = nDAO.findById(codigo);
		nDAO.deleteById(codigo);

		return "redirect:/index";

	}

}