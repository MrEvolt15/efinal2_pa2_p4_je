package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class EstudianteServiceImpl implements IEstudianteService{
	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(estudiante);
	}

	@Override
	public Estudiante buscarPorId(String id) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarPorId(id);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void borrar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.eliminar(estudiante);
	}

	@Override
	public Estudiante buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarPorCedula(cedula);
	}
	
}
