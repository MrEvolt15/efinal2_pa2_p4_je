package com.example.demo.service;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteService {
	public void guardar(Estudiante estudiante);
	public Estudiante buscarPorId(String id);
	public void borrar(Estudiante estudiante);
	
	public Estudiante buscarPorCedula(String cedula);
	
}
