package dominio;

public class Marca {
	@Override
	public String toString() {
		return nome +" Seguemento:"+seguemento +"ID:"+id;
	}
	private int id;
	private String nome;
	private String seguemento;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSegmento() {
		return seguemento;
	}
	public void setSegmento(String segmento) {
		this.seguemento = segmento;
	}
	
}
