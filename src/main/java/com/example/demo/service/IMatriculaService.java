package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Matricula;

public interface IMatriculaService {
	public void guardar(Matricula matriucla);
	public Matricula buscarPorId(Integer id);
	
	public void matricular(String cedula,List<String> codigosMateria);
}
