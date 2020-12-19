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

import com.quantum.demo.dao.SorteoDAO;
import com.quantum.demo.model.Sorteo;
import com.quantum.demo.services.SorteoServicioImp;

@Controller
public class SorteoController {

	@Autowired
	SorteoServicioImp sDAO;

	@GetMapping({ "/", "/index" })
	public String list(Model model) {
		model.addAttribute("list", sDAO.findAll());
		return "index";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Validated Sorteo Sorteo, BindingResult result, Model model) {

		sDAO.save(Sorteo);

		return "redirect:index";

	}

	@RequestMapping(value = "/form/")
	public String crear(Model model) {
		Sorteo Sorteo = new Sorteo();
		model.addAttribute("Sorteo", Sorteo);

		return "form";

	}

	@RequestMapping(value = "/form/{id}")
	public String editar(@PathVariable(value = "id") String codigo, Model model) {
		Sorteo Sorteo = sDAO.findById(codigo);
		model.addAttribute("Sorteo", Sorteo);

		return "form";

	}

	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") String codigo, Model model) {
		Sorteo Sorteo = sDAO.findById(codigo);
		sDAO.deleteById(codigo);

		return "redirect:/index";

	}

}