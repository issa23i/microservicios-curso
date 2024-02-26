package com.nttdata.microservicios.app.cursos.services;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nttdata.microservicios.app.cursos.models.entity.Curso;
import com.nttdata.microservicios.app.cursos.models.repository.CursoRepository;
import com.nttdata.microservicios.commons.services.CommonServiceImpl;
@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {

	@Override
	@Transactional(readOnly=true)
	public Curso findCursoByAlumnoId(Long id) {
		return repository.findCursoByAlumnoId(id);
	}
}
