package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import com.example.demo.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Transactional
@Repository
public class MateriaRepositoryImpl implements IMateriaRespository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(materia);
	}

	@Override
	public Materia seleccionarPorCodigo(String codigo) {
		TypedQuery<Materia> query =this.entityManager.createQuery("Select m From Materia m Where m.codigo=:DatoCodigo", Materia.class);
		query.setParameter("DatoCodigo", codigo);
		return query.getSingleResult();
	}

}
