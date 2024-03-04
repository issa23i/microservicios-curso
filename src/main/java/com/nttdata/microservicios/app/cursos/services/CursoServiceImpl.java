package com.nttdata.microservicios.app.cursos.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nttdata.microservicios.app.cursos.clients.AlumnoFeignClient;
import com.nttdata.microservicios.app.cursos.clients.RespuestaFeignClient;
import com.nttdata.microservicios.app.cursos.models.entity.Curso;
import com.nttdata.microservicios.app.cursos.models.repository.CursoRepository;
import com.nttdata.microservicios.commons.alumnos.models.entity.Alumno;
import com.nttdata.microservicios.commons.services.CommonServiceImpl;
@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {

	@Autowired
	private RespuestaFeignClient respuestaFeignClient;
	
	@Autowired
	private AlumnoFeignClient alumnoFeignClient;
	
	@Override
	@Transactional(readOnly=true)
	public Curso findCursoByAlumnoId(Long id) {
		return repository.findCursoByAlumnoId(id);
	}

	@Override
	public Iterable<Long> obtenerExamenesIdconRespuestasAlumnoId(Long alumnoId) {
		return respuestaFeignClient.obtenerExamenesIdconRespuestasAlumnoId(alumnoId);
	}

	@Override
	public Iterable<Alumno> obtenerAlumnnosPorCurso(List<Long> ids) {
		return alumnoFeignClient.obtenerAlumnnosPorCurso(ids);
	}

	@Transactional
	@Override
	public void eliminarCursoAlumnoPorId(Long id) {
		repository.eliminarCursoAlumnoPorId(id);
	}
}
