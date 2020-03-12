package comics;

public class Revista {
	private int numeroEdicao;
	private int ano;
	private Caixa caixa;
	private Colecao colecao;
	private boolean emprestada;
	
	public Revista(int numeroEdicao, int ano, Caixa caixa, Colecao colecao) {
		this.setNumeroEdicao(numeroEdicao);
		this.setAno(ano);
		this.setCaixa(caixa);
		this.setColecao(colecao);
		this.setEmprestada(false);
	}
	
	//colecao
	//status emprestimo
	
	public int getNumeroEdicao() {
		return numeroEdicao;
	}
	public void setNumeroEdicao(int numeroEdicao) {
		this.numeroEdicao = numeroEdicao;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public Caixa getCaixa() {
		return caixa;
	}
	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}
	public Colecao getColecao() {
		return colecao;
	}
	public void setColecao(Colecao colecao) {
		this.colecao = colecao;
	}
	public boolean isEmprestada() {
		return emprestada;
	}
	public void setEmprestada(boolean emprestada) {
		this.emprestada = emprestada;
	}
}
