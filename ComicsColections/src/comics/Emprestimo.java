package comics;

import java.util.Date;

public class Emprestimo {
	private Date dataEmprestimo;
	private Date dataDevolucao;
	private Revista revista;
	private Amigo amigo;
	
	public Emprestimo(Date dataEmprestimo, Date dataDevolucao, Revista revista, Amigo amigo) {
		this.setDataEmprestimo(dataEmprestimo);
		this.setDataDevolucao(dataDevolucao);
		this.setRevista(revista);
		this.setAmigo(amigo);		
	}
	
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public Revista getRevista() {
		return revista;
	}
	public void setRevista(Revista revista) {
		this.revista = revista;
	}
	public Amigo getAmigo() {
		return amigo;
	}
	public void setAmigo(Amigo amigo) {
		this.amigo = amigo;
	}
	
	
	
	
	
}
