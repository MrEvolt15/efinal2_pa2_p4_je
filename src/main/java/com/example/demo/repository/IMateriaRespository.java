package com.example.demo.repository;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaRespository {
	public void insertar(Materia materia);
	public Materia seleccionarPorCodigo(String codigo);
}
