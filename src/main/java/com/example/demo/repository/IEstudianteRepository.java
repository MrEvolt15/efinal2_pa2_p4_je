package com.example.demo.repository;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteRepository {
	public void insertar(Estudiante estudiante);
	public Estudiante seleccionarPorId(String id);
	public void eliminar(Estudiante estudiante);
	public Estudiante seleccionarPorCedula(String cedula);
}
