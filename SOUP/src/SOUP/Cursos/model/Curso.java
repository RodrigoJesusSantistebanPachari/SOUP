package SOUP.Cursos.model;

public class Curso {
	private int idCurso;
	private String nombre;
	private String profesor;
	private int año;
	private String semestre;
	private int turno;
	private int matricula;
	private int cui;

	public Curso(String nombre, String profesor, int año,String semestre,int turno, int matricula,int cui) {
		this.nombre = nombre;
		this.profesor = profesor;
		this.año = año;
		this.semestre = semestre;
		this.matricula = matricula;
		this.turno = turno;
		this.cui = cui;

	}
	
	public int getId() {
		return idCurso;
	}
	public void setId(int id) {
		this.idCurso = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	
	public int getAnio() {
		return año;
	}
	public void setAnio(int año) {
		this.año = año;
	}
	
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	
	public int getTurno() {
		return turno;
	}
	public void setTurno(int turno) {
		this.turno = turno;
	}
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public int getCUI() {
		return cui;
	}
	public void setCUI(int cui) {
		this.cui = cui;
	}

	
}
