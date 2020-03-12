package comics;

public class Caixa {
	private int numero;
	private String identificacaoEtiqueta;
	private String cor;
	
	public Caixa(int numero, String identificacaoEtiqueta, String cor) {
		this.setNumero(numero);
		this.setIdentificacaoEtiqueta(identificacaoEtiqueta);
		this.setCor(cor);
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getIdentificacaoEtiqueta() {
		return identificacaoEtiqueta;
	}
	public void setIdentificacaoEtiqueta(String identificacaoEtiqueta) {
		this.identificacaoEtiqueta = identificacaoEtiqueta;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
}
