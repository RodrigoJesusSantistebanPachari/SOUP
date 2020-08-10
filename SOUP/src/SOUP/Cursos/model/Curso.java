package SOUP.Cursos.model;

public class Curso {
	private int idCurso;
	private String nombre;
	private String profesor;
	private int a�o;
	private String semestre;
	private int turno;
	private int matricula;
	private int cui;

	public Curso(String nombre, String profesor, int a�o,String semestre,int turno, int matricula,int cui) {
		this.nombre = nombre;
		this.profesor = profesor;
		this.a�o = a�o;
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
		return a�o;
	}
	public void setAnio(int a�o) {
		this.a�o = a�o;
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
