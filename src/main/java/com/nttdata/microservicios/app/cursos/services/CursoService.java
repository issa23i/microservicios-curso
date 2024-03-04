package com.nttdata.microservicios.app.cursos.services;

import java.util.List;

import com.nttdata.microservicios.app.cursos.models.entity.Curso;
import com.nttdata.microservicios.commons.alumnos.models.entity.Alumno;
import com.nttdata.microservicios.commons.services.CommonService;

public interface CursoService extends CommonService<Curso> {
	
	public Curso findCursoByAlumnoId(Long id);
	
	public Iterable<Long> obtenerExamenesIdconRespuestasAlumnoId(Long alumnoId);
	
	public Iterable<Alumno> obtenerAlumnnosPorCurso( List<Long> ids);
	
	public void eliminarCursoAlumnoPorId(Long id);
}


