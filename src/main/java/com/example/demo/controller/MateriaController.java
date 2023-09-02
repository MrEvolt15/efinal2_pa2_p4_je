package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.IMateriaService;

@Controller
@RequestMapping("/materias")
public class MateriaController {

	@Autowired
	private IMateriaService iMateriaService;

	// http://localhost:8080/webuce/materias/guadar
	@PostMapping("/guardar")
	public String guardarMateria(Materia materia) {
		try {
			Materia m = new Materia();
			m.setCedulaProfesor(materia.getCedulaProfesor());
			m.setCodigo(materia.getCodigo());
			m.setNombre(materia.getNombre());
			m.setNumCreditos(materia.getNumCreditos());
			this.iMateriaService.guardar(m);

			return "redirect:/materias/ingresar";
		} catch (Exception e) {
			return "redirect:/materias/ingresar";
		}
	}

	// http://localhost:8080/webuce/materias/ingresar
	@GetMapping("/ingresar")
	public String vistaIngresarMateria(Model modelo, Materia materia) {
		modelo.addAttribute("materia", materia);
		return "vistaMateria";
	}

}
