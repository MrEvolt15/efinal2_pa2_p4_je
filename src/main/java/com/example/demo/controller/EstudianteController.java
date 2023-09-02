package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;



@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {
	@Autowired
	private IEstudianteService estudianteService;
	
	
	//http://localhost:8080/webuce/estudiantes/guadar
	@PostMapping("/guardar")
	public String guardarEstudiante(Estudiante estudiante) {
		try {
			Estudiante e = new Estudiante();
			e.setCedula(estudiante.getCedula());
			e.setDireccion(estudiante.getDireccion());
			e.setNombre(estudiante.getNombre());
			this.estudianteService.guardar(e);
			return "redirect:/estudiantes/ingresar";
		} catch (Exception e) {
			return "redirect:/estudiantes/ingresar";
		}
	}
	//http://localhost:8080/webuce/estudiantes/ingresar
	@GetMapping("/ingresar")
	public String vistaIngresarEstudiante(Model modelo,Estudiante estudiante) {
		modelo.addAttribute("estudiante",estudiante);
		return"vistaEstudiante";
	}
	
}
