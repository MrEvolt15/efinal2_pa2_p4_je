package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.IMatriculaRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MatriculaServiceImpl implements IMatriculaService{
	@Autowired
	private IMatriculaRepository iMatriculaRepository;
	@Autowired
	private IEstudianteRepository estudianteRepository;
	@Autowired
	private IMateriaService iMateriaService;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void guardar(Matricula matriucla) {
		// TODO Auto-generated method stub
		this.iMatriculaRepository.insertar(matriucla);
	}

	@Override
	public Matricula buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.iMatriculaRepository.seleccionarPorId(id);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void matricular(String cedula, Stream<String> codigosMateria) {
		// TODO Auto-generated method stub
		Matricula m = new Matricula();
		Estudiante e = this.estudianteRepository.seleccionarPorCedula(cedula);
		codigosMateria.forEach(t -> {Materia ma = this.iMateriaService.buscarPorCodigo(t);
		m.setMateria(ma);
		m.setEstudiante(e);
		m.setFecha(LocalDate.now());
		this.iMatriculaRepository.insertar(m);});
		
	}

}
