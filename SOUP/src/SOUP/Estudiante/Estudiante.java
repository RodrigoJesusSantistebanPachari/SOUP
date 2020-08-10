package SOUP.Estudiante;

public class Estudiante {
	private String nombre;
	private int cui;
	private int dni;
	private String correo;
	private int turno;
	private int id;
	private int idCurso;
	
	public Estudiante(int cui, String nombre,int dni, String correo) {
		this.nombre = nombre;
		this.cui = cui;
		this.dni = dni;
		this.correo = correo;

	}
	
	public Estudiante(int cui, String nombre, String correo, int turno,int id, int idCurso) {
		this.nombre = nombre;
		this.cui = cui;
		this.correo = correo;
		this.turno = turno;
		this.id = id;
		this.idCurso = idCurso;

	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getCUI() {
		return cui;
	}
	public void setCUI(int cui) {
		this.cui = cui;
	}
	
	public int getDNI() {
		return dni;
	}
	public void setDNI(int dni) {
		this.dni = dni;
	}
	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public int getTurno() {
		return turno;
	}
	public void setTurno(int turno) {
		this.turno = turno;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
		
	
}
