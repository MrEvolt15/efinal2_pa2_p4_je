package com.example.demo.controller;


import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Matricula;
import com.example.demo.service.IMatriculaService;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {
	@Autowired
	private IMatriculaService iMatriculaService;

	//http://localhost:8080/webuce/matriculas/ingresar
	@GetMapping("/ingresar")
	public String vistaIngresarEstudiante(Model modelo, Matricula matricula) {
		modelo.addAttribute("matricula", matricula);
		return "vistaMatricula";
	}
	@GetMapping("/lista")
	public String listarMatriculas(Model modelo, Matricula matricula) {
		modelo.addAttribute("matricula", matricula);
		return "vistaMatriculaTodo";
	}
	@PostMapping("/guardar")
	public String guardarMateria(String cedula,Stream<String> codigos) {
		try {		
			this.iMatriculaService.matricular(cedula, codigos);

			return "redirect:/materias/ingresar";
		} catch (Exception e) {
			return "redirect:/materias/ingresar";
		}
	}
}
