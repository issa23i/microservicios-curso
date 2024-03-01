package com.nttdata.microservicios.app.cursos.services;

import org.springframework.web.bind.annotation.PathVariable;

import com.nttdata.microservicios.app.cursos.models.entity.Curso;
import com.nttdata.microservicios.commons.services.CommonService;

public interface CursoService extends CommonService<Curso> {
	public Curso findCursoByAlumnoId(Long id);
	public Iterable<Long> obtenerExamenesIdconRespuestasAlumnoId(Long alumnoId);
}


