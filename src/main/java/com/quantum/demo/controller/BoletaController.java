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

import com.quantum.demo.dao.BoletaDAO;
import com.quantum.demo.model.Boleta;
import com.quantum.demo.services.BoletaServicioImp;

@Controller
public class BoletaController {

	@Autowired
	BoletaServicioImp bDAO;

	@GetMapping({ "/", "/index" })
	public String list(Model model) {
		model.addAttribute("list", bDAO.findAll());
		return "index";
	}

	@RequestMapping(value = "/formulario", method = RequestMethod.POST)
	public String guardar(@Validated Boleta Boleta, BindingResult result, Model model) {

		bDAO.save(Boleta);

		return "redirect:index";

	}

	@RequestMapping(value = "/formulario/")
	public String crear(Model model) {
		Boleta Boleta = new Boleta();
		model.addAttribute("Boleta", Boleta);

		return "formulario";

	}

	@RequestMapping(value = "/formulario/{id}")
	public String editar(@PathVariable(value = "id") String codigo, Model model) {
		Boleta Boleta = bDAO.findById(codigo);
		model.addAttribute("Boleta", Boleta);

		return "formulario";

	}

	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") String codigo, Model model) {
		Boleta Boleta = bDAO.findById(codigo);
		bDAO.deleteById(codigo);

		return "redirect:/index";

	}

}