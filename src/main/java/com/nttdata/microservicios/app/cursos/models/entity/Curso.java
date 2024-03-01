package com.nttdata.microservicios.app.cursos.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nttdata.microservicios.commons.alumnos.models.entity.Alumno;
import com.nttdata.microservicios.commons.examenes.models.entity.Examen;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="cursos")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String nombre;
	@Column(name="create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	@JsonIgnoreProperties(value= {"curso"}, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CursoAlumno> cursoAlumnos;
	// @OneToMany(fetch = FetchType.LAZY)
	@Transient
	private List<Alumno> alumnos;
	@ManyToMany(fetch = FetchType.LAZY)
	public List<Examen> examenes;

	public Curso() {
		this.alumnos = new ArrayList<>();
		this.examenes = new ArrayList<>();
		this.cursoAlumnos = new ArrayList<>();
	}
	

	public List<Examen> getExamenes() {
		return examenes;
	}

	public void setExamenes(List<Examen> examenes) {
		this.examenes = examenes;
	}
	public void addExamenes(Examen examen) {
		this.examenes.add(examen);
	}
	
	public void removeExamen(Examen examen) {
		this.examenes.remove(examen);
	}
	public List<Alumno> getAlumnos() {
		return alumnos;
	}
	
	public void addAlumno(Alumno alumno) {
		this.alumnos.add(alumno);
	}
	public void removeAlumno(Alumno alumno) {
		this.alumnos.remove(alumno);
	}
	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	

	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}
	
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}


	public List<CursoAlumno> getCursoAlumnos() {
		return cursoAlumnos;
	}


	public void setCursoAlumnos(List<CursoAlumno> cursoAlumnos) {
		this.cursoAlumnos = cursoAlumnos;
	}
	public void addCursoAlumno(CursoAlumno cursoAlumno) {
		this.cursoAlumnos.add(cursoAlumno);
	}
	public void removeCursoAlumno(CursoAlumno cursoAlumno) {
		this.cursoAlumnos.remove(cursoAlumno);
	}
	
}
