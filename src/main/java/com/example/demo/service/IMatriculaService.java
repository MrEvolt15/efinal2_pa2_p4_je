package com.example.demo.service;

import java.util.stream.Stream;

import com.example.demo.repository.modelo.Matricula;

public interface IMatriculaService {
	public void guardar(Matricula matriucla);
	public Matricula buscarPorId(Integer id);
	
	public void matricular(String cedula,Stream<String> codigosMateria);
}
