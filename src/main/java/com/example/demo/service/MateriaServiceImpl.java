package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMateriaRespository;
import com.example.demo.repository.modelo.Materia;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MateriaServiceImpl implements IMateriaService{
	
	@Autowired
	private IMateriaRespository iMateriaRespository;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void guardar(Materia materia) {
		// TODO Auto-generated method stub
		this.iMateriaRespository.insertar(materia);
	}

	@Override
	public Materia buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.iMateriaRespository.seleccionarPorCodigo(codigo);
	}

}
