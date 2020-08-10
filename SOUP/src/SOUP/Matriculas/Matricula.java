package SOUP.Matriculas;

public class Matricula {
	private int id;
	private int cui;
	private int idCurso;
	private int turno;

	public Matricula(int id, int cui, int idCurso, int turno) {
		this.id = id;

		this.cui = cui;
		
		this.idCurso= idCurso;

		this.turno = turno;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCUI() {
		return cui;
	}
	public void setCUI(int cui) {
		this.cui = cui;
	}
	
	public int getCurso() {
		return idCurso;
	}
	public void setCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	
	public int getTurno() {
		return turno;
	}
	public void setTurno(int turno) {
		this.turno = turno;
	}
	
}
