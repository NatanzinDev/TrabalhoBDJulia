package dominio;

public class Cosmetico {
	private int id;
	@Override
	public String toString() {
		return "Nome: "+nome +" Tipo:"+tipo;
	}
	private double valor;
	private String nome;
	private String tipo;
	private int idmarca;
	
	public Cosmetico() {
		this.idmarca = 1;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getIdmarca() {
		return idmarca;
	}
	public void setIdmarca(int idmarca) {
		this.idmarca = idmarca;
	}
}
