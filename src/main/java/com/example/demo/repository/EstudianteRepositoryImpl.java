package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import com.example.demo.repository.modelo.Estudiante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Transactional
@Repository
public class EstudianteRepositoryImpl implements IEstudianteRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);
	}

	@Override
	public Estudiante seleccionarPorId(String id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void eliminar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.remove(estudiante);
	}

	@Override
	public Estudiante seleccionarPorCedula(String cedula) {
		TypedQuery<Estudiante> query =this.entityManager.createQuery("Select e From Estudiante e Where e.cedula=:DatoCedula", Estudiante.class);
		query.setParameter("DatoCedula", cedula);
		return query.getSingleResult();
	}
	
}
